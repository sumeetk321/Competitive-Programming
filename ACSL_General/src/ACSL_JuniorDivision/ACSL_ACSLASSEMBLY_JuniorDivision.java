package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_ACSLASSEMBLY_JuniorDivision {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("ASSEMBLY2.txt");
		Scanner scan = new Scanner(file);
		int ACC = 0;
		ArrayList<Integer> DC = new ArrayList<Integer>();
		ArrayList<String> labels = new ArrayList<String>();
		while (scan.hasNextLine()) {
			String in = scan.nextLine();
			if (in.contains("DC")) {
				labels.add(in.charAt(0) + "");
				if (in.charAt(in.length() - 2) != ' ') {
					DC.add(-1 * Character.getNumericValue(in.charAt(in.length() - 1)));
				} else {
					DC.add(Character.getNumericValue(in.charAt(in.length() - 1)));
				}
			} else if (in.contains("ADD")) {
				if (in.charAt(in.length() - 2) != ' ') {
					ACC += -1 * DC.get(labels.indexOf(in.charAt(in.length() - 1) + "")) % 1000000;
				} else {
					ACC += DC.get(labels.indexOf(in.charAt(in.length() - 1) + "")) % 1000000;
				}
			} else if (in.contains("SUB")) {
				if (in.charAt(in.length() - 2) != ' ') {
					ACC -= -1 * DC.get(labels.indexOf(in.charAt(in.length() - 1) + "")) % 1000000;
				} else {
					ACC -= DC.get(labels.indexOf(in.charAt(in.length() - 1) + "")) % 1000000;
				}
			} else if (in.contains("MULT")) {
				if (in.charAt(in.length() - 2) != ' ') {
					ACC *= -1 * DC.get(labels.indexOf(in.charAt(in.length() - 1) + "")) % 1000000;
				} else {
					ACC *= DC.get(labels.indexOf(in.charAt(in.length() - 1) + "")) % 1000000;
				}
			} else if (in.contains("DIV")) {
				if (in.charAt(in.length() - 2) != ' ') {
					ACC /= -1 * DC.get(labels.indexOf(in.charAt(in.length() - 1) + "")) % 1000000;
				} else {
					ACC /= DC.get(labels.indexOf(in.charAt(in.length() - 1) + "")) % 1000000;
				}
			} else if (in.contains("END")) {
				break;
			} else if (in.contains("PRINT")) {
				System.out.println(DC.get(labels.indexOf(in.charAt(in.length() - 1) + "")));
			} else if (in.contains("LOAD")) {
				if (in.charAt(in.length() - 2) != ' ') {
					ACC = -1 * DC.get(labels.indexOf(in.charAt(in.length() - 1) + ""));
				} else {
					ACC = DC.get(labels.indexOf(in.charAt(in.length() - 1) + ""));
				}
			} else if (in.contains("STORE")) {
				if (labels.contains(in.charAt(in.length() - 1) + "")) {
					DC.set(labels.indexOf(in.charAt(in.length() - 1) + ""), ACC);
				} else {
					if (in.charAt(in.length() - 2) != ' ') {
						labels.add(-1 * in.charAt(in.length() - 1) + "");
					} else {
						labels.add(in.charAt(in.length() - 1) + "");
					}
					DC.add(ACC);
				}
			}

		}

	}

}
