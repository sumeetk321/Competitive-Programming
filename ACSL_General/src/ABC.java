import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("ABC.txt");
		Scanner scan = new Scanner(file);
		String[] coords = { "", "00", "01", "02", "03", "04", "05", "10", "11", "12", "13", "14", "15", "20", "21",
				"22", "23", "24", "25", "30", "31", "32", "33", "34", "35", "40", "41", "42", "43", "44", "45", "50",
				"51", "52", "53", "54", "55" };
		String[] perms = { "ABC", "ACB", "BAC", "BCA", "CAB", "CBA" };
		for (int i = 0; i < 10; i++) {
			ArrayList<String> letcoords = new ArrayList<String>();
			String[] in = scan.nextLine().split(", ");
			int find = Integer.parseInt(in[in.length-1]);
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
			
			Set<String> set = new HashSet<String>();
			set.addAll(letcoords);
			letcoords.clear();
			letcoords.addAll(set);
			set.clear();
			for (int j = 0; j < 6; j++) {
				int start = 0;
				if (grid[1][1].length() == 0) {
					grid[1][1] = perms[j].charAt(start) + "";
					start++;
				}
				if (grid[1][2].length() == 0) {
					grid[1][2] = perms[j].charAt(start) + "";
					start++;
				}
				if (grid[1][3].length() == 0) {
					grid[1][3] = perms[j].charAt(start) + "";
					start++;
				}
				if (grid[1][4].length() == 0) {
					grid[1][4] = perms[j].charAt(start) + "";
					start++;
				}
				for (int k = 0; k < 6; k++) {
					int start1 = 0;
					if (grid[2][1].length() == 0) {
						grid[2][1] = perms[k].charAt(start1) + "";
						start1++;
					}
					if (grid[2][2].length() == 0) {
						grid[2][2] = perms[k].charAt(start1) + "";
						start1++;
					}
					if (grid[2][3].length() == 0) {
						grid[2][3] = perms[k].charAt(start1) + "";
						start1++;
					}
					if (grid[2][4].length() == 0) {
						grid[2][4] = perms[k].charAt(start1) + "";
						start1++;
					}
					for (int l = 0; l < 6; l++) {
						int start2 = 0;
						if (grid[3][1].length() == 0) {
							grid[3][1] = perms[l].charAt(start2) + "";
							start2++;
						}
						if (grid[3][2].length() == 0) {
							grid[3][2] = perms[l].charAt(start2) + "";
							start2++;
						}
						if (grid[3][3].length() == 0) {
							grid[3][3] = perms[l].charAt(start2) + "";
							start2++;
						}
						if (grid[3][4].length() == 0) {
							grid[3][4] = perms[l].charAt(start2) + "";
							start2++;
						}
						loop: for (int m = 0; m < 6; m++) {
							int start3 = 0;
							if (grid[4][1].length() == 0) {
								grid[4][1] = perms[m].charAt(start3) + "";
								start3++;
							}
							if (grid[4][2].length() == 0) {
								grid[4][2] = perms[m].charAt(start3) + "";
								start3++;
							}
							if (grid[4][3].length() == 0) {
								grid[4][3] = perms[m].charAt(start3) + "";
								start3++;
							}
							if (grid[4][4].length() == 0) {
								grid[4][4] = perms[m].charAt(start3) + "";
								start3++;
							}
							
							int numdifferent = 0;
							for (int a = 1; a < 5; a++) {
								if (grid[1][a].equals(grid[2][a]) || grid[1][a].equals(grid[3][a])
										|| grid[1][a].equals(grid[4][a]) || grid[2][a].equals(grid[3][a])
										|| grid[2][a].equals(grid[4][a]) || grid[3][a].equals(grid[4][a])) {

									for (int b = 1; b < 5; b++) {
										if (!(grid[4][b].equals("O"))) {
											grid[4][b] = "";
										}
									}
									continue loop;
								} else {
									numdifferent++;
								}
							}
							if (numdifferent == 4) {
								
								int numcorrect = 0;
								for (int b = 0; b < letcoords.size(); b++) {
									String x = letcoords.get(b);
									if (grid[Character.getNumericValue(x.charAt(0))][Character
											.getNumericValue(x.charAt(1))].equals(x.charAt(2) + "")) {
										numcorrect++;
									}
								}
								if (numcorrect == letcoords.size()) {
									System.out.println(grid[Character.getNumericValue(coords[find].charAt(0))][Character.getNumericValue(coords[find].charAt(1))]);
								}
							}

							for (int a = 1; a < 5; a++) {
								if (!(grid[4][a].equals("O"))) {
									grid[4][a] = "";
								}
							}
						}
						for (int a = 1; a < 5; a++) {
							if (!(grid[3][a].equals("O"))) {
								grid[3][a] = "";
							}
						}
					}
					for (int a = 1; a < 5; a++) {
						if (!(grid[2][a].equals("O"))) {
							grid[2][a] = "";
						}
					}
				}
				for (int a = 1; a < 5; a++) {
					if (!(grid[1][a].equals("O"))) {
						grid[1][a] = "";
					}
				}
			}
		}

	}

}
