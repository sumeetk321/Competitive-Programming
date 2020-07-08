package Contest1_2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class mooyomooyo {
	static int[][] board;
	static boolean visited[][];
	static boolean visitedtmp[][];
	static int size = 0;
	static int[][] tmp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("mooyomooyo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		board = new int[N][10];
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < 10; j++) {
				board[i][j] = Integer.parseInt(in.charAt(j) + "");
			}
		}
		while (true) {
			visited = new boolean[N][10];
			visitedtmp = new boolean[N][10];
			tmp = new int[N][10];
			size = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 10; j++) {
					tmp[i][j] = board[i][j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 10; j++) {
					visitedtmp[i][j] = visited[i][j];
				}
			}
			int numreg = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 10; j++) {
					if (!visited[i][j] && board[i][j] > 0) {
						findreg(i, j, board[i][j]);
						if (size >= K) {
							numreg++;
							for (int i1 = 0; i1 < N; i1++) {
								for (int j1 = 0; j1 < 10; j1++) {
									board[i1][j1] = tmp[i1][j1];
								}
							}
							for (int i1 = 0; i1 < N; i1++) {
								for (int j1 = 0; j1 < 10; j1++) {
									visited[i1][j1] = visitedtmp[i1][j1];
								}
							}
						} else {
							for (int i1 = 0; i1 < N; i1++) {
								for (int j1 = 0; j1 < 10; j1++) {
									visitedtmp[i1][j1] = visited[i1][j1];
								}
							}
							for (int i1 = 0; i1 < N; i1++) {
								for (int j1 = 0; j1 < 10; j1++) {
									tmp[i1][j1] = board[i1][j1];
								}
							}
						}
						size = 0;
					}

				}
			}
			for (int i1 = 0; i1 < N; i1++) {
				for (int j1 = 0; j1 < 10; j1++) {
					if (visited[i1][j1]) {
						board[i1][j1] = 0;
					}
				}
			}

			if (numreg == 0) {
				break;
			}
			for (int j = 0; j < 10; j++) {
				for (int i = N - 2; i > -1; i--) {
					if (board[i][j] > 0) {
						int i1 = i;
						while (board[i1 + 1][j] == 0) {
							board[i1 + 1][j] = board[i1][j];
							board[i1][j] = 0;
							i1++;
							if (i1 == N - 1) {
								break;
							}
						}
					}
				}
			}
			
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				out.print(board[i][j]);
			}
			out.println();
		}
		out.close();
		br.close();
	}

	public static void findreg(int i, int j, int orignum) {
		if (i < 0 || i >= visitedtmp.length || j < 0 || j >= 10) {
			return;
		}
		if (visitedtmp[i][j]) {
			return;
		}
		if (board[i][j] != orignum) {
			return;
		}
		size++;
		visitedtmp[i][j] = true;
		// tmp[i][j] = 0;
		findreg(i - 1, j, orignum);
		findreg(i + 1, j, orignum);
		findreg(i, j - 1, orignum);
		findreg(i, j + 1, orignum);
	}
}
