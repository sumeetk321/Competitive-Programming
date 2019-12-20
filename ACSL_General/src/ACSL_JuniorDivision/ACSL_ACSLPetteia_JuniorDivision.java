package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_ACSLPetteia_JuniorDivision {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("Petteia1.txt");
		Scanner scan = new Scanner(file);
		String[][] grid = { { "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "" } };
		String[] Os = scan.nextLine().split(", ");
		for (int i = 1; i < Os.length - 1; i += 2) {
			grid[8 - Integer.parseInt(Os[i])][Integer.parseInt(Os[i + 1]) - 1] = "O";
		}

		String[] Xs = scan.nextLine().split(", ");
		for (int i = 1; i < Xs.length - 1; i += 2) {
			grid[8 - Integer.parseInt(Xs[i])][Integer.parseInt(Xs[i + 1]) - 1] = "X";
		}
		String[] newXs = new String[2];
		for (int index = 0; index < 5; index++) {
			ArrayList<String> CapturedOs = new ArrayList<String>();
			newXs = scan.nextLine().split(", ");

			int coord1 = 8 - Integer.parseInt(newXs[0]), coord2 = Integer.parseInt(newXs[1]) - 1;

			// checking up
			if (coord1 - 2 > -1) {
				if (grid[coord1 - 2][coord2].equals("X")) {
					if (grid[coord1 - 1][coord2].equals("O")) {
						CapturedOs.add((Math.abs(8 - (coord1 - 1))) + ", " + (coord2 + 1));
					}
				}
			}
			// checking down
			if (coord1 + 2 < 8) {
				if (grid[coord1 + 2][coord2].equals("X")) {
					if (grid[coord1 + 1][coord2].equals("O")) {
						CapturedOs.add((Math.abs(8 - (coord1 + 1))) + ", " + (coord2 + 1));
					}
				}
			}
			// checking left
			if (coord2 - 2 > -1) {
				if (grid[coord1][coord2 - 2].equals("X")) {
					if (grid[coord1][coord2 - 1].equals("O")) {
						CapturedOs.add((Math.abs(8 - coord1)) + ", " + (coord2));
					}
				}
			}
			// checking right
			if (coord2 + 2 < 8) {
				if (grid[coord1][coord2 + 2].equals("X")) {
					if (grid[coord1][coord2 + 1].equals("O")) {
						CapturedOs.add((Math.abs(8 - coord1)) + ", " + (coord2 + 2));
					}
				}
			}

			// Printing
			System.out.print((index + 1) + ". ");
			if (CapturedOs.size() > 0) {
				System.out.print(CapturedOs.get(0));
			} else {
				System.out.print("NONE");
			}
			System.out.println("\n");

		}
	}

}
