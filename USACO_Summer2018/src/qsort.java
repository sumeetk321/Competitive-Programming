import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class qsort {
	static int[] vals;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		vals = new int[N];
		for (int i = 0; i < N; i++) {
			vals[i] = Integer.parseInt(st.nextToken());
		}
		quicksort(0, N - 1);
	}

	public static int partition(int l, int r) {
		// System.out.println(l + ", " + r);
		// System.out.println(Arrays.toString(vals));
		int tmpl = l;
		int tmpr = r - 1;
		while (true) {
			while (tmpl < r && (vals[tmpl] < vals[r])) {
				tmpl++;
			}
			while (tmpr > 0 && (vals[tmpr] > vals[r])) {
				tmpr--;
			}
			if (tmpl >= tmpr) {
				break;
			}
			int tmp = vals[tmpl];
			vals[tmpl] = vals[tmpr];
			vals[tmpr] = tmp;
			tmpl++;
			tmpr--;
		}
		int tmp = vals[tmpl];
		vals[tmpl] = vals[r];
		vals[r] = tmp;
		return tmpl;
	}

	public static void quicksort(int l, int r) {
		if (l >= r) {
			return;
		}
		int part = partition(l, r);
		for (int i = 0; i < vals.length - 1; i++) {
			System.out.print(vals[i] + " ");
		}
		System.out.print(vals[vals.length - 1]);
		System.out.println();
		quicksort(l, part - 1);
		quicksort(part + 1, r);
	}
}
