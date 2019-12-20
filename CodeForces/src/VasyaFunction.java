import java.io.*;
import java.util.*;
import java.math.*;

public class VasyaFunction {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger a = BigInteger.valueOf(Long.parseLong(st.nextToken()));
		BigInteger b = BigInteger.valueOf(Long.parseLong(st.nextToken()));
		BigInteger sum = BigInteger.ZERO;
		while (!b.equals(BigInteger.ZERO)) {
			b = b.subtract(a.gcd(b));
			sum = sum.add(BigInteger.ONE);
		}

		out.println(sum.toString());
		out.close();
		br.close();
	}
}
