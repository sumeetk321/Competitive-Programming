package ACSL_IntermediateDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ACSL_PRINTFORMATTING_IntermediateDivision {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("PRINTFORMATTINGI1.txt");
		Scanner scan = new Scanner(file);
		
		for (int i = 0; i < 5; i++) {
			String[] in = scan.nextLine().split(", ");
			String str = in[1];
			String formatstr = in[0];
			String tmp1 = str, tmp2 = "";
			if (formatstr.contains("$")) {
				tmp1 = "$" + tmp1;
			}

			if (formatstr.contains(".")) {
				int diff1 = formatstr.indexOf(".") - tmp1.indexOf(".") - 1,
						diff2 = (formatstr.length() - formatstr.indexOf(".") - 1)
								- (tmp1.length() - tmp1.indexOf(".") - 1);

				for (int k = 0; k < diff1; k++) {
					tmp2 += "*";
				}
				tmp1 = tmp2 + tmp1;
				if (diff2 < 0) {
					int test = Integer.parseInt(tmp1.substring(tmp1.indexOf(".") + 1));
					test = (int) Math.round(test / (Math.pow(10, Math.abs(diff2))));
					for (int k = 0; k <= tmp1.indexOf("."); k++) {
						tmp2 += tmp1.charAt(k);
					}
					tmp1 = tmp2 + Integer.toString(test);
					tmp2 = "";
				} else {
					for (int k = 0; k < diff2; k++) {
						tmp1 = tmp1 + "0";
					}
				}
			}

			if (formatstr.contains(",")) {
				int x = -1;
				for (int k = tmp1.length() - 1; k > -1; k--) {
					x++;
					if (tmp1.charAt(k) == '*')
						tmp2 += "*";
					if (x % 3 == 0 && x != 0) {
						tmp2 += ",";
					}
					tmp2 += tmp1.charAt(k);
				}
				tmp1 = new StringBuffer(tmp2).reverse().toString();
				tmp2 = "";
			}
			int diff = formatstr.length() - tmp1.length();
			for (int k = 0; k < diff; k++) {
				tmp2 += "*";
			}
			tmp1 = tmp2 + tmp1;
			tmp2 = "";

			System.out.println(tmp1);

		}

	}

}
