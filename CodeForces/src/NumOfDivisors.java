import java.io.*;
import java.util.*;

public class NumOfDivisors {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		long divisors = Long.parseLong(br.readLine());
		if (isPrime(divisors)||divisors==1) {
			out.println((long)Math.pow(2, divisors-1));
		} else {
			long count = 2;
			while (numofdivisors(count) != divisors) {
				count+=2;
			}
			out.println(count);
		}
		out.close();
		br.close();
	}

	public static long numofdivisors(long n) {
		if (n <= 1)
			return 1;
		long sqrt = (long) Math.sqrt(n);
		long remainingNumber = n;
		long result = 1;
		for (long i = 2; i <= sqrt; i++) {
			long tmp = 0;
			while (remainingNumber % i == 0) {
				tmp++;
				remainingNumber /= i;
			}
			result *= (tmp + 1);
		}
		if (remainingNumber > 1) {
			result *= 2;
		}
		return result;
	}

	public static boolean isPrime(long num) {
		if (num < 2)
			return false;
		if (num == 2)
			return true;
		if (num % 2 == 0)
			return false;
		for (long i = 3; i * i <= num; i += 2)
			if (num % i == 0)
				return false;
		return true;
	}
}
