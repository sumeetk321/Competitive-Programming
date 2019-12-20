import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Area {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("Area.txt"));
		for (int i = 0; i < 15; i++) {
			String[] in = scan.nextLine().split(", ");
			int pointsinrow = Integer.parseInt(in[0]);
			int rows = Integer.parseInt(in[1]);
			int[][] grid = new int[rows][pointsinrow];
			int[][] shapes = new int[rows][pointsinrow];
			double area = 0;
			boolean isTriangle = false;
			for (int[] x : shapes) {
				Arrays.fill(x, 0);
			}
			for (int j = 0; j < rows; j++) {
				int max = (pointsinrow * rows - (j + 1) * pointsinrow) + 1;
				for (int k = 0; k < pointsinrow; k++) {
					grid[j][k] = max;
					max++;
				}
			}

			for (int j = 3; j < in.length; j++) {
				int val = Integer.parseInt(in[j]);
				loop: for (int k = 0; k < rows; k++) {
					for (int l = 0; l < pointsinrow; l++) {
						if (grid[k][l] == val) {
							shapes[k][l] = 1;
							break loop;
						}
					}
				}
			}

			for (int j = 0; j < rows; j++) {
				loop: for (int k = 0; k < pointsinrow; k++) {
					try {
						int[][] square = { { shapes[j][k], shapes[j][k + 1] },
								{ shapes[j + 1][k], shapes[j + 1][k + 1] } };
						int ones = 0;
						for (int l = 0; l < 2; l++) {
							for (int m = 0; m < 2; m++) {
								if (square[l][m] == 1) {
									ones++;
								}
							}
						}
						if (ones >= 1) {
							if (ones == 1) {
								isTriangle = true;
							}
							continue loop;
						}
						for (int l = 0; l < 2; l++) {
							for (int m = 0; m < 2; m++) {
								if (square[l][m] == 0) {
									shapes[j + l][k + m] = 2;
								}
							}
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						continue;
					}
				}
			}
			for (int j = 0; j < rows; j++) {
				loop: for (int k = 0; k < pointsinrow; k++) {
					try {
						int[][] square = { { shapes[j][k], shapes[j][k + 1] },
								{ shapes[j + 1][k], shapes[j + 1][k + 1] } };
						int ones = 0;
						int twos = 0;
						for (int l = 0; l < 2; l++) {
							for (int m = 0; m < 2; m++) {
								if (square[l][m] == 1) {
									ones++;
								} else if (square[l][m] == 2) {
									twos++;
								}
							}
						}
						if (ones >= 1) {
							if (ones == 1) {
								if (twos >= 2) {
									area += 0.5;
								}
							}
							continue loop;
						}
						if (twos == 4) {
							area++;
						}

					} catch (ArrayIndexOutOfBoundsException e) {
						continue;
					}
				}
			}
			if(area==0&&isTriangle){
				area = 0.5;
			}
			System.out.println(area);
		}
	}

}
