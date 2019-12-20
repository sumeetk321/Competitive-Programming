import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pachinko {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int R = Integer.parseInt(br.readLine());
		int[][] triangle = new int[R][R];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int j = 0;
			while (st.hasMoreTokens()) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}

		System.out.println(dfs(triangle, R, 0, 0, triangle[0][0]));

	}

	public static int dfs(int[][] triangle, int R, int currrow, int currindex, int currsum) {
		if (currrow == R - 1) {
			/*if (currindex < R - 1) {
				return Math.max(triangle[currrow][currindex], triangle[currrow][currindex + 1]) + currsum;
			}*/
			return currsum;
		}
		//System.out.println(currsum);
		return Math.max(dfs(triangle, R, currrow + 1, currindex, currsum + triangle[currrow + 1][currindex]),
				dfs(triangle, R, currrow + 1, currindex + 1, currsum + triangle[currrow + 1][currindex + 1]));
	}
}
