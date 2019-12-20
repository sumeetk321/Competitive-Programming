import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class holstein {
	static int ans = Integer.MAX_VALUE;
	static int taken = 0;
	static boolean[] takens;
	static String listout = "";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] requiredvit = new int[V];
		for (int i = 0; i < V; i++) {
			requiredvit[i] = Integer.parseInt(st.nextToken());
		}
		int G = Integer.parseInt(br.readLine());
		int[] tmp;
		feed[] feeds = new feed[G];
		takens = new boolean[G];
		for (int i = 0; i < G; i++) {
			st = new StringTokenizer(br.readLine());
			tmp = new int[V];
			for (int j = 0; j < V; j++) {
				tmp[j] = Integer.parseInt(st.nextToken());
			}
			feeds[i] = new feed(tmp);
		}
		solve(0, feeds, requiredvit, new int[V]);
		//System.out.println(Arrays.toString(requiredvit));
		// System.out.println(Arrays.toString(requiredvit));
		System.out.println(ans+" "+listout);
	}

	public static void solve(int index, feed[] feeds, int[] requiredvit, int[] pass) {
		if (index == feeds.length) {
			// System.out.println(Arrays.toString(pass));
			for (int i = 0; i < pass.length; i++) {
				if (pass[i] >= requiredvit[i]) {
					continue;
				} else {
					return;
				}
			}
			if (ans > taken) {
				listout = "";
				//System.out.println(Arrays.toString(pass));
				ans = taken;
				for(int i = 0; i < feeds.length; i++){
					if(takens[i]){
						listout+=""+(i+1)+" ";
					}
				}
			}
			return;
		}
		int[] tmp = pass.clone();
		int i = 0;
		for (int x : feeds[index].vitamnts) {
			pass[i] += feeds[index].vitamnts[i];
			i++;
		}
		taken++;
		takens[index] = true;
		solve(index + 1, feeds, requiredvit, pass);
		takens[index] = false;
		taken--;
		solve(index + 1, feeds, requiredvit, tmp);

	}
}

class feed {
	public int[] vitamnts;

	public feed(int[] amnts) {
		vitamnts = amnts;
	}
}
