import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class citystate {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int pairs = 0;
		int[][] map = new int[26 * 26][26 * 26];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken().substring(0, 2);
			String s2 = st.nextToken();
			map[base26(s1)][base26(s2)]++;
		}
		int dup = 0;
		for (int i = 0; i < 26 * 26; i++) {
			for (int j = i + 1; j < 26 * 26; j++) {
				dup += map[i][j] * map[j][i];
			}
		}
		System.out.println(dup);
	}

	public static int base26(String s) {
		return (26 * (s.charAt(0) - 65)) + (s.charAt(1) - 65);
	}
}
