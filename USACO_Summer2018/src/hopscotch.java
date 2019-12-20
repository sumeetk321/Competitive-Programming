import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hopscotch {
	static int numways = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		String[][] grid = new String[R][C];
		for(int i = 0; i < R; i++){
			String row = br.readLine();
			for(int j = 0; j < C; j++){
				grid[i][j] = row.charAt(j)+"";
			}
		}
		recurse(0, 0, grid);
		System.out.println(numways);
	}

	public static void recurse(int R, int C, String[][] grid){
		if(R==grid.length-1&&C==grid[0].length-1){
			numways++;
			return;
		}
		for(int i = R+1; i < grid.length; i++){
			for(int j = C+1; j < grid[0].length; j++){
				if(!grid[i][j].equals(grid[R][C])){
					//System.out.println("i: "+i+", j: "+j);
					recurse(i, j, grid);
				}
			}
		}
	}
}
