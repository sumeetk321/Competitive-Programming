import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class stacking {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] instructions = new int[K][2];
		int[] pre = new int[N];
		int[] pre2 = new int[N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			instructions[i][0] = Integer.parseInt(st.nextToken());
			instructions[i][1] = Integer.parseInt(st.nextToken());
			pre[instructions[i][0] - 1]++;
			if (!(instructions[i][1] >= N)) {
				pre[instructions[i][1]]--;
			}
			// subtract one because when summing for the second array, you are
			// summing all of the previous ones even when it's not part of the
			// intervals.
		}
		pre2[0] = pre[0];
		for (int i = 1; i < N; i++) {
			pre2[i] = pre2[i - 1];
			pre2[i] += pre[i];
		}
		Arrays.sort(pre2);
		/*System.out.println(Arrays.toString(pre));
		System.out.println(Arrays.toString(pre2));*/
		System.out.println(pre2[(N + 1) / 2 - 1]);
	}

}
