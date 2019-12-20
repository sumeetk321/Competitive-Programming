import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class FlagOfBerland {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[][] grid = new String[N][M];
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				grid[i][j] = row.charAt(j) + "";
			}
		}
		if (N % 3 == 0 || M % 3 == 0) {
			boolean out = false;
			if (N % 3 == 0) {
				HashSet<Character> checkallexists = new HashSet<Character>();
				int step = N / 3;
				for (int i = 0; i < N; i += step) {
					HashSet<Character> test = new HashSet<Character>();
					for (int j = i; j < i + step; j++) {
						for (int k = 0; k < M; k++) {
							test.add(grid[j][k].charAt(0));
						}
					}
					// System.out.println(test);
					if (test.size() > 1) {
						out |= false;
						break;
					}
					checkallexists.addAll(test);
				}
				if (checkallexists.size() < 3) {
					out |= false;
				} else {
					out |= true;
				}
			}
			if (M % 3 == 0) {
				int step = M / 3;
				HashSet<Character> checkallexists = new HashSet<Character>();
				for (int i = 0; i < M; i += step) {
					HashSet<Character> test = new HashSet<Character>();
					for (int j = i; j < i + step; j++) {
						for (int k = 0; k < N; k++) {
							test.add(grid[k][j].charAt(0));
						}
					}
					// System.out.println(test);
					if (test.size() > 1) {
						out |= false;
						break;
					}
					checkallexists.addAll(test);
				}

				if (checkallexists.size() < 3) {
					out |= false;
				} else {
					out |= true;
				}
			}
			if (out) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		} else {
			System.out.println("NO");
		}

	}

}