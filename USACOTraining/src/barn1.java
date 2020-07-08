
/*
ID: sumeetk1
LANG: JAVA
TASK: barn1
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class barn1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] stalls = new int[c];
		int[] gaps = new int[c - 1];
		Arrays.fill(stalls, 1);
		for (int i = 0; i < c; i++) {
			stalls[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(stalls);
		for (int i = 0; i < c - 1; i++) {
			gaps[i] = stalls[i + 1] - stalls[i] - 1;
		}
		Arrays.sort(gaps);
		int length = c;
		for (int i = 0; i <= c - m - 1; i++) {
			length += gaps[i];
		}
		out.println(length);
		out.close();
		br.close();
	}

}
