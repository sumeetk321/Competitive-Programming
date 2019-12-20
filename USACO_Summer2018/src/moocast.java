import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class moocast {
	static ArrayList<CowCast> visited = new ArrayList<CowCast>();
	static CowCast[] cows;
	static int maxsize = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		cows = new CowCast[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cows[i] = new CowCast(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		for(int i = 0; i < N; i++){
			visited.add(cows[i]);
			recurse(i);
			maxsize = Math.max(maxsize, visited.size());
			visited.clear();
		}
		System.out.println(maxsize);
	}

	public static void recurse(int index) {
		//System.out.println("start: "+cows[index].x+", "+cows[index].y);
		loop:for (int j = 0; j < cows.length; j++) {
			for(CowCast x : visited){
				if(x.x==cows[j].x&&x.y==cows[j].y&&x.power==cows[j].power){
					continue loop;
				}
			}
			if (index == j) {
				continue;
			}
			if (cows[index].distancesqr(cows[j]) <= Math.pow(cows[index].power, 2)) {
				visited.add(cows[j]);
				recurse(j);
			}
		}
	}
}

class CowCast {
	public int x;
	public int y;
	public int power;

	public CowCast(int x1, int y1, int p1) {
		x = x1;
		y = y1;
		power = p1;
	}

	public int distancesqr(CowCast c) {
		return (int) (Math.pow(c.x - this.x, 2) + Math.pow(c.y - this.y, 2));
	}
}