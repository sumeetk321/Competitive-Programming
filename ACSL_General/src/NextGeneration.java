import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NextGeneration {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("NextGeneration.txt");
		Scanner scan = new Scanner(file);
		for (int i = 0; i < 2; i++) {
			String[] alive = scan.nextLine().split(", ");
			int[][] grid = new int[7][7];
			for (int j = 1; j < alive.length; j += 2) {
				grid[Integer.parseInt(alive[j]) - 1][Integer.parseInt(alive[j + 1]) - 1] = 1;
			}
			for (int j = 0; j < 7; j++) {
				for (int k = 0; k < 7; k++) {
					if (!(grid[j][k] == 1)) {

						grid[j][k] = 0;
					}
				}

			}
			String[] rules = scan.nextLine().split(", ");
			int[] birth = new int[Integer.parseInt(rules[0])];
			for (int j = 1; j <= birth.length; j++) {
				birth[j - 1] = Integer.parseInt(rules[j]);
			}
			int[] survival = new int[rules.length - birth.length + 1];
			for (int j = birth.length + 1; j < rules.length; j++) {
				survival[j - birth.length - 1] = Integer.parseInt(rules[j]);
			}
			ArrayList<String> coords = new ArrayList<String>();
			for (int j = 0; j < 5; j++) {
				String[] in = scan.nextLine().split(", ");
				int x = Integer.parseInt(in[0]) - 1;
				int y = Integer.parseInt(in[1]) - 1;
				if (grid[x][y] == 1) {
					System.out.print("A, ");
				} else {
					System.out.print("D, ");
				}
				int sum = 0;
				if (x > 0)
					sum += grid[x - 1][y];
				if (y > 0)
					sum += grid[x][y - 1];
				if (x < 6)
					sum += grid[x + 1][y];
				if (y < 6)
					sum += grid[x][y + 1];
				if (x > 0 && y > 0)
					sum += grid[x - 1][y - 1];
				if (x > 0 && y < 6)
					sum += grid[x - 1][y + 1];
				if (x < 6 && y > 0)
					sum += grid[x + 1][y - 1];
				if (x < 6 && y < 6)
					sum += grid[x + 1][y + 1];
				System.out.print(sum + ", ");

				if (grid[x][y] == 1) {
					boolean notok = true;
					for (int a : survival) {
						if (a == sum) {
							notok = false;
							System.out.print("A");
							break;
						}
					}
					if (notok)
						System.out.print("D");
				} else {
					boolean notok = true;
					for (int a : birth) {
						if (a == sum) {
							notok = false;
							System.out.print("A");
							break;
						}
					}
					if (notok)
						System.out.print("D");
				}

				System.out.println();
			}
			System.out.println();
		}
	}

}
