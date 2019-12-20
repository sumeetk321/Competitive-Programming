import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class paint {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		endpoint[] endpoints = new endpoint[2 * N];
		int[] pre = new int[2 * N];
		int curr = 0;
		for (int i = 0; i < 2 * N; i += 2) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int change = Integer.parseInt(st.nextToken());
			switch (st.nextToken()) {
			case "L":
				endpoints[i] = new endpoint(curr - change, true);
				endpoints[i + 1] = new endpoint(curr, false);
				curr -= change;
				break;
			case "R":
				endpoints[i] = new endpoint(curr, true);
				endpoints[i + 1] = new endpoint(curr + change, false);
				curr += change;
				break;
			}
		}
		Arrays.sort(endpoints, new Comparator<endpoint>() {

			@Override
			public int compare(endpoint o1, endpoint o2) {
				return Integer.compare(o1.val, o2.val);
			}

		});
		/*
		 * for (int i = 0; i < 2 * N; i++) { System.out.println(endpoints[i].val
		 * + ", " + endpoints[i].isStart); } System.out.println();
		 */
		for (int i = 0; i < 2 * N; i++) {
			if (i > 0) {
				pre[i] = pre[i - 1];
			}
			pre[i] += (endpoints[i].isStart ? 1 : -1);
			// System.out.println(pre[i]);
		}
		int out = 0;
		for (int i = 0; i < 2 * N; i++) {
			if (pre[i] >= 2 && i < 2 * N - 1) {
				out += endpoints[i + 1].val - endpoints[i].val;
			}
		}
		System.out.println(out);
	}

}

class endpoint {
	public int val;
	boolean isStart = false;

	public endpoint(int val1, boolean s) {
		val = val1;
		isStart = s;
	}
}
