import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Abalone {
	static String backwardsalpha = "IHGFEDCBA";
	static int[][] indexgrid = new int[][] { { 5, 6, 7, 8, 9 }, { 4, 5, 6, 7, 8, 9 }, { 3, 4, 5, 6, 7, 8, 9 },
			{ 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8 },
			{ 1, 2, 3, 4, 5, 6, 7 }, { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5 } };
	static int[][] indexgridb = new int[][] { { 9, 8, 7, 6, 5 }, { 9, 8, 7, 6, 5, 4 }, { 9, 8, 7, 6, 5, 4, 3 },
			{ 9, 8, 7, 6, 5, 4, 3, 2 }, { 9, 8, 7, 6, 5, 4, 3, 2, 1 }, { 8, 7, 6, 5, 4, 3, 2, 1 },
			{ 7, 6, 5, 4, 3, 2, 1 }, { 6, 5, 4, 3, 2, 1 }, { 5, 4, 3, 2, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Abalone.txt"));
		String[][] grid = new String[9][];
		String[] rrpatterns = { ".*BBBWWO*", ".*WWWBBO*", ".*BBBWO*", ".*WWWBO*", ".*BBWO*", ".*WWBO*" };
		String[] rlpatterns = { "O*WWBBB.*", "O*BBWWW.*", "O*WBBB.*", "O*BWWW.*", "O*WBB.*", "O*BWW.*" };
		String[] rrpopatterns = { ".*BBBWW", ".*WWWBB", ".*BBBW", ".*WWWB", ".*BBW", ".*WWB" };
		String[] rlpopatterns = { "WWBBB.*", "BBWWW.*", "WBBB.*", "BWWW.*", "WBB.*", "BWW.*" };
		mainloop: for (int i = 0; i < 15; i++) {
			grid[0] = new String[5];
			grid[1] = new String[6];
			grid[2] = new String[7];
			grid[3] = new String[8];
			grid[4] = new String[9];
			grid[5] = new String[8];
			grid[6] = new String[7];
			grid[7] = new String[6];
			grid[8] = new String[5];
			for (int j = 0; j < 9; j++) {
				Arrays.fill(grid[j], "O");
			}
			String[] in = br.readLine().split(", ");
			int firstnum = Integer.parseInt(in[0]);
			for (int j = 1; j < firstnum + 1; j++) {
				int row = backwardsalpha.indexOf(in[j].charAt(0) + "");
				int diagonal = Character.getNumericValue(in[j].charAt(1));
				for (int k = 0; k < indexgrid[row].length; k++) {
					if (indexgrid[row][k] == diagonal) {
						grid[row][k] = "B";
						break;
					}
				}
			}
			for (int j = firstnum + 2; j < in.length; j++) {
				int row = backwardsalpha.indexOf(in[j].charAt(0) + "");
				int diagonal = Character.getNumericValue(in[j].charAt(1));
				for (int k = 0; k < indexgrid[row].length; k++) {
					if (indexgrid[row][k] == diagonal) {
						grid[row][k] = "W";
					}
				}
			}
			for (int j = 0; j < 9; j++) {
				String rowstr = "";
				for (String x : grid[j]) {
					rowstr += x;
				}
				for (String x : rrpopatterns) {
					if (rowstr.matches(x)) {
						System.out.println("Y, RR, 1, " + x.charAt(x.length() - 1));
						continue mainloop;
					}
				}
				for (String x : rlpopatterns) {
					if (rowstr.matches(x)) {
						System.out.println("Y, RL, 1, " + rowstr.charAt(0));
						continue mainloop;
					}
				}
				for (String x : rrpatterns) {
					if (rowstr.matches(x)) {
						System.out.println("Y, RR, 0");
						continue mainloop;
					}
				}
				for (String x : rlpatterns) {
					if (rowstr.matches(x)) {
						System.out.println("Y, RL, 0");
						continue mainloop;
					}
				}
			}
			for(int j = 0; j < 9; j++){
				String diagstr = "";
				for(int k = 0; k < 9; k++){
					for(int l = 0; l < indexgrid[k].length; l++){
						if(indexgrid[k][l]==j+1){
							diagstr+=grid[k][l];
						}
					}
				}
				for (String x : rrpopatterns) {
					if (diagstr.matches(x)) {
						System.out.println("Y, DDR, 1, " + x.charAt(x.length() - 1));
						continue mainloop;
					}
				}
				for (String x : rlpopatterns) {
					if (diagstr.matches(x)) {
						System.out.println("Y, DUL, 1, " + diagstr.charAt(0));
						continue mainloop;
					}
				}
				for (String x : rrpatterns) {
					if (diagstr.matches(x)) {
						System.out.println("Y, DDR, 0");
						continue mainloop;
					}
				}
				for (String x : rlpatterns) {
					if (diagstr.matches(x)) {
						System.out.println("Y, DUL, 0");
						continue mainloop;
					}
				}
				diagstr = "";
				for(int k = 0; k < 9; k++){
					for(int l = 0; l < indexgridb[k].length; l++){
						if(indexgridb[k][l]==j+1){
							diagstr+=grid[k][l];
						}
					}
				}
				for (String x : rrpopatterns) {
					if (diagstr.matches(x)) {
						System.out.println("Y, DDL, 1, " + x.charAt(x.length() - 1));
						continue mainloop;
					}
				}
				for (String x : rlpopatterns) {
					if (diagstr.matches(x)) {
						System.out.println("Y, DUR, 1, " + diagstr.charAt(0));
						continue mainloop;
					}
				}
				for (String x : rrpatterns) {
					if (diagstr.matches(x)) {
						System.out.println("Y, DDL, 0");
						continue mainloop;
					}
				}
				for (String x : rlpatterns) {
					if (diagstr.matches(x)) {
						System.out.println("Y, DUR, 0");
						continue mainloop;
					}
				}
			}
			System.out.println("N");
		}
	}

}
