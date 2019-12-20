import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class numgrid {
	static String pathfinal;
	static TreeSet<Integer> nums = new TreeSet<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[][] grid = new String[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				grid[i][j] = st.nextToken();
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				findnum(grid, i, j, "");
			}
		}
		System.out.println(nums.size());
	}

	public static void findnum(String[][] grid, int i, int j, String findnum) {
		if (findnum.length() == 6) {
			nums.add(Integer.parseInt(findnum));
			// System.out.println(findnum);
			return;
		}
		if (i > 0) {
			findnum(grid, i - 1, j, findnum + grid[i - 1][j]);
		}
		if (j > 0) {
			findnum(grid, i, j - 1, findnum + grid[i][j - 1]);
		}
		if (i < grid.length - 1) {
			findnum(grid, i + 1, j, findnum + grid[i + 1][j]);
		}
		if (j < grid[0].length - 1) {
			findnum(grid, i, j + 1, findnum + grid[i][j + 1]);
		}
	}

}
