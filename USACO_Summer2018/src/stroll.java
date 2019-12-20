import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class stroll {
	static boolean[] visited;
	static int[][] nodes;
	static int max = 0;
	//static String path = "";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int P = Integer.parseInt(br.readLine());
		nodes = new int[P - 1][3];
		visited = new boolean[P - 1];
		StringTokenizer st;
		for (int i = 0; i < P - 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				nodes[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(nodes, new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				return Integer.compare(arg0[0], arg1[0]);
			}
		});
		//System.out.println(Arrays.deepToString(nodes));
		recurse(0, 0);
		//System.out.println(path);
		System.out.println(max);
	}

	public static void recurse(int index, int distance) {
		if (index == -1) {
			//System.out.println(path);
			max = Math.max(max, distance);
			return;
		}
		if (visited[index]) {
			return;
		}
		visited[index] = true;
		//path += nodes[index][1] + "";
		recurse(nodes[index][1] - 1, distance + 1);
		//path = path.substring(0, path.length() - 1);
		//path += nodes[index][2] + "";
		recurse(nodes[index][2] - 1, distance + 1);
		//path = path.substring(0, path.length() - 1);
		visited[index] = false;
	}
}
