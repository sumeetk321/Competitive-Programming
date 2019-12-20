import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class btwr2 {

	public static void main(String[] args) {

		solve();

	}

	public static void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		int[][] bales = new int[N][2];
		for (int i = 0; i < N; i++) {
			bales[i][0] = sc.nextInt();
			bales[i][1] = sc.nextInt();
			sc.nextLine();
		}
		Arrays.sort(bales, new Comparator<int[]>() {

			@Override
			public int compare(int[] arg0, int[] arg1) {
				return -Integer.compare(arg0[0] * arg0[1], arg1[0] * arg1[1]);
			}

		});
		//System.out.println(Arrays.deepToString(bales));
		int maxheight = 0;
		for (int i = 0; i < (1 << N); i++) {
			int prevwid = Integer.MAX_VALUE;
			int prevbred = Integer.MAX_VALUE;
			int tmp = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) {
					if(bales[j][0]<prevwid&&bales[j][1]<prevbred){
						tmp++;
						prevwid = bales[j][0];
						prevbred = bales[j][1];
					}
				}
			}
			maxheight = Math.max(maxheight, tmp);
		}
		System.out.println(maxheight);
	}

}
