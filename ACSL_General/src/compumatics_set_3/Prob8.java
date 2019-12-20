package compumatics_set_3;

import java.math.BigInteger;

public class Prob8 {

	public static void main(String[] args) {
		BigInteger sum = BigInteger.valueOf(0);
		for (int i = 0; i < 500; i++) {
			sum = sum.add(BigInteger.valueOf((long) Math.pow((i+1)*2+1, 2)));
			sum = sum.add(BigInteger.valueOf((long) Math.pow((i+1)*2+1, 2)).subtract(BigInteger.valueOf(6 * (i + 1))));
		}
		for (int i = 0; i < 500; i++) {
			sum = sum.add(BigInteger.valueOf((long) Math.pow((i+1) * 2, 2)).add(BigInteger.ONE));
			sum = sum.add(BigInteger.valueOf((long) Math.pow((i+1) * 2, 2)).add(BigInteger.valueOf(2).multiply(BigInteger.valueOf(i+1))).add(BigInteger.ONE));
		}
		System.out.println(sum.add(BigInteger.ONE));

	}

}
