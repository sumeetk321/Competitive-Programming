import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class eatpuz {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[] calories = new int[B];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++) {
			calories[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(check(calories, C, B));
	}

	public static int check(int[] arr, int C, int B){
		int best = 0;
		mainloop:for(int i = 0; i < Math.pow(2, B); i++){
			int sum = 0;
			String bin = Integer.toBinaryString(i);
			int len = bin.length();
			if(len<B){
				for(int j = 0; j < B - len; j++){
					bin = "0"+bin;
				}
			}
			for(int j = 0; j < bin.length(); j++){
				if(bin.charAt(j)=='0'){
					continue;
				} else {
					sum+=arr[j];
					if(sum>C){
						continue mainloop;
					}
				}
			}
			if(C-sum<C-best){
				best = sum;
			}
		}
		return best;
	}

}
