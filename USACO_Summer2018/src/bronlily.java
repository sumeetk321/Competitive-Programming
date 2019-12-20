import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class bronlily {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M1 = Integer.parseInt(st.nextToken());
		int M2 = Integer.parseInt(st.nextToken());
		String[][] grid = new String[M][N];
		boolean[][] visited = new boolean[M][N];
		lilypoint start = null;
		lilypoint end = null;
		ArrayDeque<lilypoint> points = new ArrayDeque<lilypoint>();
		ArrayDeque<Integer> costs = new ArrayDeque<Integer>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = st.nextToken();
				if (grid[i][j].equals("3")) {
					start = new lilypoint(i, j);
					continue;
				}
				if (grid[i][j].equals("4")) {
					end = new lilypoint(i, j);
					continue;
				}
				if (!grid[i][j].equals("1")) {
					visited[i][j] = true;
				}
			}
		}
		points.add(start);
		costs.add(0);
		int costnum = 1;
		while (!points.isEmpty()) {
			int len = points.size();
			for (int i = 0; i < len; i++) {
				lilypoint x = points.removeFirst();
				if (x.lilyequals(end)) {
					System.out.println(costs.removeFirst());
					System.exit(0);
				} else {
					costs.removeFirst();
				}
				if (x.M - M1 >= 0 && x.N - M2 >= 0 && !visited[x.M - M1][x.N - M2]) {
					points.add(new lilypoint(x.M - M1, x.N - M2));
					costs.add(costnum);
					visited[x.M - M1][x.N - M2] = true;
				}
				if (x.M - M1 >= 0 && x.N + M2 < N && !visited[x.M - M1][x.N + M2]) {
					points.add(new lilypoint(x.M - M1, x.N + M2));
					costs.add(costnum);
					visited[x.M - M1][x.N + M2] = true;
				}
				if (x.M + M1 < M && x.N - M2 >= 0 && !visited[x.M + M1][x.N - M2]) {
					points.add(new lilypoint(x.M + M1, x.N - M2));
					costs.add(costnum);
					visited[x.M + M1][x.N - M2] = true;
				}
				if (x.M + M1 < M && x.N + M2 < N && !visited[x.M + M1][x.N + M2]) {
					points.add(new lilypoint(x.M + M1, x.N + M2));
					costs.add(costnum);
					visited[x.M + M1][x.N + M2] = true;
				}

				if (x.M - M2 >= 0 && x.N - M1 >= 0 && !visited[x.M - M2][x.N - M1]) {
					points.add(new lilypoint(x.M - M2, x.N - M1));
					costs.add(costnum);
					visited[x.M - M2][x.N - M1] = true;
				}
				// START HERE
				if (x.M - M2 >= 0 && x.N + M1 < N && !visited[x.M - M2][x.N + M1]) {
					points.add(new lilypoint(x.M - M2, x.N + M1));
					costs.add(costnum);
					visited[x.M - M2][x.N + M1] = true;
				}
				if (x.M + M2 < M && x.N - M1 >= 0 && !visited[x.M + M2][x.N - M1]) {
					points.add(new lilypoint(x.M + M2, x.N - M1));
					costs.add(costnum);
					visited[x.M + M2][x.N - M1] = true;
				}
				if (x.M + M2 < M && x.N + M1 < N && !visited[x.M + M2][x.N + M1]) {
					points.add(new lilypoint(x.M + M2, x.N + M1));
					costs.add(costnum);
					visited[x.M + M2][x.N + M1] = true;
				}
			}
			costnum++;
		}
	}

}

class lilypoint {
	public int M;
	public int N;

	public lilypoint(int r1, int c1) {
		M = r1;
		N = c1;
	}

	public boolean lilyequals(lilypoint x) {
		return (this.M == x.M) && (this.N == x.N);
	}
}
