import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class helpcross_silver {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));

		/*
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); PrintWriter out = new PrintWriter(new
		 * BufferedOutputStream(System.out));
		 */

		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] chickens = new int[C];
		for (int i = 0; i < C; i++) {
			chickens[i] = Integer.parseInt(br.readLine());
		}
		int[][] cows = new int[N][2];
		boolean[] visited = new boolean[C];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cows[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		}
		Arrays.sort(chickens);
		Arrays.sort(cows, new Comparator<int[]>() {

			@Override
			public int compare(int[] arg0, int[] arg1) {
				return Integer.compare(arg0[0], arg1[0]);
			}

		});
		/*
		 * System.out.println(Arrays.toString(chickens));
		 * System.out.println(Arrays.deepToString(cows));
		 */
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < C; j++) {
				if (visited[j])
					continue;
				if (chickens[j] >= cows[i][0] && chickens[j] <= cows[i][1]) {
					visited[j] = true;
					res++;
					break;
				}
			}
		}
		out.println(res);
		out.close();
		br.close();
	}

}
