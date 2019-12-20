import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sudoku {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] board = new int[9][9];
		StringTokenizer st;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if (solutionexists(board)) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("NO SOLUTION");
		}
	}

	public static boolean solutionexists(int[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == 0) {
					for (int test = 1; test <= 9; test++) {
						board[i][j] = test;
						// print(board);
						if (validrow(board, i, j) && validcol(board, i, j) && validbox(board, i, j)
								&& solutionexists(board)) {
							// System.out.println("DARN");
							return true;
						}
						board[i][j] = 0;
					}
					return false;
				}
			}
		}
		return true;
	}

	public static boolean validrow(int[][] board, int i, int j) {
		int[] test = new int[9];
		for (j = 0; j < 9; j++) {
			if (board[i][j] != 0) {
				test[board[i][j] - 1]++;
			}
		}
		for (int x : test) {
			if (x > 1) {
				return false;
			}
		}
		return true;
	}

	public static boolean validcol(int[][] board, int i, int j) {
		int[] test = new int[9];
		for (i = 0; i < 9; i++) {
			if (board[i][j] != 0) {
				test[board[i][j] - 1]++;
			}
		}
		for (int x : test) {
			if (x > 1) {
				return false;
			}
		}
		return true;
	}

	public static boolean validbox(int[][] board, int i, int j) {
		int[] test = new int[9];
		int starti = 0;
		int startj = 0;
		if (i < 3 && j < 3) {
			starti = 0;
			startj = 0;
		} else if (i < 6 && j < 3) {
			starti = 3;
			startj = 0;
		} else if (i < 9 && j < 3) {
			starti = 6;
			startj = 0;
		} else if (i < 3 && j < 6) {
			starti = 0;
			startj = 3;
		} else if (i < 6 && j < 6) {
			starti = 3;
			startj = 3;
		} else if (i < 9 && j < 6) {
			starti = 6;
			startj = 3;
		} else if (i < 3 && j < 9) {
			starti = 0;
			startj = 6;
		} else if (i < 6 && j < 9) {
			starti = 3;
			startj = 6;
		} else if (i < 9 && j < 9) {
			starti = 6;
			startj = 6;
		}
		for (int i1 = starti; i1 < starti + 3; i1++) {
			for (int j1 = startj; j1 < startj + 3; j1++) {
				if (board[i1][j1] != 0) {
					test[board[i1][j1] - 1]++;
				}
			}
		}
		// System.out.println(Arrays.toString(test));
		for (int x : test) {
			if (x > 1) {
				return false;
			}
		}
		return true;
	}

	public static void print(int[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
