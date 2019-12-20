import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Contest3_ACEIntermediate_SumeetKulkarni {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("ACSLWalkInput.txt"));
		int[][] grid;
		int[][] degreevalgrid;
		for (int i = 0; i < 2; i++) {
			System.out.println(i==0?"SAMPLE INPUT:":"TEST INPUT:");
			grid = new int[8][8];
			degreevalgrid = new int[8][8];
			String[] hex = br.readLine().split(", ");
			for (int j = 0; j < hex.length; j++) {
				String x = hex[j];
				String bin = Integer.toBinaryString(Integer.parseInt(x, 16));
				int len = bin.length();
				for (int k = 0; k < 8 - len; k++) {
					bin = "0" + bin;
				}
				for (int k = 0; k < bin.length(); k++) {
					grid[j][k] = Character.getNumericValue(bin.charAt(k));
					if (grid[j][k] == 1) {
						degreevalgrid[j][k] = 90;
					}
				}
			}
			int[][] tmp = new int[8][8];
			for (int y = 0; y < 8; y++) {
				for (int z = 0; z < 8; z++) {
					tmp[y][z] = degreevalgrid[y][z];
				}
			}
			for (int j = 0; j < 5; j++) {
				String[] in = br.readLine().split(", ");
				int r1 = Integer.parseInt(in[0]) - 1;
				int c1 = Integer.parseInt(in[1]) - 1;
				String direction = "";
				switch (in[2]) {
				case "A":
					direction = "B";
					break;
				case "B":
					direction = "A";
					break;
				case "L":
					direction = "R";
					break;
				case "R":
					direction = "L";
					break;
				}
				int numofmoves = Integer.parseInt(in[3]);
				for (int k = 0; k < numofmoves; k++) {
					if (grid[r1][c1] == 1) {
						switch (direction) {
						case "A":
							switch (degreevalgrid[r1][c1]) {
							case 90:
								direction = "L";
								break;
							case 270:
								direction = "R";
								break;
							case 0:
								if (direction.equals("A")) {
									direction = "B";
								} else if (direction.equals("B")) {
									direction = "A";
								} else if (direction.equals("L")) {
									direction = "R";
								} else if (direction.equals("R")) {
									direction = "L";
								}
								break;
							}
							break;
						case "B":
							switch (degreevalgrid[r1][c1]) {
							case 90:
								direction = "R";
								break;
							case 270:
								direction = "L";
								break;
							case 0:
								if (direction.equals("A")) {
									direction = "B";
								} else if (direction.equals("B")) {
									direction = "A";
								} else if (direction.equals("L")) {
									direction = "R";
								} else if (direction.equals("R")) {
									direction = "L";
								}
								break;
							}
							break;
						case "L":
							switch (degreevalgrid[r1][c1]) {
							case 90:
								direction = "B";
								break;
							case 270:
								direction = "A";
								break;
							case 0:
								if (direction.equals("A")) {
									direction = "B";
								} else if (direction.equals("B")) {
									direction = "A";
								} else if (direction.equals("L")) {
									direction = "R";
								} else if (direction.equals("R")) {
									direction = "L";
								}
								break;
							}
							break;
						case "R":
							switch (degreevalgrid[r1][c1]) {
							case 90:
								direction = "A";
								break;
							case 270:
								direction = "B";
								break;
							case 0:
								if (direction.equals("A")) {
									direction = "B";
								} else if (direction.equals("B")) {
									direction = "A";
								} else if (direction.equals("L")) {
									direction = "R";
								} else if (direction.equals("R")) {
									direction = "L";
								}
								break;
							}
							break;

						}
						degreevalgrid[r1][c1] += 90;
						degreevalgrid[r1][c1] %= 360;

					}
					switch (direction) {
					case "A":
						r1--;
						if (r1 == -1) {
							r1 = 7;
						}
						break;
					case "B":
						r1++;
						if (r1 == 8) {
							r1 = 0;
						}
						break;
					case "L":
						c1--;
						if (c1 == -1) {
							c1 = 7;
						}
						break;
					case "R":
						c1++;
						if (c1 == 8) {
							c1 = 0;
						}
						break;
					}
				}
				System.out.println((r1 + 1) + ", " + (c1 + 1));
				for (int y = 0; y < 8; y++) {
					for (int z = 0; z < 8; z++) {
						degreevalgrid[y][z] = tmp[y][z];
					}
				}
			}
			System.out.println();
		}
	}
}
