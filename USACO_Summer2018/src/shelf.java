import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class shelf {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[] heights = new int[N];
		for(int i = 0; i < N; i++){
			heights[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(heights);
		int numcows = 0;
		int index = N-1;
		int sum = 0;
		while(sum<B){
			sum+=heights[index];
			numcows++;
			index--;
		}
		System.out.println(numcows);
	}

}
