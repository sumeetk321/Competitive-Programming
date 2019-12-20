import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class escape {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] weights = new String[N];
		for (int i = 0; i < N; i++) {
			weights[i] = br.readLine();
		}
		containsCarry(weights);
		int largest = 0;
		for (int i = 0; i < (1 << N); i++) {
			String[] weights1 = new String[Integer.bitCount(i)];
			int count = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) {
					weights1[count] = weights[j];
					count++;
				}
			}
			if (!containsCarry(weights1)) {
				largest = Math.max(largest, weights1.length);
			}
		}
		System.out.println(largest);
	}

	public static boolean containsCarry(String[] weights) {
		int longest = 0;
		for (String x : weights) {
			longest = Math.max(longest, x.length());
		}
		for (int i = 0; i < weights.length; i++) {
			while (weights[i].length() < longest) {
				weights[i] = "0" + weights[i];
			}
		}
		// System.out.println(Arrays.toString(weights));
		for (int i = longest - 1; i >= 0; i--) {
			int sum = 0;
			for (String x : weights) {
				sum += Character.getNumericValue(x.charAt(i));
				if (sum >= 10) {
					return true;
				}
			}
		}
		return false;
	}
}
