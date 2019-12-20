import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class milktemp {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int Z = Integer.parseInt(st.nextToken());
		int[][] AB = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			AB[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		}
		Arrays.sort(AB, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int out = Integer.compare(o1[0], o2[0]);
				if (out == 0) {
					return Integer.compare(o1[1], o2[1]);
				}
				return out;
			}

		});
		HashSet<Integer> visited = new HashSet<Integer>();
		int maxcount = 0;
		for (int i = 0; i < N; i++) {
			for (int m = AB[i][0]; m <= AB[i][1]; m++) {
				if (visited.contains(m)) {
					continue;
				}
				int tmp = 0;
				int hot = 0;
				int cold = 0;
				for (int j = 0; j < N; j++) {
					if (AB[j][0] <= m && m <= AB[j][1]) {
						tmp++;
					} else if (AB[j][1] < m) {
						hot++;
					} else if (AB[j][0] > m) {
						cold++;
					}
				}
				if (maxcount < (tmp * Y) + (cold * X) + (hot * Z)) {
					maxcount = (tmp * Y) + (cold * X) + (hot * Z);
					// System.out.println(tmp + ", " + hot + ", " + cold);
				}
				visited.add(m);
			}
		}
		System.out.println(maxcount);
	}
}