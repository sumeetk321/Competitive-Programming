package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ACSL_HAIRYCONICJUNIOR_JuniorDivision {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("HairyConicJunior2.txt");
		Scanner scan = new Scanner(file);
		for (int i = 0; i < 5; i++) {
			String x = scan.nextLine();
			System.out.print(ShapeTester(x) + ", ");
			if (ShapeTester(x).equals("Circle")) {
				System.out.print(circleSolve(x));
			} else {
				System.out.print(ellipseSolve(x));
			}

			System.out.println("\n");
		}

	}

	public static String ShapeTester(String a) {
		String[] coef = a.split(", ");

		if (coef[0].equals(coef[2])) {
			return "Circle";
		} else {
			return "Ellipse";
		}
	}

	public static String circleSolve(String a) {
		int r = 0;
		String[] coef = a.split(", ");

		String[] eq = { coef[0], coef[3], coef[2], coef[4] };
		int div1 = 1;
		int div2 = 2;
		int val = -1 * Integer.parseInt(coef[5]);
		int coord1 = 0;
		int coord2 = 0;
		if ((!coef[0].equals("0")) && (!coef[3].equals("0"))) {

			for (int i = Math.max(Integer.parseInt(coef[0]), Integer.parseInt(coef[3])); i >= 2; i--) {
				if (Integer.parseInt(coef[0]) % i == 0 && Integer.parseInt(coef[3]) % i == 0) {
					coef[0] = String.valueOf(Integer.parseInt(coef[0]) / i);
					coef[3] = String.valueOf(Integer.parseInt(coef[3]) / i);
					div1 *= i;
				}
			}
		}
		if ((!coef[2].equals("0")) && (!coef[4].equals("0"))) {

			for (int i = Math.max(Integer.parseInt(coef[2]), Integer.parseInt(coef[4])); i >= 2; i--) {
				if (Integer.parseInt(coef[2]) % i == 0 && Integer.parseInt(coef[4]) % i == 0) {
					coef[2] = String.valueOf(Integer.parseInt(coef[2]) / i);
					coef[4] = String.valueOf(Integer.parseInt(coef[4]) / i);
					div2 *= i;
				}
			}
		}

		for (int i = Math.max(Integer.parseInt(coef[0]), Integer.parseInt(coef[2])); i >= 2; i--) {
			if (Integer.parseInt(coef[0]) % i == 0 && Integer.parseInt(coef[2]) % i == 0) {
				if ((!coef[3].equals("0")) || (!coef[4].equals("0"))) {
					for (int j = Math.max(Integer.parseInt(coef[3]), Integer.parseInt(coef[4])); j >= 2; j--) {
						if (Integer.parseInt(coef[3]) % j == 0 && Integer.parseInt(coef[4]) % j == 0) {
							coef[3] = String.valueOf(Integer.parseInt(coef[3]) / j);
							coef[4] = String.valueOf(Integer.parseInt(coef[4]) / j);
						}
					}
				}
				coef[0] = String.valueOf(Integer.parseInt(coef[0]) / i);
				coef[2] = String.valueOf(Integer.parseInt(coef[2]) / i);
				val /= i;
				break;
			}
		}
		if (div1 * Math.pow(Integer.parseInt(coef[3]) / 2, 2) == 0) {
			div1 = (Integer.parseInt(coef[0]));
		}
		if (div2 * Math.pow(Integer.parseInt(coef[4]) / 2, 2) == 0) {
			div2 = (Integer.parseInt(coef[2]));
		}
		val += (Math.pow(Integer.parseInt(coef[3]) / 2, 2)) + (Math.pow(Integer.parseInt(coef[4]) / 2, 2));

		r = (int) Math.sqrt(val);

		if (Integer.parseInt(coef[3]) >= 0) {
			coord1 = -1 * Integer.parseInt(coef[3]) / 2;
		} else if (Integer.parseInt(coef[3]) < 0) {
			coord1 = -1 * Integer.parseInt(coef[3]) / 2;
		}

		if (Integer.parseInt(coef[4]) >= 0) {
			coord2 = -1 * Integer.parseInt(coef[4]) / 2;
		} else if (Integer.parseInt(coef[4]) < 0) {
			coord2 = -1 * Integer.parseInt(coef[4]) / 2;
		}

		return ("(" + coord1 + ", " + coord2 + "), " + r);
	}

	public static String ellipseSolve(String a) {
		int r = 0;
		int div1 = 1;
		int div2 = 1;
		String[] coef = a.split(", ");

		String[] eq = { coef[0], coef[3], coef[2], coef[4] };
		int val = -1 * Integer.parseInt(coef[5]);
		int coord1 = 0;
		int coord2 = 0;
		if ((!coef[0].equals("0")) && (!coef[3].equals("0"))) {

			for (int i = Math.max(Integer.parseInt(coef[0]), Integer.parseInt(coef[3])); i >= 2; i--) {
				if (Integer.parseInt(coef[0]) % i == 0 && Integer.parseInt(coef[3]) % i == 0) {
					coef[0] = String.valueOf(Integer.parseInt(coef[0]) / i);
					coef[3] = String.valueOf(Integer.parseInt(coef[3]) / i);
					div1 *= i;
				}
			}
		}
		if ((!coef[2].equals("0")) && (!coef[4].equals("0"))) {

			for (int i = Math.max(Integer.parseInt(coef[2]), Integer.parseInt(coef[4])); i >= 2; i--) {
				if (Integer.parseInt(coef[2]) % i == 0 && Integer.parseInt(coef[4]) % i == 0) {
					coef[2] = String.valueOf(Integer.parseInt(coef[2]) / i);
					coef[4] = String.valueOf(Integer.parseInt(coef[4]) / i);
					div2 *= i;
				}
			}
		}

		for (int i = Math.max(Integer.parseInt(coef[0]), Integer.parseInt(coef[2])); i >= 2; i--) {
			if (Integer.parseInt(coef[0]) % i == 0 && Integer.parseInt(coef[2]) % i == 0) {
				if ((!coef[3].equals("0")) || (!coef[4].equals("0"))) {
					for (int j = Math.max(Integer.parseInt(coef[3]), Integer.parseInt(coef[4])); j >= 2; j--) {
						if (Integer.parseInt(coef[3]) % j == 0 && Integer.parseInt(coef[4]) % j == 0) {
							coef[3] = String.valueOf(Integer.parseInt(coef[3]) / j);
							coef[4] = String.valueOf(Integer.parseInt(coef[4]) / j);
						}
					}
				}
				coef[0] = String.valueOf(Integer.parseInt(coef[0]) / i);
				coef[2] = String.valueOf(Integer.parseInt(coef[2]) / i);
				val /= i;
				break;
			}
		}
		if (div1 * Math.pow(Integer.parseInt(coef[3]) / 2, 2) == 0) {
			div1 = (Integer.parseInt(coef[0]));
		}
		if (div2 * Math.pow(Integer.parseInt(coef[4]) / 2, 2) == 0) {
			div2 = (Integer.parseInt(coef[2]));
		}
		val += (div1 * Math.pow(Integer.parseInt(coef[3]) / 2, 2))
				+ (div2 * Math.pow(Integer.parseInt(coef[4]) / 2, 2));
		r = (int) ((int) 2 * Math.sqrt(Math.max(val / div1, val / div2)));

		if (Integer.parseInt(coef[3]) >= 0) {
			coord1 = -1 * Integer.parseInt(coef[3]) / 2;
		} else if (Integer.parseInt(coef[3]) < 0) {
			coord1 = -1 * Integer.parseInt(coef[3]) / 2;
		}

		if (Integer.parseInt(coef[4]) >= 0) {
			coord2 = -1 * Integer.parseInt(coef[4]) / 2;
		} else if (Integer.parseInt(coef[4]) < 0) {
			coord2 = -1 * Integer.parseInt(coef[4]) / 2;
		}

		return ("(" + coord1 + ", " + coord2 + "), " + r);
	}
}
