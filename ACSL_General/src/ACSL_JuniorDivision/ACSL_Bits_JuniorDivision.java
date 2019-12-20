package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ACSL_Bits_JuniorDivision {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("Bits1.txt");
		Scanner scan = new Scanner(file);

		for (int i = 0; i < 5; i++) {

			String in = scan.nextLine();
			int occs = 0;
			for (int j = 0; j < in.length(); j++) {
				if (in.charAt(j) == '*') {
					occs++;
				}
			}

			switch (occs) {
			case 0:
				System.out.println(in);
				break;
			case 1:
				String out1 = "", out2 = "";
				for (int j = 0; j < in.length(); j++) {
					if (in.charAt(j) == '*') {
						out1 += '0';
						out2 += '1';
					} else {
						out1 += in.charAt(j);
						out2 += in.charAt(j);
					}

				}
				System.out.println(out1 + ", " + out2);
				break;
			case 2:
				String str1 = "", str2 = "", str3 = "", str4 = "";
				boolean touched = false;
				for (int j = 0; j < in.length(); j++) {
					if (in.charAt(j) == '*') {
						if (touched) {
							str1 += '0';
							str2 += '1';
							str3 += '0';
							str4 += '1';
						} else {
							str1 += '0';
							str2 += '0';
							str3 += '1';
							str4 += '1';
						}
						touched = true;
					} else {
						str1 += in.charAt(j);
						str2 += in.charAt(j);
						str3 += in.charAt(j);
						str4 += in.charAt(j);
					}

				}

				System.out.println(str1 + ", " + str2 + ", " + str3 + ", " + str4);
				break;

			}

			System.out.println("\n");

		}
	}

}
