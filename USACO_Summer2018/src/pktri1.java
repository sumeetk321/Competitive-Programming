import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pktri1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int prevcurrent = S - 1;
		for (int i = 0; i < N; i++) {
			int currentnum = (prevcurrent + i + 1);
			prevcurrent = currentnum;
			while (currentnum > 9) {
				currentnum -= 9;
			}
			int currentadd = i + 1;
			for (int j = 0; j < i; j++) {
				System.out.print("  ");
			}
			for (int j = i; j < N - 1; j++) {
				System.out.print(currentnum + " ");
				currentnum += currentadd;
				while (currentnum > 9) {
					currentnum -= 9;
				}
				currentadd++;
			}
			System.out.print(currentnum);
			System.out.println();
		}
	}

}
