package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_ACSLIsola_JuniorDivision {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Isola2.txt");
		Scanner scan = new Scanner(file);

		for (int i = 0; i < 5; i++) {
			System.out.println("\n");
			ArrayList<Integer> up = new ArrayList<Integer>();
			ArrayList<Integer> down = new ArrayList<Integer>();
			ArrayList<Integer> left = new ArrayList<Integer>();
			ArrayList<Integer> right = new ArrayList<Integer>();

			String input = scan.nextLine();
			String[] input1 = input.split(", ");
			int[] blanks = new int[input1.length - 1];
			int[][] board = { { 43, 44, 45, 0, 47, 48, 49 }, { 36, 37, 38, 39, 40, 41, 42 },
					{ 29, 30, 31, 32, 33, 34, 35 }, { 22, 23, 24, 25, 26, 27, 28 }, { 15, 16, 17, 18, 19, 20, 21 },
					{ 8, 9, 10, 11, 12, 13, 14 }, { 1, 2, 3, 0, 5, 6, 7 } };

			for (int j = 0; j < blanks.length; j++) {
				blanks[j] = Integer.parseInt(input1[j]);
			}

			for (int k = 0; k < board.length; k++) {
				for (int l = 0; l < board[0].length; l++) {
					if (board[k][l] == blanks[1]) {
						for (int m = 0; m < 7; m++) {
							for (int n = 0; n < 7; n++) {
								for (int o = 0; o < blanks.length; o++) {
									if (board[m][n] == blanks[o]) {
										board[m][n] = 0;
									}
								}
							}
						}

						int up1 = k - 1;
						while (up1 >= 0 && board[up1][l] != 0) {
							up.add(board[up1][l]);
							up1--;
						}
						int down1 = k + 1;
						while (down1 <= 6 && board[down1][l] != 0) {
							down.add(board[down1][l]);
							down1++;
						}
						int left1 = l - 1;
						while (left1 >= 0 && board[k][left1] != 0) {
							left.add(board[k][left1]);
							left1--;
						}
						int right1 = l + 1;
						while (right1 <= 6 && board[k][right1] != 0) {
							right.add(board[k][right1]);
							right1++;
						}
					}

				}
			}

			int up2 = up.size();
			int down2 = down.size();
			int right2 = right.size();
			int left2 = left.size();


			if (up2 > down2 && up2 > right2 && up2 > left2) {
				for (int x : up) {
					System.out.print(x + " ");
				}
			} else if (down2 > up2 && down2 > right2 && down2 > left2) {
				for (int x : down) {
					System.out.print(x + " ");
				}
			} else if (right2 > up2 && right2 > down2 - 1 && right2 > left2) {
				for (int x : right) {
					System.out.print(x + " ");
				}
			} else if (left2 > up2 && left2 > right2 && left2 > down2 - 1) {
				for (int x : left) {
					System.out.print(x + " ");
				}
			} else{
				System.out.print("NONE");
			}

		}

	}
}
