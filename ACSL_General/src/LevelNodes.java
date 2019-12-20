import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class LevelNodes {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine())-1;
		boolean[] visited = new boolean[N+1];
		StringTokenizer st;
		int[][] edges = new int[N][2];
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());
		int cnt = 0;
		ArrayDeque<Integer> currnode = new ArrayDeque<Integer>();
		ArrayDeque<Integer> depth = new ArrayDeque<Integer>();
		currnode.add(1);
		depth.add(1);
		while(!currnode.isEmpty()){
			int tmpnode = currnode.removeFirst();
			int tmpdepth= depth.removeFirst();
			if(visited[tmpnode]){
				continue;
			}
			if(tmpdepth==x){
				//System.out.println(tmpnode+" depth "+x);
				cnt++;
				continue;
			}
			visited[tmpnode] = true;
			for(int i = 0; i < N; i++){
				if(edges[i][0]==tmpnode){
					currnode.add(edges[i][1]);
					depth.add(tmpdepth+1);
				}
				if(edges[i][1]==tmpnode){
					currnode.add(edges[i][0]);
					depth.add(tmpdepth+1);
				}
			}
		}
		System.out.println(cnt);
	}

}
