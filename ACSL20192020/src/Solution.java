import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'passort' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts STRING
	 * line as parameter.
	 */

	public static int passort(String line) {
		String toAlphaNum = "";
		for (int i = 0; i < line.length(); i++) {
			char testchar = line.charAt(i);
			if (Character.isLetterOrDigit(testchar)) {
				toAlphaNum += testchar;
			}
		}
		// System.out.println(toAlphaNum);
		String[] test = toAlphaNum.split("");
		boolean addone = false;
		ArrayList<String> contains = new ArrayList<String>();
		for (int i = 0; i < test.length; i++) {

			int count = 0;
			for (String x : contains) {
				if (x.startsWith(test[i])) {
					count++;
					if(toAlphaNum.length()%2==0) {
						addone = true;
					}
				}
			}
			test[i] = test[i] + "" + count;
			contains.add(test[i]);
		}

		// System.out.println(Arrays.toString(test));
		String[] sorted = new String[test.length];
		for (int i = 0; i < test.length; i++) {
			sorted[i] = test[i];
		}
		Arrays.sort(sorted);

		int swaps = 0;
		loop: while (true) {

			String minchar = "}";
			int minind = 100;
			for (int i = 0; i < test.length; i++) {
				if (sorted[i].equals(test[i])) {
					continue;
				} else {
					if (test[i].charAt(0) < minchar.charAt(0)) {
						minchar = test[i];
						minind = i;
					}
				}
			}
			for (int i = 0; i < test.length; i++) {
				if (sorted[i].equals(minchar) /*&& (!(sorted[i].equals(test[i])))*/) {
					String tmp = test[i];
					test[i] = test[minind];
					test[minind] = tmp;
					swaps++;
					break;
				}
			}
			 //System.out.println(Arrays.toString(test));

			boolean isSorted = true;
			for (int i = 0; i < test.length; i++) {
				if (sorted[i].equals(test[i])) {
					continue;
				} else {
					isSorted = false;
				}
			}
			if (isSorted)
				break;
			String maxchar = "!";
			int maxind = -100;
			for (int i = test.length - 1; i >= 0; i--) {
				if (sorted[i].equals(test[i])) {
					continue;
				} else {
					if (test[i].charAt(0) > maxchar.charAt(0)) {
						maxchar = test[i];
						maxind = i;
					}
				}
			}
			for (int i = test.length-1; i >=0; i--) {
				if (sorted[i].equals(maxchar) /*&& (!(sorted[i].equals(test[i])))*/) {
					String tmp = test[i];
					test[i] = test[maxind];
					test[maxind] = tmp;
					swaps++;
					break;
				}
			}
			 //System.out.println(Arrays.toString(test));

			isSorted = true;
			for (int i = test.length - 1; i >= 0; i--) {
				if (sorted[i].equals(test[i])) {
					continue;
				} else {
					isSorted = false;
				}
			}
			if (isSorted)
				break;
		}
		return (addone?swaps+1:swaps);
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String line = bufferedReader.readLine();
		System.out.println(function(function(function(function(30)))));
		System.out.println(function1(14, 20));
		int sum = 0;
		for(int i = 50; i <= 64; i++) {
			String str = Integer.toBinaryString(i);
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j)=='1') {
					sum++;
				}
			}
		}
		System.out.println(sum);
		System.out.println("wpd");
		int y = 2020;
		int s = 0;
		int n = 0;
		int f = 0;
		for(int a = 0; a <= y; a++) {
			if(a!=0&&y%a==0) {
				s = s+a;
				n = n+1;
			}
			if(s>y&&f==0) {
				System.out.println(n-1);
				f = 1;
			}
		}
		
		boolean bool = true;
		int[] arr = {13, 24, 37, 45, 51, 60, 74, 0};
		int ind = 0;
		for(int x : arr) {
			top(x);
		}
		bufferedReader.close();
		// bufferedWriter.close();
	}
	public static int function(int x) {
		if(x%2==1&&x%3==0) {
			return 2*function((x/2))-3;
		} else if(x%2==0&&x%3==0) {
			return function(x+3)+1;
		} else {
			return x-1;
		}
	}
	public static int function1(int x, int y) {
		if(x<y) {
			return function1(x+1, y-2)+function1(y,x)+1;
		} else if(x==y) {
			return function1(function1(x/2, y), x/2)-3;
		} else if(x>y) {
			return x-y;
		}
		return 0;
	}
	public static int top(int n) {
		if(n==0) {
			return 0;
		}
		int b = n/10;
		int x = b*10;
		int c = n-x;
		int m = b+c;
		int y = (m/3)*3;
		if(m-y==0) {
			System.out.println("down "+n);
		} else {
			return -1;
		}
		return y;
	}
}
