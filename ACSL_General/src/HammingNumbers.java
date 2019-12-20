import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HammingNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<BigInteger> darn = new ArrayList<BigInteger>();
		mainloop: for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				for (int k = 0; k < 1000; k++) {
					if(darn.contains((BigInteger.valueOf((2^i * 3^j * 5^k))))){
						continue;
					}
					System.out.println((BigInteger.valueOf((2^i * 3^j * 5^k))));
					darn.add((BigInteger.valueOf((2^i * 3^j * 5^k))));


				}
			}
		}
		Set<BigInteger> darn1 = new HashSet<BigInteger>();
		darn1.addAll(darn);
		darn.clear();
		darn.addAll(darn1);
		darn1.clear();
		BigInteger[] darn2 = new BigInteger[darn.size()];
		for (int i = 0; i < darn.size(); i++) {
			darn2[i] = darn.get(i);
		}
		System.out.println("PRINTING:");
		Arrays.sort(darn2);
		for (int i = 0; i < 20; i++) {
			System.out.println(darn2[i]);
		}
		System.out.println("1691: " + darn2[1690]);
		System.out.println(darn.size());

		System.out.println("millionth: " + darn2[999999]);
	}

}
