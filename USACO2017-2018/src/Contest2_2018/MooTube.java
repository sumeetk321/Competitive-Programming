package Contest2_2018;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MooTube {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int[][] adjmatr = new int[N][N];
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int i1 = Integer.parseInt(st.nextToken()) - 1;
			int i2 = Integer.parseInt(st.nextToken()) - 1;
			adjmatr[i1][i2] = Integer.parseInt(st.nextToken());
			adjmatr[i2][i1] = adjmatr[i1][i2];

		}
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (adjmatr[i][j] != 0) {
					int tmp = adjmatr[i][j];
					for (int k = j + 1; k < N; k++) {
						if (adjmatr[j][k] != 0) {
							adjmatr[i][k] = Math.min(tmp, adjmatr[j][k]);
							adjmatr[k][i] = Math.min(tmp, adjmatr[j][k]);
						}
					}
				}
			}
		}
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int minrel = Integer.parseInt(st.nextToken());
			int vid = Integer.parseInt(st.nextToken()) - 1;
			int answer = 0;
			for (int j = 0; j < N; j++) {
				if (adjmatr[vid][j] >= minrel)
					answer++;
			}
			out.println(answer);
		}
		out.close();
	}
}