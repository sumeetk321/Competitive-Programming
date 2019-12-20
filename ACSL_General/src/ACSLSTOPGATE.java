import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ACSLSTOPGATE {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Stopgate1.txt");
		Scanner scan = new Scanner(file);
		String[][] grid;
		for (int i = 0; i < 8; i++) {
			grid = new String[8][8];
			for(int j = 0; j < 8; j++){
				for(int k =0 ; k < 8; k++){
					grid[j][k] = "";
				}
			}
			String[] in = scan.nextLine().split(", ");
			String direction = in[0];
			int coords = Integer.parseInt(in[1]);
			int count = 0;
			for (int j = 2; j < coords * 2 + 1; j += 2) {
				if(count>=coords) break;
				if (direction.equals("L")) {
					int y = Integer.parseInt(in[j+1]) - 1;
					int x = 8 - Integer.parseInt(in[j]);
					grid[x][y] = "L";
					grid[x][y+1] = "L";
				} else {
					int y = Integer.parseInt(in[j+1]) - 1;
					int x = 8 - Integer.parseInt(in[j]);
					grid[x][y] = "U";
					grid[x-1][y] = "U";
				}
				count++;
			}
			direction = ((direction.equals("L")) ? "U" : "L");
			count = 0;
			for (int j = coords * 2 + 2; j < in.length; j += 2) {
				if(count>=coords) break;
				if (direction.equals("L")) {
					int y = Integer.parseInt(in[j+1]) - 1;
					int x = 8 - Integer.parseInt(in[j]);
					grid[x][y] = "L";
					grid[x][y+1] = "L";
				} else {
					int y = Integer.parseInt(in[j+1]) - 1;
					int x = 8 - Integer.parseInt(in[j]);
					grid[x][y] = "U";
					grid[x-1][y] = "U";
				}
				count++;
			}
			int ways = 0;
			direction = in[0];
			if(direction.equals("L")){
				for(int j = 0; j < 8; j++){
					for(int k = 0; k < 7; k++){
						if(grid[j][k].equals("") && grid[j][k+1].equals("")){
							ways++;
						}
					}
				}
			} else {
				for(int j = 0; j < 7; j++){
					for(int k = 0; k < 8; k++){
						if(grid[j][k].equals("") && grid[j+1][k].equals("")){
							ways++;
						}
					}
				}
			}
			
			System.out.println(ways);
		}
	}

}
