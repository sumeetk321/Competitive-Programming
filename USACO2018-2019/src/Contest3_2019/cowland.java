package Contest3_2019;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class cowland {

	public static void main(String[] args) throws IOException {
		//BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br =new BufferedReader(new FileReader("cowland.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowland.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int[] att =new int[N];
		ArrayDeque<Integer> rides;
		ArrayDeque<Integer> xor;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			att[i] = Integer.parseInt(st.nextToken());
		}
		int[][] edges = new int[N-1][2];
		boolean[] visited;
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken())==1) {
				int ind = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				att[ind-1] = val;
			} else {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				visited = new boolean[N-1];
				rides = new ArrayDeque<Integer>();
				xor = new ArrayDeque<Integer>();
				rides.add(s);
				xor.add(att[s-1]);
				while(!rides.isEmpty()) {
					int ride = rides.removeFirst();
					int a = xor.removeFirst();
					if(ride==e) {
						out.println(a);
						break;
					}
					for(int j = 0; j < N-1; j++) {
						if(visited[j]) {
							continue;
						}
						if(edges[j][0]==ride) {
							rides.add(edges[j][1]);
							xor.add(a^att[edges[j][1]-1]);
							visited[j] = true;
						} else if(edges[j][1]==ride) {
							rides.add(edges[j][0]);
							xor.add(a^att[edges[j][0]-1]);
							visited[j] = true;
						}
					}
				}
			}
		}
		out.close();
		br.close();
	}

}
