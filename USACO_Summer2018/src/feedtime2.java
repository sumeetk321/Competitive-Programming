import java.util.ArrayDeque;
import java.util.Scanner;

public class feedtime2 {

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		Scanner scan = new Scanner(System.in);
		int W = scan.nextInt();
		int H = scan.nextInt();
		scan.nextLine();
		String[][] grid = new String[H][W];
		boolean[][] visited = new boolean[H][W];
		int maxcount = 0;
		for (int i = 0; i < H; i++) {
			String row = scan.nextLine();
			for (int j = 0; j < W; j++) {
				grid[i][j] = row.charAt(j) + "";
				if (grid[i][j].equals("*")) {
					visited[i][j] = true;
				}
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					ArrayDeque<Integer> rs = new ArrayDeque<Integer>();
					ArrayDeque<Integer> cs = new ArrayDeque<Integer>();
					rs.add(i);
					cs.add(j);
					int tmpcount = 0;
					while (!rs.isEmpty() && !cs.isEmpty()) {
						int len = rs.size();
						for (int k = 0; k < len; k++) {
							int rtmp = rs.removeFirst();
							int ctmp = cs.removeFirst();
							tmpcount++;
							if (rtmp > 0 && !visited[rtmp - 1][ctmp]) {
								rs.add(rtmp - 1);
								cs.add(ctmp);
								visited[rtmp - 1][ctmp] = true;
							}
							if (ctmp > 0 && !visited[rtmp][ctmp - 1]) {
								rs.add(rtmp);
								cs.add(ctmp - 1);
								visited[rtmp][ctmp - 1] = true;
							}
							if (rtmp < H - 1 && !visited[rtmp + 1][ctmp]) {
								rs.add(rtmp + 1);
								cs.add(ctmp);
								visited[rtmp + 1][ctmp] = true;
							}
							if (ctmp < W - 1 && !visited[rtmp][ctmp + 1]) {
								rs.add(rtmp);
								cs.add(ctmp + 1);
								visited[rtmp][ctmp + 1] = true;
							}

							if (rtmp > 0 && ctmp > 0 && !visited[rtmp - 1][ctmp - 1]) {
								rs.add(rtmp - 1);
								cs.add(ctmp - 1);
								visited[rtmp - 1][ctmp - 1] = true;
							}
							if (ctmp > 0 && rtmp < H - 1 && !visited[rtmp + 1][ctmp - 1]) {
								rs.add(rtmp + 1);
								cs.add(ctmp - 1);
								visited[rtmp + 1][ctmp - 1] = true;
							}
							if (rtmp < H - 1 && ctmp < W - 1 && !visited[rtmp + 1][ctmp + 1]) {
								rs.add(rtmp + 1);
								cs.add(ctmp + 1);
								visited[rtmp + 1][ctmp + 1] = true;
							}
							if (ctmp < W - 1 && rtmp > 0 && !visited[rtmp - 1][ctmp + 1]) {
								rs.add(rtmp - 1);
								cs.add(ctmp + 1);
								visited[rtmp - 1][ctmp + 1] = true;
							}
						}
					}
					maxcount = Math.max(maxcount, tmpcount);
				}
			}
		}
		System.out.println(maxcount);
	}

}
