package ACSL_JuniorDivision;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class ACSL_ACSLBlokus_JuniorDivision {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("Blokus2.txt");
		Scanner scan = new Scanner(file);

		for (int i = 0; i < 5; i++) {
			String[] input = scan.nextLine().split(", ");
			String[] boardnums = input[0].split("");
			ArrayList<String> pieces = new ArrayList<String>();
			ArrayList<String> abc = new ArrayList<String>(
					Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"));
			boardnums[0] = Integer.toString(9 - abc.indexOf((boardnums[0])));
			boardnums[1] = Integer.toString(Integer.parseInt(boardnums[1]) - 1);
			int linktile1 = Integer.parseInt(input[1]);
			int linktile2 = Integer.parseInt(input[2]);

			// Piece A
			if (linktile1 == 2) {
				if (linktile2 == 1) {
					if (Integer.parseInt(boardnums[1]) + 2 < 10) {
						pieces.add("A");
					}
				}
			} else if (linktile1 == 1) {
				if (linktile2 == 2) {
					if (Integer.parseInt(boardnums[1]) - 2 >= 0) {
						pieces.add("A");
					}
				}
			}

			// Piece B
			if (linktile1 == 1) {
				if (linktile2 == 2) {
					if (Integer.parseInt(boardnums[1]) - 2 >= 0 && Integer.parseInt(boardnums[0]) + 2 < 10) {
						pieces.add("B");
					}
				} else if (linktile2 == 3) {
					if (Integer.parseInt(boardnums[0]) - 2 >= 0 && Integer.parseInt(boardnums[1]) - 2 >= 0) {
						pieces.add("B");
					}
				}
			} else if (linktile1 == 2) {
				if (linktile2 == 1) {
					if (Integer.parseInt(boardnums[1]) + 3 <= 10
							|| (Integer.parseInt(boardnums[1]) + 3 <= 10 && Integer.parseInt(boardnums[0]) + 2 < 10)) {
						if (Integer.parseInt(boardnums[0]) - 1 >= 0) {
							pieces.add("B");
						}
					}

				} else if (linktile2 == 3) {
					if (Integer.parseInt(boardnums[0]) - 2 >= 0) {
						pieces.add("B");
					}
				}
			}

			// Piece C

			if (linktile1 == 1) {
				if (linktile2 == 1) {
					if (Integer.parseInt(boardnums[0]) + 2 < 10 && Integer.parseInt(boardnums[1]) - 2 >= 0) {
						pieces.add("C");
					}
				} else if (linktile2 == 4) {
					if (Integer.parseInt(boardnums[1]) - 3 >= 0
							|| (Integer.parseInt(boardnums[1]) - 3 >= 0 && Integer.parseInt(boardnums[0]) + 1 < 10)) {
						pieces.add("C");
					}
				}
			} else if (linktile1 == 2) {
				if (linktile2 == 2) {
					if (Integer.parseInt(boardnums[1]) + 4 < 10) {
						if (Integer.parseInt(boardnums[0]) + 1 < 10 || Integer.parseInt(boardnums[0]) - 2 <= 0) {
							pieces.add("C");
						}
					}
				} else if (linktile2 == 1) {
					if (Integer.parseInt(boardnums[1]) + 3 < 10 && Integer.parseInt(boardnums[0]) + 2 < 10) {
						pieces.add("C");
					}
				}
			}

			// Piece D

			if (linktile1 == 1) {
				if (linktile2 == 1) {
					if (Integer.parseInt(boardnums[1]) - 2 >= 0 && Integer.parseInt(boardnums[0]) + 3 < 10) {
						pieces.add("D");
					}
				} else if (linktile2 == 3) {
					if (Integer.parseInt(boardnums[1]) - 2 >= 0 && Integer.parseInt(boardnums[0]) - 2 >= 0) {
						pieces.add("D");
					}
				} else if (linktile2 == 4) {
					if (Integer.parseInt(boardnums[1]) - 1 >= 0 && Integer.parseInt(boardnums[0]) - 3 >= 0) {
						pieces.add("D");
					}
				}
			} else if (linktile1 == 2) {
				if (linktile2 == 1) {
					if (Integer.parseInt(boardnums[1]) + 2 < 10 && Integer.parseInt(boardnums[0]) + 3 < 10) {
						pieces.add("D");
					}
				} else if (linktile2 == 2) {
					if (Integer.parseInt(boardnums[1]) + 3 < 10 && Integer.parseInt(boardnums[0]) + 2 < 10) {
						pieces.add("D");
					}
				} else if (linktile2 == 4) {
					if (Integer.parseInt(boardnums[1]) + 3 < 10 && Integer.parseInt(boardnums[0]) - 3 >= 0) {
						pieces.add("D");
					}
				}
			}

			System.out.print((i + 1) + ". ");
			if (pieces.size() > 0) {
				for (String a : pieces) {
					System.out.print(a + " ");
				}
			} else {
				System.out.print("NONE");
			}
			System.out.println("\n");

		}
	}
}
