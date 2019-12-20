package ACSL_IntermediateDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_Bits_IntermediateDivision {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("BitsI2.txt");
		Scanner scan = new Scanner(file);
		for (int i = 0; i < 5; i++) {
			ArrayList<String> matches = new ArrayList<String>();

			String[] in = scan.nextLine().split(", ");
			String[] bitstrs = new String[Integer.parseInt(in[1])];
			for (int j = 2; j < in.length; j++) {
				bitstrs[j - 2] = in[j];
			}
			String bitstr = in[0];
			for (int l = 0; l < bitstrs.length; l++) {
				boolean match = true;
				for (int j = 0; j < bitstr.length(); j++) {
					if (bitstr.charAt(j) == '*') {
						continue;
					} else if (bitstr.charAt(j) == bitstrs[l].charAt(j)) {
						continue;
					} else {
						match = false;
						break;
					}

				}
				if (match) {
					matches.add(bitstrs[l]);
				}
			}
			if (matches.size() == 0) {
				System.out.print("NONE");
			} else {
				for (String x : matches) {
					System.out.print(x + " ");
				}
			}
			System.out.println("\n");

		}
	}

}
