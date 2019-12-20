import java.util.*;
import java.io.*;

public class PermuteDigits {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		String a = br.readLine();
		String b = br.readLine();
		int[] arr1 = new int[b.length()];
		int[] arr2 = new int[b.length()];
		for (int i = 0; i < b.length(); i++) {
			if (i >= a.length()) {
				arr1[i] = 0;
			} else {
				arr1[i] = Character.getNumericValue(a.charAt(i));
				arr2[i] = Character.getNumericValue(b.charAt(i));
			}
		}
		Arrays.sort(arr1);
		String output = "";
		boolean less = false;
		for (int i = 0; i < b.length(); i++) {
			int test = Character.getNumericValue(b.charAt(i));
			int max = Integer.MIN_VALUE;
			int ind = 0;
			for (int j = 0; j < b.length(); j++) {
				if (less) {
					max = arr1[b.length() - 1];
					ind = b.length() - 1;
				} else if (arr1[j] > max && arr1[j] <= test) {
					max = arr1[j];
					ind = j;
				}
			}
			if (arr1[ind] < test) {
				less = true;
			}
			arr1[ind] = -1;
			output += max;
		}
		out.println(Integer.parseInt(output));
		out.close();
	}
}