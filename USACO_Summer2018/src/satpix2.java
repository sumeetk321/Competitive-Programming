import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class satpix2 {

	public static void main(String[] args) throws IOException {
		solve();
	}

	public static void solve() throws IOException {
		Scanner scan = new Scanner(System.in);
		int C = scan.nextInt();
		int R = scan.nextInt();
		scan.nextLine();
		String[][] photo = new String[R][C];
		boolean[][] visited = new boolean[R][C];
		int maxcount = 0;
		for (int i = 0; i < R; i++) {
			String row = scan.nextLine();
			for (int j = 0; j < C; j++) {
				photo[i][j] = row.charAt(j) + "";
				if (photo[i][j].equals(".")) {
					visited[i][j] = true;
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
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
							if (rtmp < R - 1 && !visited[rtmp + 1][ctmp]) {
								rs.add(rtmp + 1);
								cs.add(ctmp);
								visited[rtmp + 1][ctmp] = true;
							}
							if (ctmp < C - 1 && !visited[rtmp][ctmp + 1]) {
								rs.add(rtmp);
								cs.add(ctmp + 1);
								visited[rtmp][ctmp + 1] = true;
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
