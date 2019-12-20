import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class relayrace {
	static cowracer[] racers;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		racers = new cowracer[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			ArrayList<Integer> A = new ArrayList<Integer>();
			while (st.hasMoreTokens()) {
				A.add(Integer.parseInt(st.nextToken()));
			}
			racers[i] = new cowracer(L, M, A);
			if(i==0){
				racers[i].endtime = L;
			}
		}
		for(int i = 0; i < N; i++){
			int j = findcow();
			activate(j);
		}
		int maxendtime = 0;
		for(int i = 0; i < N; i++){
			maxendtime = Math.max(maxendtime, racers[i].endtime);
		}
		System.out.println(maxendtime);
	}

	public static void activate(int i) {
		racers[i].used = true;
		for (int j = 0; j < racers[i].M; j++) {
			racers[racers[i].A.get(j) - 1].activated = true;
			racers[racers[i].A.get(j) - 1].endtime = Math.min(racers[racers[i].A.get(j) - 1].endtime,
					racers[i].endtime + racers[racers[i].A.get(j) - 1].L);
		}
	}

	public static int findcow() {
		int min = Integer.MAX_VALUE;
		int mini = 0;
		for (int i = 0; i < N; i++) {
			if (racers[i].activated && !racers[i].used && (racers[i].endtime < min)) {
				min = racers[i].endtime;
				mini = i;
			}
			//System.out.println(racers[i].endtime);
		}
		return mini;
	}
}

class cowracer {
	public int L;
	public int M;
	public ArrayList<Integer> A;
	public boolean used;
	public boolean activated;
	public int endtime;

	public cowracer(int L, int M, ArrayList<Integer> A) {
		this.L = L;
		this.M = M;
		this.A = A;
		used = false;
		activated = false;
		endtime = Integer.MAX_VALUE;
	}
}