import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class homework_silver {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new FileReader("homework.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));

		/*
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); PrintWriter out = new PrintWriter(new
		 * BufferedOutputStream(System.out));
		 */

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] scores = new int[N];
		double[] kvals = new double[N - 1];
		int[] premin = new int[N];
		int[] presum = new int[N];
		for (int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}
		premin[N - 1] = scores[N - 1];
		presum[N - 1] = scores[N - 1];
		for (int i = N - 2; i >= 0; i--) {
			premin[i] = Math.min(premin[i + 1], scores[i]);
			presum[i] = presum[i + 1] + scores[i];
		}
		// System.out.println(Arrays.toString(scores));
		// System.out.println(Arrays.toString(premin));
		// System.out.println(Arrays.toString(presum));
		double max = 0;
		int lastind = N - 1;
		for (int k = 1; k <= N - 2; k++) {
			double test = ((double) presum[k] - (double) premin[k]) / ((double) N - k - 1);
			kvals[k] = test;
			if (test > max) {
				max = test;
			}
			if (kvals[k] == max) {
				lastind = k;
			}
		}
		// System.out.println(Arrays.toString(kvals));
		for (int i = 1; i <= N - 2; i++) {
			if (i == lastind) {
				out.print(i);
			} else if (kvals[i] == max) {
				out.print(i + " ");
			}
		}
		out.close();
		br.close();
	}

}
