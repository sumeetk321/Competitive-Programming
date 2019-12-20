import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.script.ScriptEngineManager;

public class Radical {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Radical.txt");
		Scanner scan = new Scanner(file);
		for (int x = 0; x < 2; x++) {
			int num;
			num = (x==0?6:10);
			int bound;
			bound = (x==0?2:5);
			for (int i = 0; i < num; i++) {
				if (i < bound) {
					String[] in = scan.nextLine().split(", ");
					boolean imaginary = false;
					int a = Integer.parseInt(in[0]);
					int b = Integer.parseInt(in[1]);
					int c = Integer.parseInt(in[2]);
					if (c < 0) {
						imaginary = true;
						c = -c;
					}
					System.out.println(simplify(a, b, c, imaginary));
				} else {
					String[] in = scan.nextLine().split(", ");
					int a1 = Integer.parseInt(in[0]);
					int b1 = Integer.parseInt(in[1]);
					int c1 = Integer.parseInt(in[2]);
					int a2 = Integer.parseInt(in[3]);
					int b2 = Integer.parseInt(in[4]);
					int c2 = Integer.parseInt(in[5]);
					boolean imaginary1 = false;
					if (c1 < 0) {
						imaginary1 = true;
						c1 = -c1;
					}
					boolean imaginary2 = false;
					if (c2 < 0) {
						imaginary2 = true;
						c2 = -c2;
					}
					String s1 = simplify(a1, b1, c1, imaginary1);
					String s2 = simplify(a2, b2, c2, imaginary2);
					String[] s1spl = s1.split(", ");
					String[] s2spl = s2.split(", ");
					a1 = Integer.parseInt(s1spl[0]);
					b1 = Integer
							.parseInt(s1spl[1].contains("i") ? s1spl[1].substring(0, s1spl[1].length() - 1) : s1spl[1]);
					c1 = Integer.parseInt(s1spl[2]);
					a2 = Integer.parseInt(s2spl[0]);
					b2 = Integer
							.parseInt(s2spl[1].contains("i") ? s2spl[1].substring(0, s2spl[1].length() - 1) : s2spl[1]);
					c2 = Integer.parseInt(s2spl[2]);
					String operator = in[6];
					switch (operator) {
					case "+":
						System.out.println(add(a1, b1, c1, a2, b2, c2, imaginary1));
						break;
					case "-":
						System.out.println(subtract(a1, b1, c1, a2, b2, c2, imaginary1));
						break;
					case "*":
						System.out.println(multiply(a1, b1, c1, a2, b2, c2, imaginary1));
						break;
					case "/":
						System.out.println(divide(a1, b1, c1, a2, b2, c2, imaginary1));
						break;
					}
				}
			}
		}
	}

	public static boolean isSquare(int in) {
		return ((int) Math.sqrt(in) == Math.sqrt(in));
	}

	public static ArrayList<Integer> factors(int in) {
		ArrayList<Integer> out = new ArrayList<Integer>();
		for (int i = 2; i < in; i++) {
			if (in % i == 0) {
				out.add(i);
			}
		}
		Collections.sort(out);
		Collections.reverse(out);
		return out;
	}

	public static String simplify(int a, int b, int c, boolean imaginary) {
		if (isSquare(c)) {
			if (imaginary) {
				return "0, " + (((int) Math.sqrt(c) * b) + a) + "i, 0";
			}
			return (((int) Math.sqrt(c) * b) + a) + ", 0, 0";
		} else {
			for (int j : factors(c)) {
				if (isSquare(j)) {
					return (imaginary ? (a + ", " + (b * (int) Math.sqrt(j)) + "i, " + (c / j))
							: (a + ", " + (b * (int) Math.sqrt(j)) + ", " + (c / j)));
				}
			}
		}
		return a + ", " + b + ", " + c;
	}

	public static String add(int a1, int b1, int c1, int a2, int b2, int c2, boolean imaginary) {
		return (imaginary ? (a1 + a2) + ", " + (b1 + b2) + "i, " + (c1) : (a1 + a2) + ", " + (b1 + b2) + ", " + (c1));
	}

	public static String subtract(int a1, int b1, int c1, int a2, int b2, int c2, boolean imaginary) {
		return (imaginary ? (a1 - a2) + ", " + (b1 - b2) + "i, " + (c1) : (a1 - a2) + ", " + (b1 - b2) + ", " + (c1));
	}

	public static String multiply(int a1, int b1, int c1, int a2, int b2, int c2, boolean imaginary) {
		int a = a1 * a2;
		int coef1 = a1 * b2;
		int coef2 = a2 * b1;
		int add1 = b1 * b2 * c1;
		return (imaginary ? (a - add1) + ", " + (coef1 + coef2) + "i, " + (-c1)
				: (a + add1) + ", " + (coef1 + coef2) + ", " + (c1));
	}

	public static String divide(int a1, int b1, int c1, int a2, int b2, int c2, boolean imaginary) {
		String num = multiply(a1, b1, c1, a2, -b2, c2, imaginary);
		String denom = multiply(a2, b2, c2, a2, -b2, c2, imaginary);
		String[] dsplit = denom.split(", ");
		int div = Integer.parseInt(dsplit[0]);
		String[] nsplit = num.split(", ");
		int a = Integer.parseInt(nsplit[0]);
		int b = Integer.parseInt(nsplit[1]);
		int c = Integer.parseInt(nsplit[2]);
		return (imaginary ? (a / div) + ", " + (b / div) + "i, " + (c) : (a / div) + ", " + (b / div) + ", " + (c));
	}
}
