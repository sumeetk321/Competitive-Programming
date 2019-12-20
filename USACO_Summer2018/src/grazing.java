import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class grazing {
	static int ways = 0;
	static boolean[][] visited = new boolean[5][5];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[][] field = new String[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				field[i][j] = ".";
			}
		}
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			field[r - 1][c - 1] = "X";
		}
		recurse(field, 4, 4, 1, N);
		System.out.println(ways);
	}

	public static void recurse(String[][] grid, int i, int j, int grassconsumed, int N) {
		if (i == 0 && j == 0) {
			if (grassconsumed == 25 - N) {
				//System.out.println(grassconsumed);
				ways++;
			}
			return;
		}
		visited[i][j] = true;
		if (i > 0 && !grid[i - 1][j].equals("X") && !visited[i - 1][j]) {
			recurse(grid, i - 1, j, grassconsumed + 1, N);
		}
		if (i < grid.length - 1 && !grid[i + 1][j].equals("X") && !visited[i + 1][j]) {
			recurse(grid, i + 1, j, grassconsumed + 1, N);
		}
		if (j > 0 && !grid[i][j - 1].equals("X") && !visited[i][j - 1]) {
			recurse(grid, i, j - 1, grassconsumed + 1, N);
		}
		if (j < grid[0].length - 1 && !grid[i][j + 1].equals("X") && !visited[i][j + 1]) {
			recurse(grid, i, j + 1, grassconsumed + 1, N);
		}
		visited[i][j] = false;
	}

}
