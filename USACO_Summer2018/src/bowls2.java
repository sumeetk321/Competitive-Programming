import java.util.Scanner;

public class bowls2 {

	public static void main(String[] args) {

		solve();

	}

	public static void solve() {
		Scanner sc = new Scanner(System.in);
		int[] bowls = new int[20];
		for (int i = 0; i < 20; i++) {
			bowls[i] = sc.nextInt();
		}
		int minflips = Integer.MAX_VALUE;
		loop: for (int i = 0; i < (1 << 20); i++) {
			int[] tmp = bowls.clone();
			int flips = 0;
			for (int j = 0; j < 20; j++) {
				if ((i & (1 << j)) > 0) {
					flips++;
					tmp[j] = (tmp[j] == 1 ? 0 : 1);
					if (j != 0) {
						tmp[j - 1] = (tmp[j - 1] == 1 ? 0 : 1);
					}
					if (j != 19) {
						tmp[j + 1] = (tmp[j + 1] == 1 ? 0 : 1);
					}
				}
			}
			for (int j = 0; j < 20; j++) {
				if (tmp[j] == 1) {
					continue loop;
				}
			}
			minflips = Math.min(minflips, flips);
		}
		System.out.println(minflips);
	}

}
