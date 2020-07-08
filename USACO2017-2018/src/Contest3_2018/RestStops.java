package Contest3_2018;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RestStops {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("reststops.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
		int L = 0, N = 0, F = 0, B = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		int[][] stops = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stops[i][0] = Integer.parseInt(st.nextToken());
			stops[i][1] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		int laststop = 0;
		for (int[] x : stops) {
			max += (F - B) * (x[0] - laststop) * x[1];
			laststop = x[0];
		}
		out.println(max);
		out.close();
	}

}
