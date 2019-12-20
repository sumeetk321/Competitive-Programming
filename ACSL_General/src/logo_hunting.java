import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class logo_hunting {
	static int regionstmp;
	static boolean[][] visited;
	static ArrayList<String> logos = new ArrayList<String>();
	static int bottmp = 0;
	static int righttmp = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[][] grid = new String[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				grid[i][j] = str.charAt(j) + "";
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j].equals("1") && !visited[i][j]) {
					recurseone(i, j, grid);
					//System.out.println(bottmp + ", " + righttmp);
					/*
					 * for(int k = 0; k < n; k++){ for(int l = 0; l < m; l++){
					 * System.out.print(visited[k][l]+" "); }
					 * System.out.println(); } System.out.println();
					 */
					for (int k = i; k <= bottmp; k++) {
						for (int l = j; l <= righttmp; l++) {
							if (grid[k][l].equals(".") && !visited[k][l]) {
								recursedot(i, j, k, l, grid);
								regionstmp++;
							}
						}
					}
					switch (regionstmp) {
					case 1:
						if (grid[bottmp][righttmp].equals("1")) {
							logos.add("O");
						} else {
							logos.add("F");
						}
						break;
					case 2:
						logos.add("P");
						break;
					}
				}
				bottmp = 0;
				righttmp = 0;
				regionstmp = 0;
			}
		}
		Collections.sort(logos);
		for(String x : logos){
			System.out.print(x);
		}
		System.out.println();
	}

	public static void recurseone(int r, int c, String[][] grid) {
		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
			return;
		}
		if (visited[r][c] || grid[r][c].equals(".")) {
			return;
		}
		visited[r][c] = true;
		bottmp = Math.max(bottmp, r);
		righttmp = Math.max(righttmp, c);
		recurseone(r - 1, c, grid);
		recurseone(r + 1, c, grid);
		recurseone(r, c + 1, grid);
		recurseone(r, c - 1, grid);
	}

	public static void recursedot(int startr, int startc, int r, int c, String[][] grid) {
		if (r < startr || r > bottmp || c < startc || c > righttmp) {
			return;
		}
		if (visited[r][c] || grid[r][c].equals("1")) {
			return;
		}
		visited[r][c] = true;
		recursedot(startr, startc, r - 1, c, grid);
		recursedot(startr, startc, r + 1, c, grid);
		recursedot(startr, startc, r, c + 1, grid);
		recursedot(startr, startc, r, c - 1, grid);
	}
}
