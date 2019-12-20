import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class sboost {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		double standardacc = (F / M);
		double maxacc = Double.MIN_VALUE;
		int[][] parts = new int[N][3];
		ArrayList<int[]> bestparts = new ArrayList<int[]>();
		ArrayList<Integer> out = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			parts[i][0] = Integer.parseInt(st.nextToken());
			parts[i][1] = Integer.parseInt(st.nextToken());
			parts[i][2] = (i + 1);
		}
		Arrays.sort(parts, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Double.compare(o1[0] / o1[1], o2[0] / o2[1]);
			}

		});
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (parts[i][0] / parts[i][1] > standardacc) {
				bestparts.add(parts[i]);
			}
		}
		for (int i = bestparts.size() - 1; i > -1; i--) {
			double F1 = F + bestparts.get(i)[0];
			double M1 = M + bestparts.get(i)[1];
			if (F1 / M1 > maxacc) {
				maxacc = (double) ((double) F1 / (double) M1);
				F = (int) F1;
				M = (int) M1;
				out.add(bestparts.get(i)[2]);
			}
		}
		if (out.size() == 0) {
			System.out.println("NONE");
		} else {
			Collections.sort(out);
			for (int x : out) {
				System.out.println(x);
			}
		}
	}
}
