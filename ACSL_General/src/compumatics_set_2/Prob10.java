package compumatics_set_2;

import java.math.BigInteger;

public class Prob10 {
	
	public static void main(String[] args) {
		BigInteger x = BigInteger.valueOf(100);
		for (int i = 99; i >= 1; i--) {
			x = x.multiply(BigInteger.valueOf(i));
		}
		String fact = x.toString();
		System.out.println(fact);
		long sum = 0;
		for (int i = 0; i < fact.length(); i++) {
			sum += Character.getNumericValue(fact.charAt(i));
		}
		System.out.println(sum);
	}

}
