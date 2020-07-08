package USOpen_2018;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MultiplayerMoo {
	static int[][] grid;
	static boolean[][] seen;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<Integer> ids = new ArrayList<Integer>();
		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (!ids.contains(board[i][j])) {
					ids.add(board[i][j]);
				}
			}
		}
		int maxarea = Integer.MIN_VALUE;
		for (int x : ids) {
			int[][] tmp = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] != x) {
						tmp[i][j] = 0;
					} else {
						tmp[i][j] = 1;
					}
				}
			}
			int maoi = maxAreaOfIsland(tmp);
			if (maoi > maxarea) {
				maxarea = maoi;
			}
		}
		out.println(maxarea);
		if (ids.size() == 2) {
			out.println((int) Math.pow(N, 2));
		} else {
			for (int i = 0; i < ids.size() - 1; i++) {
				for (int j = i + 1; j < ids.size(); j++) {
					boolean touching = false;
					mainloop: for (int k = 0; k < N; k++) {
						for (int l = 0; l < N; l++) {
							if (board[k][l] == ids.get(i)) {
								if (k > 0 && board[k - 1][l] == ids.get(j)) {
									touching = true;
									break mainloop;
								}
								if (k < N - 1 && board[k + 1][l] == ids.get(j)) {
									touching = true;
									break mainloop;
								}
								if (l > 0 && board[k][l - 1] == ids.get(j)) {
									touching = true;
									break mainloop;
								}
								if (l < N - 1 && board[k][l + 1] == ids.get(j)) {
									touching = true;
									break mainloop;
								}
							}
						}
					}
					if (!touching) {
						continue;
					}
					int[][] tmp = new int[N][N];
					for (int k = 0; k < N; k++) {
						for (int l = 0; l < N; l++) {
							if (board[k][l] == ids.get(i) || board[k][l] == ids.get(j)) {
								tmp[k][l] = 1;
							} else {
								tmp[k][l] = 0;
							}
						}
					}
					int maoi = maxAreaOfIsland(tmp);
					if (maoi > maxarea) {
						maxarea = maoi;
					}
				}
			}
			out.println(maxarea);
		}
		out.close();
	}

	public static int area(int a, int b) {
		if (a < 0 || a >= grid.length || b < 0 || b >= grid[0].length || seen[a][b] || grid[a][b] == 0)
			return 0;
		seen[a][b] = true;
		return (1 + area(a + 1, b) + area(a - 1, b) + area(a, b - 1) + area(a, b + 1));
	}

	public static int maxAreaOfIsland(int[][] grid1) {
		grid = grid1;
		seen = new boolean[grid.length][grid[0].length];
		int output = 0;
		for (int a = 0; a < grid.length; a++) {
			for (int b = 0; b < grid[0].length; b++) {
				output = Math.max(output, area(a, b));
			}
		}
		return output;
	}
}
