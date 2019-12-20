package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ACSL_Mancala_JuniorDivision {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Mancala2.txt");
		Scanner scan = new Scanner(file);

		int[] bowls = { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 };

		int mancA = 0, mancB = 0;
		String turn = "";
		for (int i = 0; i < 5; i++) {
			if ((i + 1) % 2 == 0) {
				turn = "B";
			} else {
				turn = "A";
			}
			String input = scan.nextLine();
			System.out.println("\n");
			int num1 = Integer.parseInt(input.split(", ")[0]), num2 = Integer.parseInt(input.split(", ")[1]);
			int val = bowls[num1 - 1];
			for (int k = 0; k <= bowls[num1 - 1]; k++) {
				if ("A".equals(turn) && num1 + k == 8) {
					val--;
				} else if ("B".equals(turn) && num1 + k == 14) {
					val--;
				}
			}
			for (int k = 1; k <= val; k++) {
				bowls[((num1 + k - 1) % 12)]++;

			}
			bowls[num1 - 1] = 0;

			System.out.println((i + 1) + ". " + bowls[num2 - 1]);
		}
	}

}
