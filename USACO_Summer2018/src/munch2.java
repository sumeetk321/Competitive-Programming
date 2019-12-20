import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class munch2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		String[][] grid = new String[R][C];
		boolean[][] visited = new boolean[R][C];
		point start = null;
		point end = null;
		ArrayDeque<point> points = new ArrayDeque<point>();
		ArrayDeque<Integer> costs = new ArrayDeque<Integer>();
		for (int i = 0; i < R; i++) {
			String row = br.readLine();
			for (int j = 0; j < row.length(); j++) {
				grid[i][j] = row.charAt(j) + "";
				if (grid[i][j].equals("*")) {
					visited[i][j] = true;
				}
				if (grid[i][j].equals("C")) {
					start = new point(i, j);
				}
				if (grid[i][j].equals("B")) {
					end = new point(i, j);
				}
			}
		}
		points.add(start);
		costs.add(0);
		int costnum = 1;
		while (!points.isEmpty()) {
			int len = points.size();
			for(int i = 0; i < len; i++){
				point x = points.removeFirst();
				if(x.pointequals(end)){
					System.out.println(costs.removeFirst());
					System.exit(0);
				} else {
					costs.removeFirst();
				}
				if(x.r-1>=0&&!visited[x.r-1][x.c]){
					points.add(new point(x.r-1, x.c));
					costs.add(costnum);
					visited[x.r-1][x.c] = true;
				}
				if(x.r+1<R&&!visited[x.r+1][x.c]){
					points.add(new point(x.r+1, x.c));
					costs.add(costnum);
					visited[x.r+1][x.c] = true;
				}
				if(x.c-1>=0&&!visited[x.r][x.c-1]){
					points.add(new point(x.r, x.c-1));
					costs.add(costnum);
					visited[x.r][x.c-1] = true;
				}
				if(x.c+1<C&&!visited[x.r][x.c+1]){
					points.add(new point(x.r, x.c+1));
					costs.add(costnum);
					visited[x.r][x.c+1] = true;
				}
			}
			costnum++;
		}
	}

}

class point {
	public int r;
	public int c;

	public point(int r1, int c1) {
		r = r1;
		c = c1;
	}

	public boolean pointequals(point x) {
		return (this.r == x.r) && (this.c == x.c);
	}
}
