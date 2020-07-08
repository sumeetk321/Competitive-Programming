package Contest1_2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class convention2 {
	static boolean used[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		StringTokenizer st;
		int[][] cows = new int[N][3];
		int[][] cowsfake = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cows[i][0] = i;
			cows[i][1] = Integer.parseInt(st.nextToken());
			cows[i][2] = Integer.parseInt(st.nextToken());

		}
		int[][] cowsorig = new int[N][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				cowsorig[i][j] = cows[i][j];
			}
		}
		used = new boolean[N];
		Arrays.sort(cows, new Comparator<int[]>() {

			@Override
			public int compare(int[] arg0, int[] arg1) {
				if (Integer.compare(arg0[1], arg1[1]) == 0) {
					return Integer.compare(arg0[0], arg1[0]);
				}
				return Integer.compare(arg0[1], arg1[1]);
			}

		});
		for (int i = 0; i < N; i++) {
			if (!used[i]) {
				cowsfake[i][0] = cows[i][0];
				cowsfake[i][1] = cows[i][1];
				cowsfake[i][2] = cows[i][2];
				int newarrival = cows[i][1] + cows[i][2];
				// System.out.println(newarrival);
				for (int j = i + 1; j < N; j++) {
					if (cows[j][1] <= newarrival) {
						cowsfake[j][0] = cows[j][0];
						cowsfake[j][1] = newarrival;
						cowsfake[j][2] = cows[j][2];
						used[j] = true;
					}
				}
			}
		}
		Arrays.sort(cowsfake, new Comparator<int[]>() {

			@Override
			public int compare(int[] arg0, int[] arg1) {
				if (Integer.compare(arg0[1], arg1[1]) == 0) {
					return Integer.compare(arg0[0], arg1[0]);
				}
				return Integer.compare(arg0[1], arg1[1]);
			}

		});
		/*
		 * for (int i = 0; i < N; i++) {
		 * System.out.println(Arrays.toString(cowsfake[i])); } for (int i = 0; i
		 * < N; i++) { System.out.println(Arrays.toString(cowsorig[i])); }
		 */
		int currtime = cows[0][1];
		for (int i = 0; i < N; i++) {
			int orig = cowsorig[cowsfake[i][0]][1];
			if (currtime < orig) {
				currtime = orig;
			}
			max = Math.max(max, currtime - orig);
			currtime += cowsfake[i][2];
		}
		out.println(max);
		out.close();
		br.close();
	}

}
