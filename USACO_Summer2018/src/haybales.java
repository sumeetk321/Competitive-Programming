import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class haybales {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int avg = 0;
		int[] haybales = new int[N];
		int out = 0;
		for (int i = 0; i < N; i++) {
			haybales[i] = Integer.parseInt(br.readLine());
			avg+=haybales[i];
		}
		avg/=N;
		Arrays.sort(haybales);
		for(int i = N-1; i > -1; i--){
			if(haybales[i]<avg){
				break;
			}
			out+=haybales[i]-avg;
		}
		System.out.println(out);
	}

}
