import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class cornmaze {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[][] maze = new String[N][M];
		boolean[][] visited = new boolean[N][M];
		mazepoint start = null;
		mazepoint end = null;
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = row.charAt(j) + "";
				if (maze[i][j].equals("@")) {
					start = new mazepoint(i, j);
				} else if (maze[i][j].equals("=")) {
					end = new mazepoint(i, j);
				} else if (maze[i][j].equals("#")) {
					visited[i][j] = true;
				}
			}
		}
		ArrayDeque<mazepoint> points = new ArrayDeque<mazepoint>();
		ArrayDeque<Integer> costs = new ArrayDeque<Integer>();
		points.add(start);
		costs.add(0);
		int costnum = 1;
		while (!points.isEmpty()) {
			int len = points.size();
			for (int i = 0; i < len; i++) {
				mazepoint x = points.removeFirst();
				if ('A' <= Character.toUpperCase(maze[x.i][x.j].charAt(0))
						&& Character.toUpperCase(maze[x.i][x.j].charAt(0)) <= 'Z') {
					loop: for (int j = 0; j < N; j++) {
						for (int k = 0; k < M; k++) {
							if (j == x.i && k == x.j) {
								continue;
							}
							if (maze[j][k].equals(maze[x.i][x.j])) {
								x = new mazepoint(j, k);
								break loop;
							}
						}
					}
				}
				if (x.mazeequals(end)) {
					System.out.println(costs.removeFirst());
					System.exit(0);
				}
				costs.removeFirst();
				if (x.i - 1 >= 0 && !visited[x.i - 1][x.j]) {
					points.add(new mazepoint(x.i - 1, x.j));
					costs.add(costnum);
					visited[x.i - 1][x.j] = true;
				}
				if (x.i + 1 < N && !visited[x.i + 1][x.j]) {
					points.add(new mazepoint(x.i + 1, x.j));
					costs.add(costnum);
					visited[x.i + 1][x.j] = true;
				}
				if (x.j - 1 >= 0 && !visited[x.i][x.j - 1]) {
					points.add(new mazepoint(x.i, x.j - 1));
					costs.add(costnum);
					visited[x.i][x.j - 1] = true;
				}
				if (x.j + 1 < M && !visited[x.i][x.j + 1]) {
					points.add(new mazepoint(x.i, x.j + 1));
					costs.add(costnum);
					visited[x.i][x.j + 1] = true;
				}
			}
			costnum++;
		}
	}

}

class mazepoint {
	public int i;
	public int j;

	public mazepoint(int i1, int j1) {
		i = i1;
		j = j1;
	}

	public boolean mazeequals(mazepoint x) {
		return (x.i == this.i) && (x.j == this.j);
	}
}
