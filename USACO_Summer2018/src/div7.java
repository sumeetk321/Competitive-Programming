import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class div7 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cows = new int[N + 1];
		long[] pre = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			cows[i] = Integer.parseInt(br.readLine());
			pre[i] = pre[i - 1] + cows[i];
		}
		/*System.out.println(Arrays.toString(cows));
		System.out.println(Arrays.toString(pre));*/
		long max = 0;
		loop: for (int i = N; i > 0; i--) {
			if(i<max){
				break;
			}
			for (int j = 0; j < i; j++) {
				if(i-j<max){
					break;
				}
				if ((pre[i] - pre[j]) % 7 == 0) {
					max = i-j;
					continue loop;
				}
			}
		}
		System.out.println(max);
	}

}
