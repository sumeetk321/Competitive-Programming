package compumatics_set_2;

import java.math.BigInteger;

public class Prob5 {

	public static void main(String[] args) {

		BigInteger fact1 = BigInteger.ONE;
		for(int i = 40; i > 0; i--){
			fact1 = fact1.multiply(BigInteger.valueOf(i));
		}
		BigInteger fact2 = BigInteger.ONE;
		for(int i = 20; i > 0; i--){
			fact2 = fact2.multiply(BigInteger.valueOf(i));
		}
		
		System.out.println(fact1.divide(fact2.pow(2)));
	}

}
