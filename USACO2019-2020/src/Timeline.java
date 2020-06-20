import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Timeline {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("timeline.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("timeline.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] S = new int[N];
		int[] ans = new int[N];
		int[][] mems = new int[C][3];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
			ans[i] = S[i];
		}
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			mems[i][0] = a;
			mems[i][1] = b;
			mems[i][2] = x;
			ans[b - 1] = ans[a - 1] + x;
			// System.out.print(Arrays.toString(ans));
		}
		for (int i = 0; i < C; i++) {
			int a = mems[i][0];
			int b = mems[i][1];
			int x = mems[i][2];
			if (ans[b - 1] - ans[a - 1] < x) {
				ans[b - 1] = ans[a - 1] + x;
			}
		}
		// System.out.println(Arrays.toString(ans));
		for (int i = 0; i < N; i++) {
			out.println(ans[i]);
		}
		out.close();
	}

}
