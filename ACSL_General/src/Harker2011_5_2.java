import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Harker2011_5_2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(int i = a; i <= b; i++){
			if(isPrime(i)){
				primes.add(i);
			}
		}
		if(primes.size()==0){
			System.out.println("-1");
		} else {
			for(int x : primes){
				System.out.print(x + " ");
			}
		}
	}
	private static boolean isPrime(long a) {
		int input = (int) a;
		long i = 2;
		long factors = 2;

		while (i <= input) {
			if (input == 1)
				return false;
			if (input == 2)
				return true;
			if (input == 3)
				return true;
			if (input == 5)
				return true;
			if (input == 7)
				return true;

			if (input % i == 0) {
				factors++;
			}

			if (i > (input / 2)) {
				if (factors == 2) {
					return true;
				} else {
					return false;
				}
			}
			i++;

		}
		return false;

	}
}
