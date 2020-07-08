import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pairup_Silver {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new FileReader("pairup.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));

		/*
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); PrintWriter out = new PrintWriter(new
		 * BufferedOutputStream(System.out));
		 */
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		cowset[] cows = new cowset[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cows[i] = new cowset(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(cows);
		int max = 0;
		int l = 0;
		int r = N - 1;
		while (l <= r) {
			int a = cows[l].y;
			int b = cows[r].y;
			cows[l].x--;
			cows[r].x--;
			if (cows[l].x <= 0) {
				l++;
			}
			if (cows[r].x <= 0) {
				r--;
			}
			max = Math.max(max, a + b);
		}
		out.println(max);
		out.close();
		br.close();
	}

}

class cowset implements Comparable<cowset> {
	public int x;
	public int y;

	public cowset(int x1, int y1) {
		x = x1;
		y = y1;
	}

	@Override
	public int compareTo(cowset arg0) {
		return Integer.compare(this.y, arg0.y);
	}
}