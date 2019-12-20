import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class phrase {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		String[] phrases = new String[M];
		for (int i = 0; i < M; i++) {
			phrases[i] = br.readLine();
		}
		int count = 0;
		for(int i = 0; i < N; i++){
			String test = br.readLine();
			for(String x : phrases){
				if(x.startsWith(test)){
					count++;
					break;
				}
			}
		}
		System.out.println(count);
	}

}
