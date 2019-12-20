import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class feedtime {
	static boolean[][] visited;
	static int max = 0;
	static int currsize = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		String[][] pasture = new String[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String row = br.readLine();
			for (int j = 0; j < C; j++) {
				pasture[i][j] = row.charAt(j) + "";
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (pasture[i][j].equals(".") && !visited[i][j]) {
					floodfill(pasture, i, j);
					max = Math.max(max, currsize);
					currsize = 1;
				}

			}
		}
		/*
		 * for (int i = 0; i < R; i++) { for (int j = 0; j < C; j++) {
		 * System.out.print(visited[i][j] + " "); } System.out.println(); }
		 */
		System.out.println(max);
	}

	public static void floodfill(String[][] grid, int i, int j) {
		//System.out.println(currsize);
		if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1) {
			currsize--;
			return;
		}
		if (visited[i][j]) {
			currsize--;
			return;
		}
		if (grid[i][j].equals("*")) {
			currsize--;
			return;
		}
		visited[i][j] = true;
		currsize+=8;
		floodfill(grid, i - 1, j);
		floodfill(grid, i + 1, j);
		floodfill(grid, i, j - 1);
		floodfill(grid, i, j + 1);
		floodfill(grid, i - 1, j - 1);
		floodfill(grid, i - 1, j + 1);
		floodfill(grid, i + 1, j - 1);
		floodfill(grid, i + 1, j + 1);
	}

}
