import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_ACSLKenKenJr {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] in = scan.nextLine().split(", ");
		String[] places = scan.nextLine().split(", ");
		int sections = Integer.parseInt(in[0]);
		String[] sections1 = new String[sections];
		for (int i = 0; i < sections; i++) {
			sections1[i] = "";
		}
		int sectionnum = 0;
		for (int i = 1; i < in.length; i++) {
			if (in[i].contains("+")) {
				sections1[sectionnum] += in[i];
				sectionnum++;
			} else if (in[i].contains("#")) {
				sections1[sectionnum] += in[i];
				sectionnum++;
			} else {
				sections1[sectionnum] += in[i];
			}
		}

		String[] grids = { "123312231", "132213321", "123231312", "132321213", "213132321", "213321132", "231312123",
				"231123312", "312123231", "321213132", "321132213" };
		for (String x : grids) {
			boolean ok = true;
			for (String y : sections1) {
				if (y.contains("#")) {
					if (x.charAt(Character.getNumericValue(y.charAt(0)) - 1) == y.charAt(1)) {
						continue;
					} else {
						ok = false;
						break;
					}
				} else if (y.contains("+")) {
					int sum = 0;
					for (int i = 0; i < y.length() - 2; i++) {
						sum += Character.getNumericValue(x.charAt(Character.getNumericValue(y.charAt(i) - 1)));
					}
					if (sum == Character.getNumericValue(y.charAt(y.length() - 2))) {
						continue;
					} else {
						ok = false;
						break;
					}
				}
			}

			if (ok) {
				for (String z : places) {
					System.out.println(x.charAt(Integer.parseInt(z) - 1));
				}
			}
		}

	}
}