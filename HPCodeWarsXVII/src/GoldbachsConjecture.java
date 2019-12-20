import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoldbachsConjecture {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num;
		while (!(num = br.readLine()).equals("0")) {
			int val = Integer.parseInt(num);
			int[] primes = new int[2];
			int mindiff = Integer.MAX_VALUE;
			for (int i = 2; i <= val / 2; i++) {
				int num2 = val - i;
				if(isPrime(i)&&isPrime(num2)){
					if(Math.abs(num2-i)<mindiff){
						primes[0] = Math.min(num2, i);
						primes[1] = Math.max(num2, i);
					}
				}
			}
			System.out.println(primes[0]+" + "+primes[1]+" = "+val);
		}
	}

	public static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
