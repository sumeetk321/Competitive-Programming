import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class XorMST {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		int n = Integer.parseInt(br.readLine());
		long[] x1 = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			x1[i] = Long.parseLong(st.nextToken());
		}
		long[][] adjmatr = new long[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				adjmatr[i][j] = x1[i] ^ x1[j];
			}
		}
		long sum = 0;
		ArrayList<Long> visited = new ArrayList<Long>();
		visited.add(0l);
		while (visited.size() < n) {
			long minindex = 0, min = Long.MAX_VALUE;
			for (long x : visited) {
				for (long i = 0; i < adjmatr[(int) x].length; i++) {
					if (i == x) {
						continue;
					}
					long y = adjmatr[(int) x][(int) i];
					if (y < min && (!visited.contains(i))) {
						min = y;
						minindex = i;
					}
				}
			}
			visited.add(minindex);
			sum += min;
		}
		out.println(sum);
		br.close();
		out.close();
	}

}
