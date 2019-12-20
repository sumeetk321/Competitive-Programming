import java.util.Scanner;

public class SmaugsMaze {
	static int n;
	static int m;
	static int length = 0;
	static String direction = "";
	static String out = "";

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		char[][] grid = new char[n][m];
		for (int i = 0; i < n; i++) {
			scan = new Scanner(System.in);
			String in = scan.nextLine();

			for (int j = 0; j < m; j++) {
				grid[i][j] = in.charAt(j);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 'S') {
					length(grid, i, j);
					if (out.length() == 0) {
						System.out.println("NO ESCAPE!");
					}
				}
			}
		}

	}

	public static void length(char[][] grid, int x, int y) {
		if (x == 0 || x == n - 1 || y == 0 || y == m - 1) {
			System.out.println(length + 1);
			out = (length + 1) + "";
			return;
		}
		if (out.length() > 0)
			return;
		if (x - 1 >= 0 && y - 1 >= 0 && !direction.equals("RD")) {
			if (grid[x - 1][y - 1] == '.') {
				length++;
				direction = "LU";
				length(grid, x - 1, y - 1);
			}
		}
		if (out.length() > 0)
			return;

		if (x - 1 >= 0 && y + 1 >= 0 && !direction.equals("LD")) {
			if (grid[x - 1][y + 1] == '.') {
				length++;
				direction = "RU";
				length(grid, x - 1, y + 1);
			}
		}
		if (out.length() > 0)
			return;

		if (x + 1 >= 0 && y - 1 >= 0 && !direction.equals("RU")) {
			if (grid[x + 1][y - 1] == '.') {
				length++;
				direction = "LD";
				length(grid, x + 1, y - 1);
			}
		}
		if (out.length() > 0)
			return;

		if (x + 1 >= 0 && y + 1 >= 0 && !direction.equals("LU")) {
			if (grid[x + 1][y + 1] == '.') {
				length++;
				direction = "RD";
				length(grid, x + 1, y + 1);
			}
		}
		if (out.length() > 0)
			return;

		if (x - 1 >= 0) {
			if (grid[x - 1][y] == '.' && !direction.equals("D")) {
				length++;
				direction = "U";
				length(grid, x - 1, y);
			}
		}
		if (out.length() > 0)
			return;

		if (x + 1 < n && !direction.equals("U")) {
			if (grid[x + 1][y] == '.') {
				length++;
				direction = "D";
				length(grid, x + 1, y);
			}
		}
		if (out.length() > 0)
			return;

		if (y - 1 >= 0 && !direction.equals("R")) {
			if (grid[x][y - 1] == '.') {
				length++;
				direction = "L";
				length(grid, x, y - 1);
			}
		}
		if (out.length() > 0)
			return;

		if (y + 1 < m && !direction.equals("L")) {
			if (grid[x][y + 1] == '.') {
				length++;
				direction = "R";
				length(grid, x, y + 1);
			}
		}
		if (out.length() > 0)
			return;

		length--;
	}

}
