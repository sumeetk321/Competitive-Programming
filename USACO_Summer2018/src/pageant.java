import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pageant {
	static boolean[][] visited;
	static int min = Integer.MAX_VALUE;
	static int currlen = 0;
	static int spotnum = 1;
	static String[][] split;
	static int totalfilled = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		String[][] cowhide = new String[R][C];
		visited = new boolean[R][C];
		split = new String[R][C];
		for (int i = 0; i < R; i++) {
			String row = br.readLine();
			for (int j = 0; j < C; j++) {
				cowhide[i][j] = row.charAt(j) + "";
				split[i][j] = cowhide[i][j];
				if (!cowhide[i][j].equals(".")) {
					totalfilled++;
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (cowhide[i][j].equals("X") && !visited[i][j]) {
					floodfill(cowhide, i, j);
					spotnum++;
				}
				// System.out.print(split[i][j] + " ");
			}
			// System.out.println();
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(split[i][j].equals("1")){
					for(int k = 0; k < R; k++){
						for(int l = 0; l < C; l++){
							if(split[k][l].equals("2")){
								min = Math.min(min, Math.abs(i-k)+Math.abs(j-l)-1);
							}
						}
					}
				}
			}
		}

		System.out.println(min);
	}

	public static void floodfill(String[][] grid, int i, int j) {
		visited[i][j] = true;
		split[i][j] = spotnum + "";
		if (i > 0 && !visited[i - 1][j] && !grid[i - 1][j].equals(".")) {
			floodfill(grid, i - 1, j);
		}
		if (i < grid.length - 1 && !visited[i + 1][j] && !grid[i + 1][j].equals(".")) {
			floodfill(grid, i + 1, j);
		}
		if (j > 0 && !visited[i][j - 1] && !grid[i][j - 1].equals(".")) {
			floodfill(grid, i, j - 1);
		}
		if (j < grid[0].length - 1 && !visited[i][j + 1] && !grid[i][j + 1].equals(".")) {
			floodfill(grid, i, j + 1);
		}
	}
}
