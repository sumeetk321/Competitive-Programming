import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class setsub {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int[] nums = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= M; i++) {
			solve(M, i, nums, new StringBuilder(), 0);
		}
	}

	public static void solve(int M, int N, int[] nums, StringBuilder out, int index) {
		if (out.length() == N) {
			System.out.println(out);
			return;
		}
		for (int i = index; i < M; i++) {
			if (out.toString().contains(nums[i] + "")) {
				continue;
			}
			out.append(nums[i] + "");
			solve(M, N, nums, out, i + 1);
			out.deleteCharAt(out.length() - 1);
		}
	}
}
