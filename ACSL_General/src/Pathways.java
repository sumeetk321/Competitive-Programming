import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pathways {
	static int paths = 0;

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Pathways.txt");
		Scanner scan = new Scanner(file);
		int d = 4;
		for (int i = 0; i < 2; i++) {

			String[] in = scan.nextLine().split(", ");
			String[][] grid = { { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
					{ "", "", "", "", "" }, { "", "", "", "", "" } };
			for (int j = 0; j < in.length; j += 2) {
				if (j == in.length - 2) {
					break;
				} else {
					grid[Integer.parseInt(in[j]) - 1][Integer.parseInt(in[j + 1]) - 1] = "X";
				}
			}
			for (int j = 0; j < d; j++) {
				String[] in1 = scan.nextLine().split(", ");
				paths(grid, Integer.parseInt(in1[0]) - 1, Integer.parseInt(in1[1]) - 1, Integer.parseInt(in1[2]) - 1,
						Integer.parseInt(in1[3]) - 1, new ArrayList<String>());
				if (paths == 0) {
					System.out.println("NONE");
				} else {
					System.out.println(paths);
				}
				paths = 0;
			}
			d++;
			System.out.println("\n");
		}

	}

	public static void paths(String[][] grid, int x1, int y1, int x2, int y2, ArrayList<String> path) {
		if (x1 == x2 && y1 == y2) {

			paths++;
			return;
		}
		if (!path.contains(String.valueOf(x1).concat(String.valueOf(y1)))) {
			path.add(String.valueOf(x1).concat(String.valueOf(y1)));
		}
		if (x1 > 0 && grid[x1 - 1][y1].equals("X")
				&& (!path.contains(String.valueOf(x1 - 1).concat(String.valueOf(y1))))) {
			path.add(String.valueOf(x1 - 1).concat(String.valueOf(y1)));
			paths(grid, x1 - 1, y1, x2, y2, path);
			path.remove(String.valueOf(x1 - 1).concat(String.valueOf(y1)));
		}
		if (y1 < 4 && grid[x1][y1 + 1].equals("X")
				&& (!path.contains(String.valueOf(x1).concat(String.valueOf(y1 + 1))))) {
			path.add(String.valueOf(x1).concat(String.valueOf(y1 + 1)));
			paths(grid, x1, y1 + 1, x2, y2, path);
			path.remove(String.valueOf(x1).concat(String.valueOf(y1 + 1)));
		}

		if (x1 < 4 && grid[x1 + 1][y1].equals("X")
				&& (!path.contains(String.valueOf(x1 + 1).concat(String.valueOf(y1))))) {
			path.add(String.valueOf(x1 + 1).concat(String.valueOf(y1)));
			paths(grid, x1 + 1, y1, x2, y2, path);
			path.remove(String.valueOf(x1 + 1).concat(String.valueOf(y1)));
		}
		if (y1 > 0 && grid[x1][y1 - 1].equals("X")
				&& (!path.contains(String.valueOf(x1).concat(String.valueOf(y1 - 1))))) {
			path.add(String.valueOf(x1).concat(String.valueOf(y1 - 1)));
			paths(grid, x1, y1 - 1, x2, y2, path);
			path.remove(String.valueOf(x1).concat(String.valueOf(y1 - 1)));
		}

	}

}
