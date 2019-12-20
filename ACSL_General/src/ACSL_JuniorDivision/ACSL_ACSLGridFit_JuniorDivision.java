package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ACSL_ACSLGridFit_JuniorDivision {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("Gridfit2.txt");
		Scanner sc = new Scanner(file);
		int[][] grid = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 }

		};

		String[] input = sc.nextLine().split(", ");

		int i, k, l;
		for (i = 0; i < 5; i++) {
			for (k = 0; k < 5; k++) {
				for (l = 0; l < input.length; l++) {
					if (grid[i][k] == Integer.parseInt(input[l])) {
						grid[i][k] = 0;
					}
				}

			}
		}

		int lowest;
		boolean none = false;
		for (i = 0; i < 5; i++) {
			lowest = 26;
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				for (k = 0; k < 5; k++) {
					for (l = 0; l < 5; l++) {
						if (grid[k][l] != 0 && grid[k][l] < lowest) {
							lowest = grid[k][l];
							grid[k][l] = 0;
						}
					}
				}
				if (lowest == 26) {
					none = true;
				}
				break;
			case 2:
				loop: for (k = 0; k < 5; k++) {
					for (l = 0; l < 5; l++) {
						if (k == 4)
							break loop;
						if (grid[k][l] != 0 && grid[k + 1][l] != 0 && grid[k][l] < lowest) {
							lowest = grid[k][l];
							grid[k][l] = 0;
							grid[k + 1][l] = 0;
						}
					}
				}

				if (lowest == 26) {
					none = true;
				}
				break;
			case 3:
				for (k = 0; k < 5; k++) {
					for (l = 0; l < 5; l++) {
						if (l == 4)
							continue;
						if (grid[k][l] != 0 && grid[k][l+1] != 0 && grid[k][l] < lowest) {
							lowest = grid[k][l];
							grid[k][l] = 0;
							grid[k][l+1] = 0;
						}
					}
				}

				if (lowest == 26) {
					none = true;
				}
				break;
			}
			if (none) {
				System.out.println("NONE");
			} else {
				System.out.println(lowest);
			}
		}
	}
}
