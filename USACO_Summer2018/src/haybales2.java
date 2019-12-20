import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class haybales2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		Integer[] numhay = new Integer[N + 2];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numhay[i] = Integer.parseInt(st.nextToken());
		}
		numhay[N] = -1;
		numhay[N + 1] = 1000000001;
		Arrays.sort(numhay);
		for (int i = 0; i < Q; i++) {
			int out = 0;
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int x = Arrays.binarySearch(numhay, a);
			int y = Arrays.binarySearch(numhay, b + 1);
			if (x < 0) {
				x = -x - 1;
			}
			if (y < 0) {
				y = -y - 1;
			}
			out = y - x;
			System.out.println(out);

		}
	}

}
