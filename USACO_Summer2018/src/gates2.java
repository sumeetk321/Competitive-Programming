import java.util.ArrayDeque;
import java.util.Scanner;

public class gates2 {

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		scan.nextLine();
		String path = scan.nextLine();
		boolean[][] visited = new boolean[4 * N + 1][4 * N + 1];
		int startx = 2 * N;
		int starty = 2 * N;
		int minr = Integer.MAX_VALUE;
		int minc = Integer.MAX_VALUE;
		int maxr = 0;
		int maxc = 0;
		for (int i = 0; i < path.length(); i++) {
			switch (path.charAt(i)) {
			case 'N':
				for (int j = 0; j < 2; j++) {
					startx--;
					visited[startx][starty] = true;
				}
				break;
			case 'S':
				for (int j = 0; j < 2; j++) {
					startx++;
					visited[startx][starty] = true;
				}
				break;
			case 'E':
				for (int j = 0; j < 2; j++) {
					starty--;
					visited[startx][starty] = true;
				}
				break;
			case 'W':
				for (int j = 0; j < 2; j++) {
					starty++;
					visited[startx][starty] = true;
				}
				break;
			}
			minr = Math.min(minr, startx);
			minc = Math.min(minc, starty);
			maxr = Math.max(maxr, startx);
			maxc = Math.max(maxc, starty);
		}
		minr -= 2;
		minc -= 2;
		maxr += 2;
		maxc += 2;
		boolean[][] small = new boolean[maxr - minr][maxc - minc];
		for (int i = minr; i < maxr; i++) {
			for (int j = minc; j < maxc; j++) {
				small[i - minr][j - minc] = visited[i][j];
			}
		}
		int regions = 0;
		for (int i = 0; i < maxr - minr; i++) {
			for (int j = 0; j < maxc - minc; j++) {
				if (!small[i][j]) {
					regions++;
					ArrayDeque<Integer> rs = new ArrayDeque<Integer>();
					ArrayDeque<Integer> cs = new ArrayDeque<Integer>();
					rs.add(i);
					cs.add(j);
					while (!rs.isEmpty()) {
						int len = rs.size();
						for (int k = 0; k < len; k++) {
							int rtmp = rs.removeFirst();
							int ctmp = cs.removeFirst();
							if (small[rtmp][ctmp]) {
								continue;
							}
							small[rtmp][ctmp] = true;
							if (rtmp > 0) {
								rs.add(rtmp - 1);
								cs.add(ctmp);
							}
							if (rtmp < maxr - minr - 1) {
								rs.add(rtmp + 1);
								cs.add(ctmp);
							}
							if (ctmp > 0) {
								rs.add(rtmp);
								cs.add(ctmp - 1);
							}
							if (ctmp < maxc - minc - 1) {
								rs.add(rtmp);
								cs.add(ctmp + 1);
							}
						}
					}
				}
			}
		}
		System.out.println(regions - 1);
	}

}
