import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PirateBrothers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] coins = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
			sum+=coins[i];
		}
		Arrays.sort(coins);
		int partialsum = 0;
		for(int i = coins.length-1; i > -1; i--){
			partialsum+=coins[i];
			sum-=coins[i];
			if(partialsum>sum){
				System.out.println(coins.length-i);
				break;
			}
		}
	}

}
