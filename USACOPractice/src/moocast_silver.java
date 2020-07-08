import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class moocast_silver {
	static boolean[] visited;
	static int count = 0;
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
		//BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] cows = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cows[i][0] = Integer.parseInt(st.nextToken());
			cows[i][1] = Integer.parseInt(st.nextToken());
			cows[i][2] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			count = 0;
			visited = new boolean[N];
			recurse(i, cows);
			max = Math.max(max, count);
			//System.out.println();
		}
		//System.out.println(dist(1, 3, 5, 4));
		//System.out.println(max);
		pw.println(max);
		pw.close();
		br.close();
	}

	public static void recurse(int start, int[][] cows) {
		int x = cows[start][0];
		int y = cows[start][1];
		int p = cows[start][2];
		//System.out.println("yeet" + x + ", "+ y +": "+p);
		visited[start] = true;
		count++;
		for (int i = 0; i < cows.length; i++) {
			if (!visited[i]) {
				if (((int)Math.ceil(dist(cows[i][0], cows[i][1], x, y))) <= p) {
					recurse(i, cows);
				}
			}
		}
	}

	public static double dist(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
}
