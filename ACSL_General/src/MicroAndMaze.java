import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MicroAndMaze {
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] mat = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++){
				mat[i][j]=Integer.parseInt(st.nextToken());
				if(mat[i][j]==0){
					visited[i][j] = true;
				}
			}
		}
		recurse(mat, 0, 0);
		System.out.println("No");
	}
	
	public static void recurse(int[][] mat, int i, int j){
		if(i>=mat.length||i<0||j>=mat[0].length||j<0){
			return;
		}
		if(visited[i][j]){
			return;
		}
		visited[i][j] = true;
		if(i==mat.length-1&&j==mat[0].length-1){
			System.out.println("Yes");
			System.exit(0);
		}
		recurse(mat, i+1, j);
		recurse(mat, i-1, j);
		recurse(mat, i, j+1);
		recurse(mat, i, j-1);
	}

}
