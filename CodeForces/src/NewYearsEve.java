import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NewYearsEve {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		long[] candies = new long[(int) n];
		for (long i = 0; i < n; i++) {
			candies[(int) i] = i + 1;
		}
		out.println(maxXorSum(candies, candies.length - 1, k, 0));
		out.close();
	}

	public static long maxXorSum(long[] candies, long depth, long k, long sum) {
		if (k == 0) {
			return sum;
		}
		if (depth == 0) {
			return Math.max(sum ^ candies[(int) depth], sum);
		}
		return Math.max(maxXorSum(candies, depth - 1, k, sum),
				maxXorSum(candies, depth - 1, k - 1, sum ^ candies[(int) depth]));

	}

}
