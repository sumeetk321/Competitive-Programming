package compumatics_set_2;

import java.math.BigInteger;

public class Prob6 {

	public static void main(String[] args) {
		BigInteger x = BigInteger.valueOf(2);
		x = x.pow(1000);
		String x1 = x.toString();
		System.out.println(x1);
		long value = 0;
		for(long i = 0; i < x1.length(); i++){
			value+=Character.getNumericValue(x1.charAt((int) i));
		}
		System.out.println(value);
	}

}
