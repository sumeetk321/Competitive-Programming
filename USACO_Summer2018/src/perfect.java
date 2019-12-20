import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class perfect {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int middle = (int) (N/2);
		int[][] cows = new int[N][N];
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				cows[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] medians = new int[N];
		for(int i = 0; i < N; i++){
			Arrays.sort(cows[i]);
			medians[i] = cows[i][middle];
		}
		Arrays.sort(medians);
		System.out.println(medians[middle]);
	}

}
