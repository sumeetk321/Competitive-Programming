/*
ID: sumeetk1
LANG: JAVA
TASK: transform
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class transform {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		int size = Integer.parseInt(br.readLine());
		String[][] grid = new String[size][size];
		String[][] changed = new String[size][size];
		for (int i = 0; i < size; i++) {
			grid[i] = br.readLine().split("");
		}
		for (int i = 0; i < size; i++) {
			changed[i] = br.readLine().split("");
		}
		if (Arrays.deepEquals(changed, turn90(grid))) {
			out.println("1");
		} else if (Arrays.deepEquals(changed, turn180(grid))) {
			out.println("2");
		} else if (Arrays.deepEquals(changed, turn270(grid))) {
			out.println("3");
		} else if (Arrays.deepEquals(changed, reflect(grid))) {
			out.println("4");
		} else {
			String[][] reflected = reflect(grid);
			if (Arrays.deepEquals(changed, turn90(reflected)) || Arrays.deepEquals(changed, turn180(reflected))
					|| Arrays.deepEquals(changed, turn270(reflected))) {
				out.println("5");
			} else if (Arrays.deepEquals(changed, grid)) {
				out.println("6");
			} else {
				out.println("7");
			}
		}
		out.close();
		br.close();
	}

	public static String[][] turn90(String[][] tmp) {
		String[][] out = new String[tmp.length][tmp.length];
		for (int i = 0; i < tmp.length; i++) {
			String[] row = tmp[i];
			for (int j = 0; j < tmp.length; j++) {
				out[j][tmp.length - i - 1] = row[j];
			}
		}
		return out;
	}

	public static String[][] turn180(String[][] tmp) {
		return turn90(turn90(tmp));
	}

	public static String[][] turn270(String[][] tmp) {
		return turn90(turn180(tmp));
	}

	public static String[][] reflect(String[][] tmp) {
		String[][] out = new String[tmp.length][tmp.length];
		for (int i = 0; i < tmp.length; i++) {
			String[] row = tmp[i];
			for (int j = tmp.length - 1; j >= 0; j--) {
				out[i][j] = row[tmp.length - j - 1];
			}
		}
		return out;
	}
}