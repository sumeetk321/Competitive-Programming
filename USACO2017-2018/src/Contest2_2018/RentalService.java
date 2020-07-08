package Contest2_2018;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class RentalService {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("rental.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[] cows = new int[N];
		int[][] buymilk = new int[M][2];
		Integer[] renters = new Integer[R];
		for (int i = 0; i < N; i++) {
			cows[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			buymilk[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		}
		for (int i = 0; i < R; i++) {
			renters[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(cows);
		Arrays.sort(buymilk, new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				return Integer.compare(arg1[1], arg0[1]);
			}
		});
		Arrays.sort(renters, Collections.reverseOrder());
		// up to R renters
		long maxmilk = 0;
		for (int i = 0; i <= R; i++) {
			long tmpmilk = 0;
			long milkgals = 0;
			for (int j = 0; j < i; j++) {
				tmpmilk += renters[j];
			}
			for (int j = N - 1; j >= i; j--) {
				milkgals+=cows[j];
			}
			int milkindex = 0;
			while(milkgals>0){
				if(buymilk[milkindex][0]>=milkgals){
					tmpmilk+=milkgals*buymilk[milkindex][1];
					milkgals = 0;
				} else {
					tmpmilk+=buymilk[milkindex][0]*buymilk[milkindex][1];
					milkgals-=buymilk[milkindex][0];
					milkindex++;
				}
			}
			maxmilk = Math.max(tmpmilk, maxmilk);
		}
		out.println(maxmilk);
		out.close();
	}

}
