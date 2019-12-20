import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class flyingcow {
	static int min = Integer.MAX_VALUE;
	static ArrayDeque<Integer> locs = new ArrayDeque<Integer>();
	static ArrayDeque<Integer> costs = new ArrayDeque<Integer>();
	static boolean[] visited = new boolean[1000002];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		locs.add(1);
		costs.add(0);
		visited[1] = true;
		int currcost = 1;
		while (true) {
			/*
			 * System.out.println(locs); System.out.println(costs);
			 * System.out.println();
			 */
			int len = locs.size();
			for (int i = 0; i < len; i++) {
				int x = locs.removeFirst();
				if (x == N) {
					System.out.println(costs.removeFirst());
					System.exit(0);
				} else {
					costs.removeFirst();
				}
				if (x - 1 > 0 && !visited[x - 1]) {
					locs.add(x - 1);
					costs.add(currcost);
					visited[x - 1] = true;
				}
				if (x + 1 <= Math.min(2 * N, 1000000) && !visited[x + 1]) {
					locs.add(x + 1);
					costs.add(currcost);
					visited[x + 1] = true;
				}
				if (3 * x <= Math.min(2 * N, 1000000) && !visited[3 * x]) {
					locs.add(3 * x);
					costs.add(currcost);
					visited[3 * x] = true;
				}
			}
			currcost++;
		}
		// System.out.println(costs.get(locs.indexOf(N)));
	}
}
