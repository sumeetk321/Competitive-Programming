import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class diamond {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] diamonds = new int[N];
		for (int i = 0; i < N; i++) {
			diamonds[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(diamonds);
		int[] num = new int[N];
		int lowbound = 0;
		int highbound = 0;
		while (highbound < N) {
			if (diamonds[highbound] - diamonds[lowbound] <= K) {
				num[lowbound] = Math.max(num[lowbound], highbound - lowbound + 1);
				highbound++;
				continue;
			}
			lowbound++;
		}
		for (int i = lowbound + 1; i < N; i++) {
			num[i] = N - i;
		}
		int[] blue = new int[N];
		blue[N - 1] = num[N - 1];
		int rollingmax = 0;
		for (int i = N - 2; i > -1; i--) {
			rollingmax = Math.max(blue[i + 1], num[i]);
			blue[i] = rollingmax;
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int test = num[i];
			ans = Math.max(ans, (test + i < N ? test + blue[test + i] : test));
			System.out.println(ans);
		}
		System.out.println(Arrays.toString(diamonds));
		// System.out.println(Arrays.toString(far));
		System.out.println(Arrays.toString(num));
		System.out.println(Arrays.toString(blue));
		System.out.println(ans);

	}

}
