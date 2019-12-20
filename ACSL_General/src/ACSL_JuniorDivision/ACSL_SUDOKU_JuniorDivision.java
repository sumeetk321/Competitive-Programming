package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_SUDOKU_JuniorDivision {

	public static void main(String[] args) throws FileNotFoundException {

		//Scanner scan = new Scanner(new File("sudoku1.txt"));
		 Scanner scan = new Scanner(new File("sudoku2.txt"));
		int[][] grid = new int[9][9];
		int cellnum, rownum, columnnum;
		cellnum = rownum = columnnum = 0;

		String[] coords = new String[5];
		ArrayList<Integer> coordsSplit = new ArrayList<Integer>();
		ArrayList<Integer> containsrow = new ArrayList<Integer>();
		ArrayList<Integer> containscolumn = containsrow, containscell1 = containsrow, containscell2 = containscell1,
				containscell3 = containscell1;

		// get user input for grid
		for (int i = 0; i < 9; i++) {
			String[] input = scan.nextLine().split(" ");
			for (int j = 0; j < 9; j++) {
				grid[i][j] = Integer.parseInt(input[j]);
			}
		}

		/*
		 * for(int i =0; i < 9; i++){ for(int j =0; j < 9; j++){
		 * System.out.println(grid[i][j]); } }
		 */
		// get pairs
		for (int i = 0; i < 5; i++) {
			coords[i] = scan.nextLine();
		}

		for (int i = 0; i < 5; i++) {
			coordsSplit.add(Integer.parseInt(coords[i].split(",")[0]));
			coordsSplit.add(Integer.parseInt(coords[i].split(",")[1]));
		}

		// pair 1
		for (int abc = 0; abc <= 8; abc += 2) {
			rownum = (coordsSplit.get(abc) - 1);
			columnnum = (coordsSplit.get(abc + 1) - 1);
			containscell1 = new ArrayList<Integer>();
			containscell2 = new ArrayList<Integer>();
			containscell3 = new ArrayList<Integer>();
			containsrow = new ArrayList<Integer>();
			containscolumn = new ArrayList<Integer>();

			ArrayList<Integer> possibles = new ArrayList<Integer>() {
				{
					add(1);
					add(2);
					add(3);
					add(4);
					add(5);
					add(6);
					add(7);
					add(8);
					add(9);
				}
			};
			if (columnnum - 2 <= 0) {
				if (rownum - 2 <= 0) {
					cellnum = 1;
				} else if (rownum - 2 <= 3) {
					cellnum = 4;
				} else if (rownum - 2 <= 6) {
					cellnum = 7;
				}
			} else if (columnnum - 2 <= 3) {
				if (rownum - 2 <= 0) {
					cellnum = 2;
				} else if (rownum - 2 <= 3) {
					cellnum = 5;
				} else if (rownum - 2 <= 6) {
					cellnum = 8;
				}
			} else if (columnnum - 2 <= 6) {
				if (rownum - 2 <= 0) {
					cellnum = 3;
				} else if (rownum - 2 <= 3) {
					cellnum = 6;
				} else if (rownum - 2 <= 6) {
					cellnum = 9;
				}
			}

			for (int i = 0; i < 9; i++) {
				containsrow.add(grid[rownum][i]);
			}

			for (int j = 0; j < 9; j++) {
				containscolumn.add(grid[j][columnnum]);
			}

			if (cellnum == 1 || cellnum == 4 || cellnum == 7) {
				for (int r = 0; r < 3; r++) {
					containscell1.add(grid[cellnum - 1][r]);
				}
				for (int r = 0; r < 3; r++) {
					containscell2.add(grid[cellnum][r]);
				}
				for (int r = 0; r < 3; r++) {
					containscell3.add(grid[cellnum + 1][r]);
				}
			} else if (cellnum == 2 || cellnum == 5 || cellnum == 8) {
				for (int r = 0; r < 3; r++) {
					containscell1.add(grid[cellnum - 2][r + 3]);
				}
				for (int r = 0; r < 3; r++) {
					containscell2.add(grid[cellnum - 1][r + 3]);
				}
				for (int r = 0; r < 3; r++) {
					containscell3.add(grid[cellnum][r + 3]);
				}
			} else if (cellnum == 3 || cellnum == 6 || cellnum == 9) {
				for (int r = 0; r < 3; r++) {
					// System.out.println(grid[cellnum-3][r+6]);
					containscell1.add(grid[cellnum - 3][r + 6]);
				}
				for (int r = 0; r < 3; r++) {
					containscell2.add(grid[cellnum - 2][r + 6]);
					// System.out.println(grid[cellnum-2][r+6]);
				}
				for (int r = 0; r < 3; r++) {
					containscell3.add(grid[cellnum - 1][r + 6]);
					// System.out.println(grid[cellnum-1][r+6]);
				}
			}

			// System.out.println("Cellnum: " + cellnum);
			for (int x = 0; x < 9; x++) {
				// System.out.println(containsrow.get(x));
			}
			for (int x = 0; x < 3; x++) {
				/*
				 * System.out.println("CELL: ");
				 * System.out.println(containscell1.get(x));
				 * System.out.println(containscell2.get(x));
				 * System.out.println(containscell3.get(x));
				 * System.out.println("END");
				 */
			}
			/*
			 * System.out.println(containscolumn.get(0));
			 * System.out.println(containscolumn.get(1));
			 * System.out.println(containscolumn.get(2));
			 * System.out.println(containscolumn.get(3));
			 * System.out.println(containscolumn.get(4));
			 * System.out.println(containscolumn.get(5));
			 * System.out.println(containscolumn.get(6));
			 * System.out.println(containscolumn.get(7));
			 * System.out.println(containscolumn.get(8));
			 */
			for (int x = 1; x <= 9; x++) {
				// System.out.println(x);
				if (!(containsrow.contains(x))) {
					if (!(containscolumn.contains(x))) {
						if (!(containscell1.contains(x))) {
							if (!(containscell2.contains(x))) {
								if (!(containscell3.contains(x))) {
									System.out.print(x + " ");
								}
							}
						}

					}
				}
			}

			System.out.println("\n");

		}
	}

}
