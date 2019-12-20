import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class diningb {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cards = new int[N];
		int[] ones = new int[N+1];
		int[] twos = new int[N+1];
		for (int i = 1; i <= N; i++) {
			cards[i-1] = Integer.parseInt(br.readLine());
			ones[i] = ones[i-1];
			if(cards[i-1]==1){
				ones[i]++;
			}
			twos[i] = twos[i-1];
			if(cards[i-1]==2){
				twos[i]++;
			}
		}
		int changes = Integer.MAX_VALUE;
		for (int i = 0; i <= N; i++) {
			int tmp = 0;
			tmp+=twos[i];
			tmp+=ones[N]-ones[i];
			changes= Math.min(changes, tmp);
		}
		System.out.println(changes);
	}

}
