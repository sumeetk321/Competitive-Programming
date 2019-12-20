package compumatics_set_1;

public class Prob10 {

	public static void main(String[] args) {
		long sum = 7;

		for (long i = 1; i <= 2000000; i += 2) {
			if (i % 5 == 0)
				continue;
			if (isPrime(i)) {
				sum += i;
				System.out.println(sum);
			}

		}

		System.out.println(sum);
	}

	static long input;

	private static boolean isPrime(long a) {
		input = a;
		long i = 2;
		long factors = 2;

		if (input == 1)
			return false;
		if (input == 2)
			return true;

		while (i <= input) {

			if (input % i == 0) {
				factors++;
			}

			if (i > (input / 2)) {
				if (factors == 2) {
					return true;
				} else {
					return false;
				}
			}
			i++;

		}
		return false;

	}

}
