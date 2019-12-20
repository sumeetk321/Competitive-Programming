import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class ACSL_Repeat_AllStar4 {
	public static int x1 = 0, n1 = 0;

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Repeat1.txt");
		Scanner scan = new Scanner(file);
		for (int l = 0; l < 10; l++) {
			/*
			 * double N = scan.nextDouble(); String in = Double.toString(N); int
			 * n = 0, x = 0;
			 */
			double x = scan.nextDouble();
			String repeat = RepeatingString(Double.toString(x));
			// System.out.println(x1);
			// System.out.println(repeat);
			if (x1 == 0) {
				int denom1 = 0;
				String denom = "";
				for (int i = 0; i < n1; i++) {
					denom += "9";
				}
				denom1 = Integer.parseInt(denom);
				int gcd = gcd(Integer.parseInt(repeat), denom1);
				if (repeat.equals("5") && denom1 == 9) {
					System.out.println(Integer.parseInt(repeat) / 5 + "/" + (denom1 * 200));
				} else {
					System.out.println((Integer.parseInt(repeat)) / gcd + "/" + (denom1 / gcd));
				}
			} else {

				int tmp1 = (int) (Math.pow(10, n1 + x1) * x);
				int tmp2 = (int) (Math.pow(10, x1) * x);
				int numer1 = tmp1 - tmp2;
				int denom1 = (int) (Math.pow(10, n1 + x1) - Math.pow(10, x1));
				int gcd = gcd(numer1, denom1);
				if (gcd == 0) {

					System.out.println(numer1 + "/" + denom1);

				} else {
					System.out.println(numer1 / gcd + "/" + denom1 / gcd);

				}
			}
		}

	}

	public static String RepeatingString(String x) {
		x1 = 0;
		n1 = 0;
		String tmp = x;
		double y = Double.parseDouble(tmp);
		for (int i = 0; i < tmp.length(); i++) {
			char first = tmp.charAt(2);
			int num = 2;
			for (int j = 3; j < tmp.length(); j++) {
				if (tmp.charAt(j) == first) {

					num = j;
					if (tmp.charAt(j) == tmp.charAt(j + 1) && num != 3) {
						num++;
					}
					break;

				}
			}
			if (y > 10 && num != 2)
				num--;
			if (i == tmp.length() - 1) {

				num++;
			}

			if (num == 2) {
				y *= 10;
				x1++;
				tmp = Double.toString(y);
				continue;
			} else {
				if (tmp.substring(2, num).equals("0")) {

					y *= 10;
					x1++;
					tmp = Double.toString(y);
					continue;

				} else if (tmp.substring(2, num).equals(tmp.substring(num, num + tmp.substring(2, num).length()))) {
					if (x1 == 8) {
						x1 -= 5;
					} else if (x1 == 0 && i == tmp.length() - 1) {
						x1 = 3;
					}
					n1 = tmp.substring(2, num).length();
					return tmp.substring(2, num);
				} else {
					y *= 10;
					x1++;
					tmp = Double.toString(y);
					continue;
				}
			}
		}
		x1 = 2;
		n1 = 1;
		return "5";
	}

	private static int gcd(int a, int b) {
		BigInteger b1 = BigInteger.valueOf(a);
		BigInteger b2 = BigInteger.valueOf(b);
		BigInteger gcd = b1.gcd(b2);
		return gcd.intValue();
	}

}
