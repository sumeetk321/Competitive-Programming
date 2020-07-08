/*
ID: sumeetk1
LANG: JAVA
TASK: crypt1
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class crypt1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		int setsize = Integer.parseInt(br.readLine());
		int[] digits = new int[setsize];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < setsize; i++) {
			digits[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(digits);
		// very efficient
		int solutions = 0;
		for (int a : digits) {
			for (int b : digits) {
				for (int c : digits) {
					for (int d : digits) {
						for (int e : digits) {
							String num1 = a + "" + b + "" + c + "";
							String num2 = d + "" + e + "";
							String partial1 = Integer
									.toString(Character.getNumericValue(num2.charAt(1)) * Integer.parseInt(num1));
							String partial2 = Integer
									.toString(Character.getNumericValue(num2.charAt(0)) * Integer.parseInt(num1));
							String testmult = Integer.toString(Integer.parseInt(num1) * Integer.parseInt(num2));
							if ((partial1.length() == 3 && partial2.length() == 3)
									&& (isWithinDigits(partial1, digits) && isWithinDigits(partial2, digits))
									&& (isWithinDigits(testmult, digits))) {
								solutions++;
							}
						}
					}
				}
			}
		}
		out.println(solutions);
		out.close();
	}

	public static boolean isWithinDigits(String in, int[] digits) {
		for (int i = 0; i < in.length(); i++) {
			if (Arrays.binarySearch(digits, Character.getNumericValue(in.charAt(i))) <= -1) {
				return false;
			}
		}
		return true;
	}

}
