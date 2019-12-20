import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class setall {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int[] nums = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++){
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int N = Integer.parseInt(br.readLine());
		solve(M, N, nums, new StringBuilder());
	}
	public static void solve(int M, int N, int[] nums, StringBuilder out){
		if(out.length()==N){
			System.out.println(out);
			return;
		}
		for(int i = 0; i < M; i++){
			out.append(nums[i]+"");
			solve(M, N, nums, out);
			out.deleteCharAt(out.length()-1);
		}
	}
}
