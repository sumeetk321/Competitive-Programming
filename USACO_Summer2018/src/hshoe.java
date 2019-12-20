import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hshoe {
	static boolean[][] visited;
	static int maxlen = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] grid = new String[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < N; j++) {
				grid[i][j] = row.charAt(j) + "";
			}
		}
		floodfill(grid, 0, 0, grid[0][0]);
		System.out.println(maxlen);
	}

	public static void floodfill(String[][] grid, int i, int j, String collected) {
		//System.out.println(collected);
		if (isPerfectlyBalanced(collected)) {
			maxlen = Math.max(maxlen, collected.length());
		}
		visited[i][j] = true;
		if (i > 0 && !grid[i - 1][j].equals("#") && !visited[i - 1][j]) {
			floodfill(grid, i - 1, j, collected + grid[i - 1][j]);
		}
		if (i < grid.length - 1 && !grid[i + 1][j].equals("#") && !visited[i + 1][j]) {
			floodfill(grid, i + 1, j, collected + grid[i + 1][j]);
		}
		if (j > 0 && !grid[i][j - 1].equals("#") && !visited[i][j - 1]) {
			floodfill(grid, i, j - 1, collected + grid[i][j - 1]);
		}
		if (j < grid[0].length - 1 && !grid[i][j].equals("#") && !visited[i][j + 1]) {
			floodfill(grid, i, j + 1, collected + grid[i][j + 1]);
		}
		visited[i][j] = false;
	}

	public static boolean isPerfectlyBalanced(String str) {
		if (str.length() % 2 == 0) {
			String test1 = str.substring(0, (str.length() / 2));
			String test2 = str.substring((str.length() / 2), str.length());
			for (int i = 0; i < test1.length(); i++) {
				if (test1.charAt(i) == ')') {
					return false;
				}
			}
			for (int i = 0; i < test2.length(); i++) {
				if (test2.charAt(i) == '(') {
					return false;
				}
			}
			return true;
		}
		return false;
	}

}
