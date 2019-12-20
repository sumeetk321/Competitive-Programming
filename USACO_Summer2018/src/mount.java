import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class mount {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] H = new int[N];
		int[] change = new int[N-1];
		for (int i = 0; i < N; i++) {
			H[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 0; i < N-1; i++){
			change[i] = H[i+1]-H[i];
		}
		int maxlength = 0;
		for(int i = 0; i < N-1; i++){
			boolean rising = true;
			int testlength = 0;
			for(int j = i; j < N-1; j++){
				if(change[j]>=0){
					if(rising||change[j]==0){
						testlength++;
					} else {
						break;
					}
				} else {
					rising = false;
					testlength++;
				}
			}
			maxlength = Math.max(maxlength, testlength);
		}
		System.out.println(maxlength+1);
		//System.out.println(Arrays.toString(H));
		//System.out.println(Arrays.toString(change));
	}

}
