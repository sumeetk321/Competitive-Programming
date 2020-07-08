package USOpen_2018;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class LemonadeLine {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new FileReader("lemonade.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
		int N = Integer.parseInt(br.readLine());
		Integer[] cowwait = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			cowwait[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cowwait, Collections.reverseOrder());
		int output = 1;
		for (int i = 0; i < N; i++) {
			if (cowwait[i] < i) {
				output = i;
				break;
			}
			if (i == N - 1) {
				output = N;
			}
		}
		out.println(output);
		br.close();
		out.close();
	}

}
