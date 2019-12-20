import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class F {

	public static void main(String[] args) throws Exception{
		Scanner br = new Scanner(System.in);
		BigInteger ans = BigInteger.ZERO;
//		BigInteger p = BigInteger.valueOf(br.nextLong());
//		BigInteger q = BigInteger.valueOf(br.nextLong());
//		BigInteger r = BigInteger.valueOf(br.nextLong());
		long p = br.nextLong();
		long q = br.nextLong();
		long r = br.nextLong();
//		for (BigInteger i = BigInteger.ONE; i.compareTo(r) <= 0; i = i.add(BigInteger.ONE)) {
//			if (!i.gcd(p).equals(BigInteger.ONE)) continue;
//			if (!i.gcd(q).equals(BigInteger.ONE)) continue;
//			ans = ans.add(BigInteger.ONE);
//		}
		//System.out.println(ans);
		if (p % q == 0 || q % p == 0) System.out.println(r-r/p);
		else System.out.println(r-r/p-r/q+r/(p * q));
		br.close();
	}

}
