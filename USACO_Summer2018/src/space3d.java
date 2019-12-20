import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class space3d {
	static boolean[][][] visited;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				String row = br.readLine();
				for (int k = 0; k < N; k++) {
					if (row.charAt(k) == '.') {
						visited[i][j][k] = true;
					} else {
						visited[i][j][k] = false;
					}
				}
			}
		}
		int out = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (!visited[i][j][k]) {
						out++;
						ArrayDeque<Integer> x = new ArrayDeque<Integer>();
						ArrayDeque<Integer> y = new ArrayDeque<Integer>();
						ArrayDeque<Integer> z = new ArrayDeque<Integer>();
						x.add(i);
						y.add(j);
						z.add(k);
						while (!x.isEmpty()) {
							int x1 = x.removeFirst();
							int y1 = y.removeFirst();
							int z1 = z.removeFirst();
							if (x1 > 0 && !visited[x1 - 1][y1][z1]) {
								x.add(x1 - 1);
								y.add(y1);
								z.add(z1);
								visited[x1 - 1][y1][z1] = true;
							}
							if (x1 < N - 1 && !visited[x1 + 1][y1][z1]) {
								x.add(x1 + 1);
								y.add(y1);
								z.add(z1);
								visited[x1 + 1][y1][z1] = true;
							}
							if (y1 > 0 && !visited[x1][y1 - 1][z1]) {
								x.add(x1);
								y.add(y1 - 1);
								z.add(z1);
								visited[x1][y1 - 1][z1] = true;
							}
							if (y1 < N - 1 && !visited[x1][y1 + 1][z1]) {
								x.add(x1);
								y.add(y1 + 1);
								z.add(z1);
								visited[x1][y1 + 1][z1] = true;
							}
							if (z1 > 0 && !visited[x1][y1][z1 - 1]) {
								x.add(x1);
								y.add(y1);
								z.add(z1 - 1);
								visited[x1][y1][z1 - 1] = true;
							}
							if (z1 < N - 1 && !visited[x1][y1][z1 + 1]) {
								x.add(x1);
								y.add(y1);
								z.add(z1 + 1);
								visited[x1][y1][z1 + 1] = true;
							}
						}
					}
				}
			}
		}
		System.out.println(out);
	}

}
