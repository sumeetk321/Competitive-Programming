import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Contest3_ACEIntermediate_SumeetKulkarni {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("3int_testdata.txt"));

		String[] in = null;
		for (int i = 0; i < 5; i++) {
			in = br.readLine().split("\\+");
			solve(in);
		}

	}

	public static void solve(String[] in) {
		boolean[][] veitch = new boolean[4][4];
		for (String x : in) {
			String[] vars = x.split("");
			for (int i = 0; i < 4; i++) {
				loop: for (int j = 0; j < 4; j++) {
					for (int k = 0; k < vars.length; k++) {
						boolean not = k > 0 && vars[k - 1].equals("~");
						switch (vars[k]) {
						case "A":
							if (not) {
								if (j == 2 || j == 3) {
									continue;
								} else {
									continue loop;
								}
							}
							if (j == 0 || j == 1) {
								continue;
							} else {
								continue loop;
							}

						case "B":
							if (not) {
								if (i == 2 || i == 3) {
									continue;
								} else {
									continue loop;
								}
							}
							if (i == 0 || i == 1) {
								continue;
							} else {
								continue loop;
							}
						case "C":
							if (not) {
								if (j == 0 || j == 3) {
									continue;
								} else {
									continue loop;
								}
							}
							if (j == 1 || j == 2) {
								continue;
							} else {
								continue loop;
							}
						case "D":
							if (not) {
								if (i == 0 || i == 3) {
									continue;
								} else {
									continue loop;
								}
							}
							if (i == 1 || i == 2) {
								continue;
							} else {
								continue loop;
							}

						}

					}
					veitch[i][j] = true;
				}
			}

		}
		print(veitch);

	}

	public static void print(boolean[][] veitch) {

		for (int i = 0; i < 4; i++) {
			String bin = "";
			for (int j = 0; j < 4; j++) {
				bin += veitch[i][j] ? "1" : "0";

			}
			System.out.print(Integer.toHexString(Integer.parseInt(bin, 2)).toUpperCase());

		}
		System.out.println();
	}
}
