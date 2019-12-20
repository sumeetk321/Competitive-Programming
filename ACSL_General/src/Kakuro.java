import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Kakuro {
	static Set<String[][]> grids = new HashSet<String[][]>();
	static String[][] solvedgrid;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("Kakuro.txt"));
		long start = System.nanoTime();
		for (int i = 0; i < 2; i++) {
			int num = (i == 0 ? 8 : 10);
			String[] rowcol = scan.nextLine().split(", ");
			int[][] gridindex = new int[Integer.parseInt(rowcol[0])][Integer.parseInt(rowcol[1])];
			String[][] grid = new String[Integer.parseInt(rowcol[0])][Integer.parseInt(rowcol[1])];
			String[][] grid2 = new String[Integer.parseInt(rowcol[0])][Integer.parseInt(rowcol[1])];
			int index = 1;
			for (int j = 0; j < Integer.parseInt(rowcol[0]); j++) {
				for (int k = 0; k < Integer.parseInt(rowcol[1]); k++) {
					gridindex[j][k] = index;
					index++;
					grid[j][k] = "";
					grid2[j][k] = "";
				}
			}
			String[] xs = scan.nextLine().split(", ");
			for (String x : xs) {
				int xnum = Integer.parseInt(x);
				setGridIndex(gridindex, grid, xnum, "0");
			}
			String[] dirsquares = scan.nextLine().split(", ");
			for (int j = 0; j < dirsquares.length; j += 2) {
				int dirloc = Integer.parseInt(dirsquares[j]);
				String[] square = dirsquares[j + 1].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
				if (square[0].equals("0"))
					break;
				if (getGridIndex(gridindex, grid, dirloc).contains("\\")) {
					switch (square[1]) {
					case "A":
						setGridIndex(gridindex, grid, dirloc, getGridIndex(gridindex, grid, dirloc) + square[0]);
						break;
					case "B":
						setGridIndex(gridindex, grid, dirloc, square[0] + getGridIndex(gridindex, grid, dirloc));
						break;
					}
				} else {
					switch (square[1]) {
					case "A":
						setGridIndex(gridindex, grid, dirloc, "\\" + square[0]);
						break;
					case "B":
						setGridIndex(gridindex, grid, dirloc, square[0] + "\\");
						break;
					}
				}
			}
			for (int j = 0; j < grid.length; j++) {
				for (int k = 0; k < grid[0].length; k++) {
					if (grid[j][k].endsWith("\\")) {
						grid[j][k] += "0";
					} else if (grid[j][k].startsWith("\\")) {
						grid[j][k] = "0" + grid[j][k];
					}
					grid2[j][k] = grid[j][k];
				}
			}
			int firstrow = 0;
			loop: for (int j = 0; j < grid.length; j++) {
				for (int k = 0; k < grid[0].length; k++) {
					if (grid[j][k].equals("")) {
						firstrow = j;
						break loop;
					}
				}
			}
			solvedgrid = new String[grid.length][grid[0].length];

			findValidGrid(grid, firstrow);
			for (int j = 0; j < num; j++) {
				System.out.println(getGridIndex(gridindex, solvedgrid, Integer.parseInt(scan.nextLine())));
			}
			System.out.println();
		}
		long end = System.nanoTime();
		System.out.println("TIME: "+(end-start)+" milliseconds");
	}

	public static boolean isValidGrid(String[][] grid) {
		for (int i = 0; i < grid[0].length; i++) {
			int columnsum = 0;
			int shouldbe = 0;
			ArrayList<String> elements = new ArrayList<String>();
			for (int j = 0; j < grid.length; j++) {
				if (grid[j][i].contains("\\")) {
					String[] test = grid[j][i].split("\\\\");
					if (Integer.parseInt(test[0]) != 0) {
						shouldbe = Integer.parseInt(test[0]);
					}
				} else {
					columnsum += Integer.parseInt(grid[j][i]);
				}
				if (elements.contains(grid[j][i]) && !grid[j][i].equals("0")) {
					continue;
				} else {
					elements.add(grid[j][i]);
				}
			}
			if ((columnsum != shouldbe) || (elements.size() < grid.length)) {
				return false;
			}

		}
		return true;

	}

	public static void findValidGrid(String[][] grid, int depth) {

		int numofblanks = 0;
		ArrayList<Integer> blanks = new ArrayList<Integer>();
		int rowsum = 0;
		for (int i = 0; i < grid[0].length; i++) {
			if (grid[depth][i].equals("")) {
				numofblanks++;
				blanks.add(i);
			}
			if (grid[depth][i].contains("\\")) {
				String[] test = grid[depth][i].split("\\\\");
				if (!test[1].equals("0")) {
					rowsum = Integer.parseInt(test[1]);
				}
			}
		}
		for (String x : returnSums(rowsum, numofblanks)) {
			String[][] tmp = new String[grid.length][grid[0].length];
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					tmp[i][j] = grid[i][j];
				}
			}
			String[] addnums = x.split("\\+");
			Set<String> test = new HashSet<String>();
			for (String y : addnums) {
				test.add(y);
			}
			if (test.size() < addnums.length) {
				for (int i = 0; i < grid.length; i++) {
					for (int j = 0; j < grid[0].length; j++) {
						grid[i][j] = tmp[i][j];
					}
				}
				continue;
			}

			int numindex = 0;
			for (int z : blanks) {
				grid[depth][z] = addnums[numindex];
				numindex++;
			}
			if (depth == grid.length - 1) {
				if (isValidGrid(grid)) {
					for (int j = 0; j < grid.length; j++) {
						for (int k = 0; k < grid[0].length; k++) {
							solvedgrid[j][k] = grid[j][k];
						}
					}
				}
			} else {
				findValidGrid(grid, depth + 1);
			}
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					grid[i][j] = tmp[i][j];
				}
			}
		}

	}

	public static String getGridIndex(int[][] gridindex, String[][] grid, int index) {
		for (int i = 0; i < gridindex.length; i++) {
			for (int j = 0; j < gridindex[0].length; j++) {
				if (gridindex[i][j] == index) {
					return grid[i][j];
				}
			}
		}
		return "";
	}

	public static void setGridIndex(int[][] gridindex, String[][] grid, int index, String set) {
		for (int i = 0; i < gridindex.length; i++) {
			for (int j = 0; j < gridindex[0].length; j++) {
				if (gridindex[i][j] == index) {
					grid[i][j] = set;
				}
			}
		}
	}

	public static Set<String> returnSums(int num, int depth) {
		return returnSums(num, depth, new ArrayList<Integer>());
	}

	public static Set<String> returnSums(int num, int depth, ArrayList<Integer> values) {
		Set<String> out = new HashSet<String>();
		for (int i = 1; i < 10; i++) {
			if (values.contains(i)) {
				continue;
			} else {
				values.add(i);
				if (depth == 1) {
					int tmp = 0;
					for (int x : values) {
						tmp += x;
					}
					if (tmp == num) {
						String numset = values.get(0) + "";
						for (int j = 1; j < values.size(); j++) {
							numset += "+" + values.get(j);
						}
						out.add(numset);
					}
				} else {
					out.addAll(returnSums(num, depth - 1, values));
				}
				values.remove(values.indexOf(i));
			}
		}
		return out;
	}
}
