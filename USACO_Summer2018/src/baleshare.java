import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class baleshare {
	static int ans = Integer.MAX_VALUE;
	static int b1 = 0, b2 = 0, b3 = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] bales = new int[N];
		int[] divisions = new int[N];
		for (int i = 0; i < N; i++) {
			bales[i] = (Integer.parseInt(br.readLine()));
		}
		recurse(0, N, bales, divisions);
		System.out.println(ans);
	}

	public static void recurse(int curr, int N, int[] bales, int[] divisions) {
		/*
		 * if(divisions[0]==2&&divisions[1]==1&&divisions[2]==3&&divisions[3]==1
		 * &&divisions[4]==2&&divisions[5]==1&&divisions[6]==3&&divisions[7]==2)
		 * { System.out.println("in here"); }
		 */
		// System.out.println(Arrays.toString(tmps));
		// System.out.println(ans);

		if (curr == N) {
			if (b1 >= b2 && b1 >= b3) {
				if (ans > b1) {
					ans = b1;
				}
			}
			return;
		}
		if (Math.max(b1, Math.max(b2, b3)) > ans) {
			// System.out.println("yeet: "+Math.max(b0], Math.max(b1], b2])));
			return;
		}

		/*if (b1<b2||b1<b3) {
			return;
		}*/

		divisions[curr] = 1;
		b1 += bales[curr];
		recurse(curr + 1, N, bales, divisions);
		b1 -= bales[curr];
		b2 += bales[curr];
		divisions[curr] = 2;
		recurse(curr + 1, N, bales, divisions);
		b2 -= bales[curr];
		b3 += bales[curr];
		divisions[curr] = 3;
		recurse(curr + 1, N, bales, divisions);
		b3 -= bales[curr];
	}
}
