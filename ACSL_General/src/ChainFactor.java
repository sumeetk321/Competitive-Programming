import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ChainFactor {
	static ArrayList<String> lets = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("ChainFactor.txt"));
		for (int i = 0; i < 2; i++) {
			int[][] grid = new int[7][7];
			String[] gridstrs = br.readLine().split(", ");
			for (int j = 0; j < gridstrs.length; j++) {
				for (int k = 0; k < gridstrs[j].length(); k++) {
					grid[7 - k - 1][j] = Character.getNumericValue(gridstrs[j].charAt(k));
				}
			}
			String[] disks = br.readLine().split(", ");
			for (String x : disks) {
				System.out.println(destroy(grid, x));
				/*for(int j = 0; j < 7; j++){
					for(int k = 0; k < 7; k++){
						System.out.print(grid[j][k]+" ");
					}
					System.out.println();
				}*/
			}
			System.out.println();
		}
	}

	public static int destroy(int[][] grid, String x) {
		int destroyed = 0;
		String column = x.charAt(0) + "";
		int columnnum = lets.indexOf(column);
		int disknum = Character.getNumericValue(x.charAt(1));
		int insertnum = 0;
		for (int j = 6; j > -1; j--) {
			if (grid[j][columnnum] == 0) {
				grid[j][columnnum] = disknum;
				insertnum = j;
				break;
			}
		}
		if (insertnum == 7 - disknum) {
			for (int j = 6; j > -1; j--) {
				if (grid[j][columnnum] == disknum) {
					grid[j][columnnum] = 0;
					destroyed++;
				}
			}
		} else {
			String horizstr = "";
			for (int j = 0; j < 7; j++) {
				horizstr += grid[insertnum][j] + "";
			}
			String[] check = horizstr.split("0");
			for (String y : check) {
				if (y.length() == disknum) {
					int start = horizstr.indexOf(y);
					for (int j = start; j < start + disknum; j++) {
						if (grid[insertnum][j] == disknum) {
							grid[insertnum][j] = 0;
							destroyed++;
						}
					}
				}
			}
		}
		grid = fixGrid(grid);
		return destroyed;
	}
	
	public static int[][] fixGrid(int[][] grid){
		for(int i = 0; i < 7; i++){
			String reduced = "";
			for(int j = 6; j > -1; j--){
				if(grid[j][i]!=0){
					reduced+=grid[j][i]+"";
					grid[j][i] = 0;
				}
			}
			for(int j = 6; j > 6-reduced.length(); j--){
				grid[j][i] = Character.getNumericValue(reduced.charAt(6-j));
			}
		}
		return grid;
	}
}
