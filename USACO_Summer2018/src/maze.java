
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
//import java.util.StringTokenizer;

class maze {
	static boolean[][] visited;
	static String pathfinal;

	public static void path(String[][] grid, int i, int j, String path) {
		if (grid[i][j].equals("F")) {
			pathfinal = path;
		}
		visited[i][j] = true;
		if (i > 0 && !grid[i - 1][j].equals("#") && !visited[i - 1][j]) {
			path(grid, i - 1, j, path + "U");
		}
		if (i < grid.length - 1 && !grid[i + 1][j].equals("#") && !visited[i + 1][j]) {
			path(grid, i + 1, j, path + "D");
		}
		if (j > 0 && !grid[i][j - 1].equals("#") && !visited[i][j - 1]) {
			path(grid, i, j - 1, path + "L");
		}
		if (j < grid[0].length - 1 && !grid[i][j+1].equals("#") && !visited[i][j + 1]) {
			path(grid, i, j + 1, path + "R");
		}
	}

	static String solve() /* throws IOException */ {
		Scanner scan = new Scanner(System.in);
		int R = scan.nextInt();
		int C = scan.nextInt();
		scan.nextLine();
		visited = new boolean[R][C];
		String[][] grid = new String[R][C];
		int starti = 0;
		int startj = 0;
		for (int i = 0; i < R; i++) {
			String row = scan.nextLine();
			for (int j = 0; j < C; j++) {
				grid[i][j] = row.charAt(j) + "";
				if (grid[i][j].equals("S")) {
					starti = i;
					startj = j;
				}
				visited[i][j] = false;
			}
		}
		path(grid, starti, startj, "");
		return pathfinal;

	}

	public static void main(String[] args) throws IOException {
		System.out.println(solve());
	}

}
