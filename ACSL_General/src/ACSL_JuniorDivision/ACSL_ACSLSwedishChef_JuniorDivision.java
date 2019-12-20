package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ACSL_ACSLSwedishChef_JuniorDivision {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("SwedishChef2.txt");
		Scanner scan = new Scanner(file);

		String eng;
		String swe;

		for (int i = 0; i < 5; i++) {

			eng = scan.nextLine();
			swe = "";
			for (int j = 0; j < eng.length(); j++) {
				if (eng.charAt(j) == 'A' && j < eng.length() - 1) {
					if (eng.charAt(j + 1) == 'N') {
						swe += "UN";
						j++;
					} else if (eng.charAt(j + 1) == 'U') {
						j++;
						swe += "OO";
					} else {
						swe += "E";
					}
				} else if (eng.charAt(j) == 'O') {
					if (j < eng.length() - 1 && eng.charAt(j + 1) == 'W') {
						j++;
						swe += "OO";
					} else {
						swe += "U";
					}
				} else if (eng.charAt(j) == 'I' && j > 0) {
					swe += "EE";
				} else if (eng.charAt(j) == 'E') {
					if (j == eng.length() - 2 && eng.charAt(j + 1) == 'N') {
						j++;
						swe += "EE";
					} else if (j == eng.length() - 1) {
						swe += "E-A";
					} else if (j == 0) {
						swe += "I";
					} else {
						swe += "E";
					}
				} else if (eng.charAt(j) == 'U') {
					swe += "OO";
				} else {
					swe += eng.charAt(j);
				}
			}

			System.out.print((i + 1) + ". ");
			System.out.print(swe);
			System.out.println("\n");

		}

	}

}
