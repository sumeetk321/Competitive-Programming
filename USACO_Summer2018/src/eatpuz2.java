import java.util.Scanner;

public class eatpuz2 {

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int B = sc.nextInt();
		sc.nextLine();
		int[] buckets = new int[B];
		for (int i = 0; i < B; i++) {
			buckets[i] = sc.nextInt();
		}
		int max = 0;
		loop: for (int i = 0; i < (1 << B); i++) {
			int tmp = 0;
			for (int j = 0; j < B; j++) {
				if ((i & (1 << j)) > 0) {
					tmp += buckets[j];
					if (tmp > C) {
						continue loop;
					}
				}
			}
			max = Math.max(max, tmp);
		}
		System.out.println(max);
	}

}
