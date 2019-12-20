import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UnreachableNodes {
	static boolean[] visited;
	static int visited1 = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		int[][] edges = new int[M][2];
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
		}
		int head = Integer.parseInt(br.readLine());
		dfs(head, edges);
		System.out.println(N-visited1);
	}
	
	public static void dfs(int node, int[][] edges){
		if(visited[node-1]){
			return;
		}
		visited[node-1] = true;
		visited1++;
		for(int i = 0; i < edges.length; i++){
			if(edges[i][0]==node){
				dfs(edges[i][1], edges);
			}
		}
	}
}
