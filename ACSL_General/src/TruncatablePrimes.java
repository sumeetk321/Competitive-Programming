
public class TruncatablePrimes {

	public static void main(String[] args) {
		int largestl = 0;
		int largestr = 0;
		loop: for (int i = 1000000; i >= 2; i--) {
			String x = String.valueOf(i);
			// right
			if (x.contains("0")) {
				continue;
			} else {
				if (isPrime(i)) {

					for (int j = 0; j < x.length(); j++) {
						String tmp = "";
						for (int k = 0; k <= j; k++) {
							tmp += x.charAt(k);
						}
						if (isPrime(Integer.parseInt(tmp))) {
							if (j == x.length() - 1) {
								if (i > largestr) {
									largestr = i;
								}
							} else {
								continue;
							}
						} else {
							break;
						}
					}

					for (int j = x.length() - 1; j > -1; j--) {
						String tmp = "";
						for (int k = j; k < x.length(); k++) {
							tmp += x.charAt(k);
						}
						if (isPrime(Integer.parseInt(tmp))) {
							if (j == 0) {
								System.out.println(i);
								if (i > largestl) {
									largestl = i;
								}
							} else {
								continue;
							}
						} else {
							break;
						}
					}
				}

			}
		}

		System.out.println(largestr + " r");
		System.out.println(largestl + " l");
	}

	private static boolean isPrime(int num) {
		if (num == 1)
			return false;
		if (num % 2 == 0)
			return false;
		for (int i = 3; i * i <= num; i += 2)
			if (num % i == 0)
				return false;
		return true;
	}

}
