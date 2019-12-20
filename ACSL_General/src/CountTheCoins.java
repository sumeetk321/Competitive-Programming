
public class CountTheCoins {

	public static void main(String[] args) {
		long start = System.nanoTime();
		int cents = 10;
		int ways = 0;
		int temp = 0;

		for (int i = 0; i <= cents / 25; i++) {
			for (int j = 0; j <= cents / 10; j++) {
				for (int k = 0; k <= cents / 5; k++) {
					for (int l = 0; l <= cents; l++) {
						temp = (i * 25) + (j * 10) + (k * 5) + l;
						if (temp == cents) {
							System.out.println(i+" quarters, " + j + " dimes, " + k + " nickels, and " + l + " pennies.");
							ways++;
						}
					}
				}
			}
		}

		System.out.println(ways);
		long end = System.nanoTime();
		System.out.println("Runtime: "+((double) (end - start)/1000000000)+" seconds");
	}

}
