import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class satpix {
	static boolean[][] visited;
	static int max = 0;
	static int currsize = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		String[][] photo = new String[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String row = br.readLine();
			for (int j = 0; j < C; j++) {
				photo[i][j] = row.charAt(j) + "";
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (photo[i][j].equals("*") && !visited[i][j]) {
					floodfill(photo, i, j);
					max = Math.max(max, currsize);
					currsize = 1;
				}

			}
		}
		/*for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}*/
		System.out.println(max);
	}

	public static void floodfill(String[][] grid, int i, int j) {
		visited[i][j] = true;
		if (i > 0 && !visited[i - 1][j] && !grid[i - 1][j].equals(".")) {
			currsize++;
			floodfill(grid, i-1, j);
		}
		if (i < grid.length - 1 && !visited[i + 1][j] && !grid[i + 1][j].equals(".")) {
			currsize++;
			floodfill(grid, i+1, j);
		}
		if (j > 0 && !visited[i][j - 1] && !grid[i][j - 1].equals(".")) {
			currsize++;
			floodfill(grid, i, j-1);
		}
		if (j < grid[0].length-1 && !visited[i][j + 1] && !grid[i][j + 1].equals(".")) {
			currsize++;
			floodfill(grid, i, j+1);
		}
	}

}
