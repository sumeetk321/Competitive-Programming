package compumatics_set_3;

public class Prob3 {

	public static void main(String[] args) {
		long sum = 0;
		for (int i = 0; i <= 28123; i++) {
			for (int j = 0; j < i; j++) {
				if (divisorsum(j) == 1 && divisorsum(i - j) == 1) {
					break;
				} else if (j == i - 1) {
					sum += i;
					System.out.println(i);
				}
			}
		}
		System.out.println(sum);
	}

	public static int divisorsum(int i) {
		int sum = 0;
		for (int d = 1; d < i; d++) {
			if (i % d == 0)
				sum += d;
		}
		if (sum > i) {
			return 1;
		} else if (sum == i) {
			return 0;
		} else {
			return -1;
		}
	}

}
