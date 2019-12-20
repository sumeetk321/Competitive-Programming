import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class TopDownFibonacci {
	static ArrayList<Long> fibonacci = new ArrayList<Long>(Arrays.asList((long) 0, (long) 1, (long) 1));

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(fibonacci(Long.parseLong(br.readLine())));
	}

	public static long fibonacci(long n) {

		if (n < fibonacci.size()) {
			return fibonacci.get((int) n);
		}
		fibonacci.add((long) fibonacci(n - 1) + (long) fibonacci(n - 2));
		return fibonacci.get(fibonacci.size() - 1);
	}
}
