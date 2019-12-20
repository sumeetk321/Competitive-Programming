import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class costume {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int pairs = 0;
		int[] cows = new int[N];
		for (int i = 0; i < N; i++) {
			cows[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(cows);
		int last = N-1;
		for (int i = 0; i < N; i++) {
			for(; last>i; last--){
				if(cows[i]+cows[last]<=S){
					pairs+=last-i;
					break;
				}
			}
		}
		System.out.println(pairs);
	}

}
