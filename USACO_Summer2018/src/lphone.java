import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class lphone {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		String[][] grid = new String[R][C];
		int startr = -1;
		int startc = -1;
		int endr = -1;
		int endc = -1;
		boolean[][] visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String row = br.readLine();
			for (int j = 0; j < C; j++) {
				grid[i][j] = row.charAt(j) + "";
				if (grid[i][j].equals("*")) {
					visited[i][j] = true;
				}
				if (grid[i][j].equals("C")) {
					if (startr == -1) {
						startr = i;
						startc = j;
					} else {
						endr = i;
						endc = j;
					}
				}
			}
		}

		ArrayDeque<Integer> rs = new ArrayDeque<Integer>();
		ArrayDeque<Integer> cs = new ArrayDeque<Integer>();
		ArrayDeque<Integer> costs = new ArrayDeque<Integer>();
		int minturn = Integer.MAX_VALUE;
		int mincost = Integer.MAX_VALUE;
		rs.add(startr);
		cs.add(startc);
		costs.add(0);
		while (!rs.isEmpty()) {
			int len = rs.size();
			/*
			 * System.out.println(rs); System.out.println(cs);
			 * System.out.println(costs); System.out.println();
			 */
			for (int k = 0; k < len; k++) {
				int rtmp = rs.removeFirst();
				int ctmp = cs.removeFirst();
				int cost = costs.removeFirst();
				if (rtmp == endr && ctmp == endc) {
					System.out.println(cost-1);
					System.exit(0);
				}
				if (visited[rtmp][ctmp]) {

					continue;
				}
				visited[rtmp][ctmp] = true;
				int rtmp1 = rtmp;
				int ctmp1 = ctmp;
				while (rtmp1 > 0) {
					if (!visited[rtmp1 - 1][ctmp1]) {
						rs.add(rtmp1 - 1);
						cs.add(ctmp1);
						costs.add(cost + 1);
					} else {
						break;
					}
					rtmp1--;
				}
				rtmp1 = rtmp;
				while (rtmp1 < R - 1) {
					if (!visited[rtmp1 + 1][ctmp1]) {
						rs.add(rtmp1 + 1);
						cs.add(ctmp1);
						costs.add(cost + 1);
					} else {
						break;
					}
					rtmp1++;
				}
				rtmp1 = rtmp;
				while (ctmp1 > 0) {
					if (!visited[rtmp1][ctmp1 - 1]) {
						rs.add(rtmp1);
						cs.add(ctmp1 - 1);
						costs.add(cost + 1);
					} else {
						break;
					}
					ctmp1--;
				}
				ctmp1 = ctmp;
				while (ctmp1 < C - 1) {
					if (!visited[rtmp1][ctmp1 + 1]) {
						rs.add(rtmp1);
						cs.add(ctmp1 + 1);
						costs.add(cost + 1);
					} else {
						break;
					}
					ctmp1++;
				}
				ctmp1 = ctmp;
			}
		}

	}

}
