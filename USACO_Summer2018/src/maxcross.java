import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class maxcross {
	// 1 2 5 9 10
	// 3 4 6 7 8
	// iterate for each element, find smallest element in arr such that
	// arr[i]+arr[j]>=K
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[] broken = new int[B];
		for (int i = 0; i < B; i++) {
			broken[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(broken);
		//System.out.println(Arrays.toString(broken));
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < N - K + 1; i++) {
			int j = i + K;
			int i1 = Arrays.binarySearch(broken, i);
			if (i1 < 0) {
				i1 = -i1 - 1;
			}
			int i2 = Arrays.binarySearch(broken, j);
			if (i2 < 0) {
				i2 = -i2 - 1;
			}
			/*
			 * System.out.println(i+", "+j); System.out.println(i1+", "+i2);
			 * System.out.println("end");
			 */

			min = Math.min(min, i2 - i1);

		}
		System.out.println(min);
	}

}
