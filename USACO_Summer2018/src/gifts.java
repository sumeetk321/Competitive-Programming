import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class gifts {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] giftprices = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			giftprices[i][0] = Integer.parseInt(st.nextToken());
			giftprices[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(giftprices, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0] + o1[1], o2[0] + o2[1]);
			}

		});
		/*
		 * for(int i = 0; i < N; i++){ for(int j = 0; j < 2; j++){
		 * System.out.print(giftprices[i][j]+" "); } System.out.println(); }
		 */
		int sum= 0;
		int out = 0;
		for (int i = 0; i < N; i++) {
			if (sum + giftprices[i][0] + giftprices[i][1] > B) {
				if (sum + (giftprices[i][0] / 2) + giftprices[i][1] < B) {
					sum += giftprices[i][0] / 2 + giftprices[i][1];
					out++;
					break;
				} else {
					break;
				}
			}
			sum += giftprices[i][0] + giftprices[i][1];
			out++;
		}
		System.out.println(out);
	}

}
