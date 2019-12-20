package ACSL_JuniorDivision;

import java.util.Scanner;

public class ACSL_PRINTFORMATTING_JuniorDivision {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println("\n");
			System.out.println("Enter input");
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();
			String formatstr = input.split(", ")[0];
			String val = input.split(", ")[1];

			if (formatstr.contains(",")) {
				System.out.println("\n");
				for (int j = 0; j < formatstr.length() - 1 - val.length(); j++) {
					System.out.print('*');
				}
				System.out.print(val.charAt(0));
				for (int j = val.length() - 3; j > 0; j -= 3) {
					if (j < val.length() - 1) {
						System.out.print(',');
					}

					System.out.print(val.substring(j, j + 3));
				}
			} else if (formatstr.contains("$")) {
				if (formatstr.contains("*")) {
					for (int j = 0; j < formatstr.length() - 2 - val.length(); j++) {
						System.out.print('*');
					}
				}
				System.out.print("$" + val);
			} else if (formatstr.contains("-")) {
				int valint = Integer.parseInt(val);
				for (int j = 0; j < formatstr.length() - val.length(); j++) {
					System.out.print('*');
				}
				if (valint < 0) {
					System.out.print((-1 * valint) + "-");
				} else {
					System.out.print(valint + "*");
				}
			} else {
				for (int j = 0; j < formatstr.length() - val.length(); j++) {
					System.out.print('*');
				}
				System.out.print(val);
			}
		}
	}

}
