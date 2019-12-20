import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class kcow {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		String[][] pasture = new String[R][C];
		boolean[][] visited = new boolean[R][C];
		int startr = 0;
		int startc = 0;
		int endr = 0;
		int endc = 0;
		for (int i = 0; i < R; i++) {
			String row = br.readLine();
			for (int j = 0; j < C; j++) {
				pasture[i][j] = row.charAt(j) + "";
				if (pasture[i][j].equals("*")) {
					visited[i][j] = true;
				}
				if (pasture[i][j].equals("K")) {
					startr = i;
					startc = j;
				}
				if (pasture[i][j].equals("H")) {
					endr = i;
					endc = j;
				}
			}
		}
		ArrayDeque<Integer> xs = new ArrayDeque<Integer>();
		ArrayDeque<Integer> ys = new ArrayDeque<Integer>();
		ArrayDeque<Integer> costs = new ArrayDeque<Integer>();
		xs.add(startr);
		ys.add(startc);
		costs.add(0);
		while (!xs.isEmpty()) {
			int xtmp = xs.removeFirst();
			int ytmp = ys.removeFirst();
			int cost = costs.removeFirst();
			if (xtmp == endr && ytmp == endc) {
				System.out.println(cost);
				break;
			}
			visited[xtmp][ytmp] = true;
			if (xtmp > 1 && ytmp > 0 && !visited[xtmp - 2][ytmp - 1]) {
				xs.add(xtmp - 2);
				ys.add(ytmp - 1);
				costs.add(cost + 1);
				visited[xtmp - 2][ytmp - 1] = true;
			}
			if (xtmp > 1 && ytmp < C - 1 && !visited[xtmp - 2][ytmp + 1]) {
				xs.add(xtmp - 2);
				ys.add(ytmp + 1);
				costs.add(cost + 1);
				visited[xtmp - 2][ytmp + 1] = true;
			}
			if (xtmp < R - 2 && ytmp > 0 && !visited[xtmp + 2][ytmp - 1]) {
				xs.add(xtmp + 2);
				ys.add(ytmp - 1);
				costs.add(cost + 1);
				visited[xtmp + 2][ytmp - 1] = true;
			}
			if (xtmp < R - 2 && ytmp < C - 1 && !visited[xtmp + 2][ytmp + 1]) {
				xs.add(xtmp + 2);
				ys.add(ytmp + 1);
				costs.add(cost + 1);
				visited[xtmp + 2][ytmp + 1] = true;
			}
			if (ytmp > 1 && xtmp > 0 && !visited[xtmp - 1][ytmp - 2]) {
				xs.add(xtmp - 1);
				ys.add(ytmp - 2);
				costs.add(cost + 1);
				visited[xtmp - 1][ytmp - 2] = true;
			}
			if (ytmp > 1 && xtmp < R - 1 && !visited[xtmp + 1][ytmp - 2]) {
				xs.add(xtmp + 1);
				ys.add(ytmp - 2);
				costs.add(cost + 1);
				visited[xtmp + 1][ytmp - 2] = true;
			}
			if (ytmp < C - 2 && xtmp > 0 && !visited[xtmp - 1][ytmp + 2]) {
				xs.add(xtmp - 1);
				ys.add(ytmp + 2);
				costs.add(cost + 1);
				visited[xtmp - 1][ytmp + 2] = true;
			}
			if (ytmp < C - 2 && xtmp < R - 1 && !visited[xtmp + 1][ytmp + 2]) {
				xs.add(xtmp + 1);
				ys.add(ytmp + 2);
				costs.add(cost + 1);
				visited[xtmp + 1][ytmp + 2] = true;
			}
		}
	}
}
