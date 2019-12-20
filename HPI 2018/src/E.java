import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] distances = new int[N-1];
		for(int i = 0; i < N-1; i++){
			distances[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			int num1 = Math.min(tmp1, tmp2)-1;
			int num2 = Math.max(tmp1, tmp2)-2;
			int sum = 0;
			for(int j = num1; j <= num2; j++){
				sum+=distances[j];
			}
			System.out.println(sum);
		}
		br.close();
	}

}
