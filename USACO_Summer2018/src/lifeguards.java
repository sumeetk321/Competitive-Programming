import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class lifeguards {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] uniquetimes = new int[N];
		TreeSet<Integer> tracknums = new TreeSet<Integer>();
		LifeguardPoint[] lifeguards = new LifeguardPoint[2 * N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			lifeguards[2 * i] = new LifeguardPoint(Integer.parseInt(st.nextToken()), i);
			lifeguards[2 * i + 1] = new LifeguardPoint(Integer.parseInt(st.nextToken()), i);
		}
		Arrays.sort(lifeguards, new Comparator<LifeguardPoint>() {

			@Override
			public int compare(LifeguardPoint o1, LifeguardPoint o2) {
				return Integer.compare(o1.val, o2.val);
			}

		});
		int totalunique = 0;
		int prevval = 0;
		for (LifeguardPoint x : lifeguards) {
			if (tracknums.size() == 1) {
				uniquetimes[tracknums.first()] += x.val - prevval;
			}
			if (tracknums.size() >= 1) {
				totalunique += x.val - prevval;
			}
			prevval = x.val;
			if (tracknums.contains(x.tracknum)) {
				tracknums.remove(x.tracknum);
			} else {
				tracknums.add(x.tracknum);
			}
		}
		int uniquemin = Integer.MAX_VALUE;
		for(int x : uniquetimes){
			uniquemin = Math.min(uniquemin, x);
		}
		System.out.println(totalunique-uniquemin);
	}

}

class LifeguardPoint {
	int val;
	int tracknum;

	public LifeguardPoint(int v, int t) {
		val = v;
		tracknum = t;
	}
}
