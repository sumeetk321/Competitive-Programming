import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class hopscotch_silver {
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("hopscotch.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hopscotch.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] grid = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, -1, grid);
		out.println(count);
		out.close();
		br.close();
	}

	public static void dfs(int r, int c, int prevnum, int[][] grid) {
		if (grid[r][c] == prevnum) {
			return;
		}
		if (r == grid.length - 1 && c == grid[0].length - 1) {
			count++;
			return;
		}
		for (int i = r + 1; i < grid.length; i++) {
			for (int j = c + 1; j < grid[0].length; j++) {
				if (grid[i][j] != grid[r][c]) {
					dfs(i, j, grid[r][c], grid);
				}
			}
		}
	}

}
