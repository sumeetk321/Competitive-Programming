package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ACSL_Reversi_JuniorDivision {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("Reversi2.txt");
		Scanner scan = new Scanner(file);

		for (int i = 0; i < 5; i++) {
			ArrayList<String> output = new ArrayList<String>();
			String in = scan.nextLine();
			String[] coords = in.split(", ");
			String[][] grid = { { "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "" },
					{ "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "" },
					{ "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "" },
					{ "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "" } };
			for (int j = 1; j <= Integer.parseInt(coords[0]); j++) {
				String[] temp = coords[j].split("");
				int letter = 0;
				switch (temp[1]) {
				case "A":
					letter = 0;
					break;
				case "B":
					letter = 1;
					break;
				case "C":
					letter = 2;
					break;
				case "D":
					letter = 3;
					break;
				case "E":
					letter = 4;
					break;
				case "F":
					letter = 5;
					break;
				case "G":
					letter = 6;
					break;
				case "H":
					letter = 7;
					break;
				}
				grid[8 - Integer.parseInt(temp[0])][letter] = "X";
			}
			for (int j = Integer.parseInt(coords[0]) + 2; j < coords.length; j++) {
				String[] temp = coords[j].split("");
				int letter = 0;
				switch (temp[1]) {
				case "A":
					letter = 0;
					break;
				case "B":
					letter = 1;
					break;
				case "C":
					letter = 2;
					break;
				case "D":
					letter = 3;
					break;
				case "E":
					letter = 4;
					break;
				case "F":
					letter = 5;
					break;
				case "G":
					letter = 6;
					break;
				case "H":
					letter = 7;
					break;
				}
				grid[8 - Integer.parseInt(temp[0])][letter] = "O";
			}
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < 8; k++) {
					if (grid[j][k].equals("X")) {
						int tmp1 = 2;
						int tmp2 = 2;
						if (j + 2 < 8) {
							if (grid[j + 1][k].equals("O")) {
								tmp1 = 2;
								regloop: while (j + tmp1 < 8) {
									switch (grid[j + tmp1][k]) {
									case "O":
										tmp1++;
										continue;
									case "":
										output.add(8 - (j + tmp1) + "" + (char) (k + 65));
										break regloop;
									case "X":
										break regloop;
									}

									tmp1++;
								}
							}
						}
						if (j - 2 > -1) {
							if (grid[j - 1][k].equals("O")) {
								tmp1 = 2;
								regloop: while (j - tmp1 > -1) {
									switch (grid[j - tmp1][k]) {
									case "O":
										tmp1++;
										continue;
									case "":
										output.add(8 - (j - tmp1) + "" + (char) (k + 65));
										break regloop;
									case "X":
										break regloop;
									}

									tmp1++;
								}
							}
						}
						if (k + 2 < 8) {
							if (grid[j][k + 1].equals("O")) {
								tmp1 = 2;
								regloop: while (k + tmp1 < 8) {
									switch (grid[j][k + tmp1]) {
									case "O":
										tmp1++;
										continue;
									case "":
										output.add(8 - (j) + "" + (char) (k + tmp1 + 65));
										break regloop;
									case "X":
										break regloop;
									}

									tmp1++;
								}
							}
						}
						if (k - 2 > -1) {
							if (grid[j][k - 1].equals("O")) {
								tmp1 = 2;
								regloop: while (k - tmp1 > -1) {
									switch (grid[j][k - tmp1]) {
									case "O":
										tmp1++;
										continue;
									case "":
										output.add(8 - (j) + "" + (char) (k - tmp1 + 65));
										break regloop;
									case "X":
										break regloop;
									}

									tmp1++;
								}
							}
						}
						if (j + 2 < 8 && k - 2 > -1) {
							if (grid[j + 1][k - 1].equals("O")) {
								tmp1 = 2;
								tmp2 = 2;
								regloop: while ((k - tmp2 > -1) && (j + tmp1 < 8)) {
									switch (grid[j + tmp1][k - tmp2]) {
									case "O":
										tmp1++;
										tmp2++;
										continue;
									case "":
										output.add(8 - (j + tmp1) + "" + (char) (k - tmp2 + 65));
										break regloop;
									case "X":
										break regloop;
									}
									tmp1++;
									tmp2++;
								}
							}
						}
						if (j - 2 > -1 && k + 2 < 8) {
							if (grid[j - 1][k + 1].equals("O")) {
								tmp1 = 2;
								tmp2 = 2;
								regloop: while ((k + tmp2 < 8) && (j - tmp1 > -1)) {
									switch (grid[j - tmp1][k + tmp2]) {
									case "O":
										tmp1++;
										tmp2++;
										continue;
									case "":
										output.add(8 - (j - tmp1) + "" + (char) (k + tmp2 + 65));
										break regloop;
									case "X":
										break regloop;
									}
									tmp1++;
									tmp2++;
								}
							}
						}
						if (j + 2 < 8 && k + 2 < 8) {
							if (grid[j + 1][k + 1].equals("O")) {
								tmp1 = 2;
								tmp2 = 2;
								regloop: while ((k + tmp2 < 8) && (j + tmp1 < 8)) {
									switch (grid[j + tmp1][k + tmp2]) {
									case "O":
										tmp1++;
										tmp2++;
										continue;
									case "":
										output.add(8 - (j + tmp1) + "" + (char) (k + tmp2 + 65));
										break regloop;
									case "X":
										break regloop;
									}
									tmp1++;
									tmp2++;
								}
							}
						}
						if (j - 2 > -1 && k - 2 > -1) {
							if (grid[j - 1][k - 1].equals("O")) {
								tmp1 = 2;
								tmp2 = 2;
								regloop: while ((k - tmp2 > -1) && (j - tmp1 > -1)) {
									switch (grid[j - tmp1][k - tmp2]) {
									case "O":
										tmp1++;
										tmp2++;
										continue;
									case "":
										output.add(8 - (j - tmp1) + "" + (char) (k - tmp2 + 65));
										break regloop;
									case "X":
										break regloop;
									}
									tmp1++;
									tmp2++;
								}
							}
						}
					}
				}
			}
			Set<String> hash = new HashSet<>();
			if (output.size() == 0) {
				System.out.print("NONE");
			} else {
				hash.addAll(output);
				output.clear();
				output.addAll(hash);
				for (String x : output) {
					System.out.print(x + " ");
				}
			}

			System.out.println("\n");
		}

	}

}
