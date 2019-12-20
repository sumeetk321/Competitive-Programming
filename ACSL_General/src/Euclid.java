import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Euclid {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(gcd(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine())));
	}

	public static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);

	}
}
