package ACSL_JuniorDivision;

import java.util.Scanner;

public class ACSL_ACSLChessQueen_JuniorDivision {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			System.out.println("Enter input");
			String[][] grid = { { "5, 1", "5, 2", "5, 3", "5, 4", "5, 5" }, { "4, 1", "4, 2", "4, 3", "4, 4", "4, 5" },
					{ "3, 1", "3, 2", "3, 3", "3, 4", "3, 5" }, { "2, 1", "2, 2", "2, 3", "2, 4", "2, 5" },
					{ "1, 1", "1, 2", "1, 3", "1, 4", "1, 5" } };

			String input = scan.nextLine();
			int qpair1 = Integer.parseInt(input.split(", ")[0]);
			int qpair2 = Integer.parseInt(input.split(", ")[1]);
			int N = Integer.parseInt(input.split(", ")[2]);

			qpair1 = 5 - qpair1;
			qpair2--;

			for (int j = 0; j <= N; j++) {
				if (qpair2 + j >= 5) {
					break;
				} else {
					grid[qpair1][qpair2 + j] = "0";
				}
			}
			for (int j = 0; j <= N; j++) {
				if (qpair2 - j <= -1) {
					break;
				} else {
					grid[qpair1][qpair2 - j] = "0";
				}
			}
			for (int j = 0; j <= N; j++) {
				if (qpair1 + j >= 5) {
					break;
				} else {
					grid[qpair1 + j][qpair2] = "0";
				}
			}
			for (int j = 0; j <= N; j++) {
				if (qpair1 - j <= -1) {
					break;
				} else {
					grid[qpair1 - j][qpair2] = "0";
				}
			}
			for (int k = 0; k <= N; k++) {
				if (qpair1 - k <= -1 || qpair2 + k >= 5) {
					break;
				} else {
					grid[qpair1 - k][qpair2 + k] = "0";
				}
			}
			for (int k = 0; k <= N; k++) {
				if (qpair1 + k >= 5 || qpair2 - k <= -1) {
					break;
				} else {
					grid[qpair1 + k][qpair2 - k] = "0";
				}
			}

			// second diagonal

			for (int k = 0; k <= N; k++) {
				if (qpair1 - k <= -1 || qpair2 - k <= -1) {
					break;
				} else {
					grid[qpair1 - k][qpair2 - k] = "0";
				}
			}
			for (int k = 0; k <= N; k++) {
				if (qpair1 + k >= 5 || qpair2 + k >= 5) {
					break;
				} else {
					grid[qpair1 + k][qpair2 + k] = "0";
				}
			}

			int locations = 0;
			for (int l = 0; l < 5; l++) {
				for (int m = 0; m < 5; m++) {
					if (grid[l][m].equals("0")) {
						continue;
					} else {
						locations++;
					}
				}
			}
			System.out.println(locations);

		}

	}

}
