import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int ans = 0;
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		for (int j = 0; j < n; j++) {
			if (j != 0 && arr[j - 1] == arr[j]) continue;
			int count = 0;
			boolean done = false;
			for (int i = 0; i + j < n; i++) {
				if (Math.abs(arr[j] - arr[i + j]) <= k) count++;
				else {
					ans = Math.max(ans, count);
					done = true;
					break;
				}
			}
			if (!done) ans = Math.max(ans, count);
		}
		System.out.println(ans);
		br.close();
	}

}
