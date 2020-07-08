import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class trapped_silver {

	public static void main(String[] args) throws IOException {
		/*
		 * BufferedReader br = new BufferedReader(new FileReader("feast.in"));
		 * PrintWriter out = new PrintWriter(new BufferedWriter(new
		 * FileWriter("feast.out")));
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] haybales = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			haybales[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		}
		Arrays.sort(haybales, new Comparator<int[]>() {

			@Override
			public int compare(int[] arg0, int[] arg1) {
				return Integer.compare(arg0[1], arg1[1]);
			}

		});
		System.out.println(Arrays.deepToString(haybales));
	}

}
