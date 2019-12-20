import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BishuGirlfriend {
	static boolean visited[];
	static int minval = Integer.MAX_VALUE;
	static int minind = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] roads = new int[2*(N-1)][2];
		visited = new boolean[N];
		StringTokenizer st;
		for(int i = 0; i < 2*(N-1); i+=2){
			st = new StringTokenizer(br.readLine());
			roads[i][0] = Integer.parseInt(st.nextToken());
			roads[i][1] = Integer.parseInt(st.nextToken());
			roads[i+1][0] = roads[i][1];
			roads[i+1][1] = roads[i][0];
		}
		int Q = Integer.parseInt(br.readLine());
		int[] cands = new int[Q];
		for(int i = 0; i < Q; i++){
			cands[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(cands);
		dfs(1, roads, cands, 0);
		System.out.println(minind);
	}
	
	public static void dfs(int curr, int[][] roads, int[] cands, int distance){
		if(visited[curr-1]){
			return;
		}
		visited[curr-1] = true;
		if(Arrays.binarySearch(cands, curr)>=0){
			if(distance<=minval){
				if(distance==minval){
					minind = Math.min(curr, minind);
				} else {
					minind = curr;
				}
				minval = distance;
			}
		}
		for(int i = 0; i < roads.length; i++){
			if(roads[i][0]==curr){
				dfs(roads[i][1], roads, cands, distance+1);
			}
		}
	}

}
