import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class perimeter {
	static int perimeter = 0;
	static boolean[][] visited = new boolean[102][102];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] grid = new int[102][102];
		int[][] coords = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			coords[i][0] = x;
			coords[i][1] = y;
			grid[x][y] = 1;
		}
		/*for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}*/
		floodfill(grid, 0, 0);
		System.out.println(perimeter);
	}
	public static void floodfill(int[][] grid, int r, int c){
		if(grid[r][c]==1){
			perimeter++;
			return;
		}
		if(visited[r][c]){
			return;
		} else {
			visited[r][c] = true;
		}
		if(r>0){
			floodfill(grid, r-1, c);
		}
		if(r<101){
			floodfill(grid, r+1, c);
		}
		if(c>0){
			floodfill(grid, r, c-1);
		}
		if(c<101){
			floodfill(grid, r, c+1);
		}
	}
}
