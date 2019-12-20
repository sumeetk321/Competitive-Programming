import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class msort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] vals = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			vals[i] = Integer.parseInt(st.nextToken());
		}
		merge(vals, 0, N - 1);
	}

	public static void merge(int[] vals, int L, int R) {
		if (L < R) {
			merge(vals, L, (L+R)/2);
			merge(vals, ((L+R)/2) + 1, R);
			int[] tmp = vals.clone();
			int index = L;
			int i1 = L;
			int i2 = ((L+R)/2) + 1;
			while ((i1 <= (L+R)/2) && (i2 <= R)) {
				if (tmp[i1] < tmp[i2]) {
					vals[index] = tmp[i1];
					i1++;
					index++;
				} else if (tmp[i1] >= tmp[i2]) {
					vals[index] = tmp[i2];
					i2++;
					index++;
				}
			}
			int min = Math.min(i1, i2);
			for (int i = 0; i <= (L+R)/2 - min; i++) {
				vals[i + index] = tmp[i + min];
			}
			for (int x : vals) {
				System.out.print(x + " ");
			}
			System.out.println();
		} else {
			return;
		}

	}

}
