import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class KRounding {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		long i = 0;
		do {
			i++;
			if ((n * i) % Math.pow(10, k) == 0) {
				out.println(n * i);
			}
		} while ((n * (i)) % (Math.pow(10, k)) != 0);
		br.close();
		out.close();
	}

}
