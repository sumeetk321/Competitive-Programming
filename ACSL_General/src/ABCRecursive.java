import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ABCRecursive {
	static String[] coords = { "", "00", "01", "02", "03", "04", "05", "10", "11", "12", "13", "14", "15", "20", "21",
			"22", "23", "24", "25", "30", "31", "32", "33", "34", "35", "40", "41", "42", "43", "44", "45", "50", "51",
			"52", "53", "54", "55" };
	static String[] perms = { "ABC", "ACB", "BAC", "BCA", "CAB", "CBA" };
	static final String[] patterns = new String[4];
	static int count = 0;

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("ABC.txt");
		Scanner scan = new Scanner(file);

		for (int i = 0; i < 10; i++) {
			ArrayList<String> letcoords = new ArrayList<String>();
			String[] in = scan.nextLine().split(", ");
			int find = Integer.parseInt(in[in.length - 1]);
			String[][] grid = new String[6][6];
			for (int a = 0; a < 6; a++) {
				for (int b = 0; b < 6; b++) {
					grid[a][b] = "";
				}
			}
			grid[Character.getNumericValue(coords[Integer.parseInt(in[0])].charAt(0))][Character
					.getNumericValue(coords[Integer.parseInt(in[0])].charAt(1))] = "O";
			grid[Character.getNumericValue(coords[Integer.parseInt(in[1])].charAt(0))][Character
					.getNumericValue(coords[Integer.parseInt(in[1])].charAt(1))] = "O";
			grid[Character.getNumericValue(coords[Integer.parseInt(in[2])].charAt(0))][Character
					.getNumericValue(coords[Integer.parseInt(in[2])].charAt(1))] = "O";
			grid[Character.getNumericValue(coords[Integer.parseInt(in[3])].charAt(0))][Character
					.getNumericValue(coords[Integer.parseInt(in[3])].charAt(1))] = "O";

			String[][] tmp = grid;
			int numoflets = Integer.parseInt(in[4]);
			for (int j = 5; j <= numoflets * 2 + 4; j += 2) {
				if (Integer.parseInt(in[j + 1]) < 6) {
					boolean notdone = true;
					int x = Character.getNumericValue(coords[Integer.parseInt(in[j + 1])].charAt(0)) + 1;
					int y = Character.getNumericValue(coords[Integer.parseInt(in[j + 1])].charAt(1));
					while (notdone && x < 6) {
						if (tmp[x][y].equals("O")) {
							x++;
							continue;
						} else {
							tmp[x][y] = in[j];
							letcoords.add(x + "" + y + "" + in[j]);
							notdone = false;
						}
					}
				} else if (Integer.parseInt(in[j + 1]) > 31) {
					boolean notdone = true;
					int x = Character.getNumericValue(coords[Integer.parseInt(in[j + 1])].charAt(0)) - 1;
					int y = Character.getNumericValue(coords[Integer.parseInt(in[j + 1])].charAt(1));
					while (notdone && x > -1) {
						if (tmp[x][y].equals("O")) {
							x--;
							continue;
						} else {
							tmp[x][y] = in[j];
							letcoords.add(x + "" + y + "" + in[j]);
							notdone = false;
						}
					}
				} else if (Integer.parseInt(in[j + 1]) % 2 == 0) {
					boolean notdone = true;
					int x = Character.getNumericValue(coords[Integer.parseInt(in[j + 1])].charAt(0));
					int y = Character.getNumericValue(coords[Integer.parseInt(in[j + 1])].charAt(1)) - 1;
					while (notdone && y > -1) {
						if (tmp[x][y].equals("O")) {
							y--;
							continue;
						} else {
							tmp[x][y] = in[j];
							letcoords.add(x + "" + y + "" + in[j]);
							notdone = false;
						}
					}
				} else {
					boolean notdone = true;
					int x = Character.getNumericValue(coords[Integer.parseInt(in[j + 1])].charAt(0));
					int y = Character.getNumericValue(coords[Integer.parseInt(in[j + 1])].charAt(1)) + 1;
					while (notdone && y < 6) {
						if (tmp[x][y].equals("O")) {
							y++;
							continue;
						} else {
							tmp[x][y] = in[j];
							letcoords.add(x + "" + y + "" + in[j]);
							notdone = false;
						}
					}
				}
			}

			for (int j = 1; j < 5; j++) {
				for (int k = 1; k < 5; k++) {
					if (grid[j][k].equals(""))
						grid[j][k] = ".";
				}
			}
			patterns[0] = String.join("", grid[1]).replace("O", "");
			patterns[1] = String.join("", grid[2]).replace("O", "");
			patterns[2] = String.join("", grid[3]).replace("O", "");
			patterns[3] = String.join("", grid[4]).replace("O", "");
			solve(grid, 1, find);

		}

	}

	public static void solve(String[][] grid, int depth, int find) {
		Pattern p = Pattern.compile(patterns[depth - 1]);
		ArrayList<String> possibles = new ArrayList<String>();
		for (int i = 0; i < perms.length; i++) {
			Matcher m = p.matcher(perms[i]);
			if (m.matches()) {
				possibles.add(perms[i]);
			}

		}

		// System.out.println("HELLO");
		for (String x : possibles) {
			int offset = 0;
			for (int j = 1; j < 5; j++) {
				if (grid[depth][j].equals("O")) {
					offset++;
					continue;
				}
				grid[depth][j] = x.charAt(j - 1 - offset) + "";
			}

			if (depth == 4) {

				if (isValid(grid)) {
					for(int j = 0; j < 6; j++){
						for(int k = 0; k < 6; k++){
							System.out.print(grid[j][k]);
						}
						System.out.println();
					}
					int l1 = Character.getNumericValue(coords[find].charAt(0));
					int l2 = Character.getNumericValue(coords[find].charAt(1));
					System.out.println(grid[l1][l2]);
				} else {
					continue;
				}
			} else {
				solve(grid, depth + 1, find);
			}
		}
		return;

	}

	public static boolean isValid(String[][] grid) {

		for (int i = 1; i < 5; i++) {
			if ((grid[1][i].equals(grid[2][i])) || (grid[1][i].equals(grid[3][i])) || (grid[1][i].equals(grid[4][i]))
					|| (grid[2][i].equals(grid[3][i])) || (grid[2][i].equals(grid[4][i]))
					|| (grid[3][i].equals(grid[4][i]))) {
				return false;
			} else {
				continue;
			}
		}

		return true;
	}
}
