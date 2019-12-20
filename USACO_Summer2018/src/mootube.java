import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class mootube {
	static boolean[] visited;
	static Edge[] pairs;
	static int[] startindex;
	static int count = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		pairs = new Edge[(N - 1) * 2];
		startindex = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < (N - 1) * 2; i += 2) {
			st = new StringTokenizer(br.readLine());
			pairs[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
			pairs[i + 1] = new Edge(pairs[i].end, pairs[i].start, pairs[i].relevance);
		}
		Arrays.sort(pairs, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.start, o2.start);
			}

		});
		int count1 = 1;
		for (int i = 0; i < (N - 1) * 2; i++) {
			if (count1 > N) {
				break;
			}
			if (pairs[i].start == count1) {
				startindex[count1] = i;
				count1++;
			}
		}
		
		/*for(int i=0; i<startindex.length; i++){
			System.out.println(startindex[i]);
		}*/
		
		// System.out.println(Arrays.toString(startindex));
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			recurse(v, k);
			//pw.println(count);
			count = 0;
			visited = new boolean[N + 1];
		}
		br.close();
		//pw.close();
	}

	public static void recurse(int currvid, int k) {
		int i = startindex[currvid];
		while (i < pairs.length && pairs[i].start == currvid) {
			 System.out.println(count);
			Edge x = pairs[i];
			i++;
			if (!visited[x.end] && x.relevance >= k) {
				System.out.println(pairs[i-1].start + " " + pairs[i-1].end);
				visited[currvid] = true;
				count++;
				recurse(x.end, k);
			}
		}
	}
	/*
	 * public static boolean contains(int[] x, int test) { for (int y : x) { if
	 * (test == y) { return true; } } return false; }
	 */
}

class Edge {
	public int start;
	public int end;
	public int relevance;

	public Edge(int s, int e, int r) {
		start = s;
		end = e;
		relevance = r;
	}
}
