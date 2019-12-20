import java.util.ArrayDeque;
import java.util.Scanner;

public class pageant2 {

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		Scanner scan = new Scanner(System.in);
		int R = scan.nextInt();
		int C = scan.nextInt();
		scan.nextLine();
		String[][] hide = new String[R][C];
		boolean[][] visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String row = scan.nextLine();
			for (int j = 0; j < C; j++) {
				hide[i][j] = row.charAt(j) + "";
				if (hide[i][j].equals(".")) {
					visited[i][j] = true;
				}
			}
		}
		loop: for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j]) {
					ArrayDeque<Integer> rs = new ArrayDeque<Integer>();
					ArrayDeque<Integer> cs = new ArrayDeque<Integer>();
					rs.add(i);
					cs.add(j);
					while (!rs.isEmpty()) {
						int len = rs.size();
						for (int k = 0; k < len; k++) {
							int rtmp = rs.removeFirst();
							int ctmp = cs.removeFirst();
							if (visited[rtmp][ctmp]) {
								continue;
							}
							visited[rtmp][ctmp] = true;
							hide[rtmp][ctmp] = "Y";
							if (rtmp > 0) {
								rs.add(rtmp - 1);
								cs.add(ctmp);
							}
							if (rtmp < R - 1) {
								rs.add(rtmp + 1);
								cs.add(ctmp);
							}
							if (ctmp > 0) {
								rs.add(rtmp);
								cs.add(ctmp - 1);
							}
							if (ctmp < C - 1) {
								rs.add(rtmp);
								cs.add(ctmp + 1);
							}
						}
					}
					break loop;
				}
			}
		}
		int minlen = Integer.MAX_VALUE;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (hide[i][j].equals("Y")) {
					for (int k = 0; k < R; k++) {
						for (int l = 0; l < C; l++) {
							if (hide[k][l].equals("X")) {
								minlen = Math.min(minlen, Math.abs(i - k) + Math.abs(j - l));
							}
						}
					}
				}
				// System.out.print(hide[i][j]+" ");
			}
			// System.out.println();
		}
		System.out.println(minlen - 1);

	}

}
