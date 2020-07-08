package Contest2_2018;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Lifeguards {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		int N = Integer.parseInt(br.readLine());
		int[][] lifeguards = new int[N][2];
		int[][] overlaps = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			lifeguards[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		}
		if (lifeguards.length == 1) {
			out.println("0");
		} else {
			int overlap = Integer.MIN_VALUE;
			int overlapindex = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					overlaps[i][j] = (overlapAmt(lifeguards[i][0], lifeguards[i][1], lifeguards[j][0],
							lifeguards[j][1]));
					overlaps[j][i] = overlaps[i][j];
				}
			}
			for (int i = 0; i < N; i++) {
				int tmp = 0;
				for (int j = 0; j < N; j++) {
					tmp += overlaps[i][j];
				}
				if (tmp > overlap) {
					overlap = tmp;
					overlapindex = i;
				}

			}
			lifeguards[overlapindex] = new int[] { 0, 0 };
			Arrays.sort(lifeguards, new Comparator<int[]>() {

				@Override
				public int compare(int[] arg0, int[] arg1) {
					return Integer.compare(arg0[0], arg1[0]);
				}

			});

			int timelost = 0;
			for (int i = 1; i < N - 1; i++) {
				timelost += lifeguards[i + 1][0] - lifeguards[i][1];
			}
			out.println(lifeguards[N - 1][1] - lifeguards[1][0] - timelost);
		}
		out.close();
	}

	public static int overlapAmt(int a1, int a2, int b1, int b2) {
		int out = Math.min(a2, b2) - Math.max(a1, b1);
		if (out > 0) {
			return out;
		} else {
			return 0;
		}
	}
}
