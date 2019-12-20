import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class chkr {
	static boolean[][] visited;
	static ArrayList<int[]> moves = new ArrayList<int[]>();
	static int os = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] checkerboard = new String[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < N; j++) {
				checkerboard[i][j] = row.charAt(j) + "";
				if (checkerboard[i][j].equals("o")) {
					os++;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(checkerboard[i][j].equals("K")){
					recurse(checkerboard, i, j, 0);
				}
			}
		}
	}

	public static boolean recurse(String[][] grid, int i, int j, int curros) {
		if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1) {
			return false;
		}
		if (visited[i][j]) {
			return false;
		}
		if (curros == os) {
			int[] addnow = new int[]{i+1, j+1};
			moves.add(addnow);
			for (int[] x : moves) {
				System.out.println(x[0] + " " + x[1]);
			}
			System.exit(0);
			return true;
		}
		visited[i][j] = true;
		int[] movesadd = new int[] { i + 1, j + 1 };
		boolean out = false;
		if (i > 1 && j > 1) {
			if (grid[i - 1][j - 1].equals("o") && grid[i - 2][j - 2].equals("+")) {
				moves.add(movesadd);
				out |= recurse(grid, i - 2, j - 2, curros + 1);
				moves.remove(movesadd);
			}
		}
		if (i < grid.length - 2 && j > 1 && grid[i + 2][j - 2].equals("+")) {
			if (grid[i + 1][j - 1].equals("o")) {
				moves.add(movesadd);
				out |= recurse(grid, i + 2, j - 2, curros + 1);
				moves.remove(movesadd);
			}
		}
		if (i > 1 && j < grid[0].length - 2 && grid[i - 2][j + 2].equals("+")) {
			if (grid[i - 1][j + 1].equals("o")) {
				moves.add(movesadd);
				out |= recurse(grid, i - 2, j + 2, curros + 1);
				moves.remove(movesadd);
			}
		}
		if (i < grid.length - 2 && j < grid[0].length - 2 && grid[i + 2][j + 2].equals("+")) {
			if (grid[i + 1][j + 1].equals("o")) {
				moves.add(movesadd);
				out |= recurse(grid, i + 2, j + 2, curros + 1);
				moves.remove(movesadd);
			}
		}
		return out;
	}

}
