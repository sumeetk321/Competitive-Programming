import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class lightson {
	static boolean[][] reachable;
	static boolean[][] visited;
	static boolean[][] lit;
	static int[][] onpairs;
	static int maxilluminate = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		onpairs = new int[M][4];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				onpairs[i][j] = Integer.parseInt(st.nextToken()) - 1;
				//System.out.print(onpairs[i][j] + " ");
			}
			//System.out.println();
		}
		reachable = new boolean[N][N];
		visited = new boolean[N][N];
		lit = new boolean[N][N];
		reachable[0][0] = true;
		lit[0][0] = true;

		recurse(0, 0);
		/*for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(lit[i][j] + " ");
			}
			System.out.println();
		}*/
		System.out.println(maxilluminate);
	}

	public static void recurse(int i, int j) {
		if (i < 0 || i > reachable.length - 1 || j < 0 || j > reachable[0].length - 1) {
			return;
		}
		if (visited[i][j]) {
			return;
		}
		if (!reachable[i][j]) {
			return;
		}
		if (!lit[i][j]) {
			return;
		}
		visited[i][j] = true;
		if (i > 0) {
			reachable[i - 1][j] = true;
		}
		if (i < reachable.length - 1) {
			reachable[i + 1][j] = true;
		}
		if (j > 0) {
			reachable[i][j - 1] = true;
		}
		if (j < reachable[0].length - 1) {
			reachable[i][j + 1] = true;
		}
		for (int k = 0; k < onpairs.length; k++) {
			if (onpairs[k][0] == i && onpairs[k][1] == j) {
				//System.out.println(i + ", " + j);
				//System.out.println(Arrays.toString(onpairs[k]));
				if (!lit[onpairs[k][2]][onpairs[k][3]]) {
					lit[onpairs[k][2]][onpairs[k][3]] = true;
					maxilluminate++;
				}
				recurse(onpairs[k][2], onpairs[k][3]);
			}
		}
		recurse(i - 1, j);
		recurse(i + 1, j);
		recurse(i, j - 1);
		recurse(i, j + 1);

	}

}
