package Contest2_2019_Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class planting {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("planting.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] paths = new int[N - 1][2];
		int[] frequency = new int[N];
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			paths[i][0] = Integer.parseInt(st.nextToken());
			paths[i][1] = Integer.parseInt(st.nextToken());
			frequency[paths[i][0] - 1]++;
			frequency[paths[i][1] - 1]++;
		}
		int largest = 0;
		for (int i = 0; i < N; i++) {
			largest = Math.max(largest, frequency[i]);
		}
		out.println(largest + 1);
		out.close();
		br.close();
	}

}
