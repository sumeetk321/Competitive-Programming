import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class snakes {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum+=arr[i];
		}
		System.out.println(dp(N, K));
	}
	
	public static int dp(int m, int k) {
		if(m==0) {
			return 0;
		}
		if(k==0) {
			int max = 0;
			for(int i = 0; i < arr.length; i++) {
				max = Math.max(max, arr[i]);
			}
			return max;
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < m; i++) {
			int max = 0;
			for(int j = i+1; j < arr.length; j++) {
				max = Math.max(max, arr[j]);
			}
			
			min=Math.min(min, dp(i,k-1)+max*(arr.length-i));
			//System.out.println(min);
		}
		return min;
	}

}
