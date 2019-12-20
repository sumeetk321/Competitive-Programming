import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dance2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			String test = st.nextToken();
			while(test.contains("><")){
				test = test.replaceAll("><", "");
			}
			if(test.length()>0){
				System.out.println("illegal");
			} else {
				System.out.println("legal");
			}
		}
	}

}
