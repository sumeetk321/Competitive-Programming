import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class paintjob {
	static ArrayDeque<Integer> paintvals = new ArrayDeque<Integer>();
	static ArrayDeque<Integer> costs = new ArrayDeque<Integer>();
	static boolean[] visited = new boolean[10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int[] sparebuckets = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {	
			sparebuckets[i] = Integer.parseInt(st.nextToken());
		}
		paintvals.add(A);
		costs.add(0);
		int currcost = 1;
		while (!paintvals.isEmpty()) {
			int len = paintvals.size();
			for (int i = 0; i < len; i++) {
				int x = paintvals.removeFirst();
				if (x == B) {
					System.out.println(costs.removeFirst());
					System.exit(0);
				} else {
					costs.removeFirst();
				}
				for (int y : sparebuckets) {
					int test = (x * y) % P;
					if (!visited[test]) {
						paintvals.add(test);
						costs.add(currcost);
						visited[test] = true;
					}
				}
			}
			currcost++;
		}
		System.out.println("-1");
	}

}
