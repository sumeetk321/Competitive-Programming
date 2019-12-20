import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class elect {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] votes = new int[N][3];
		int[][] secondround = new int[K][3];
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			votes[i][0] = Integer.parseInt(st.nextToken());
			votes[i][1] = Integer.parseInt(st.nextToken());
			votes[i][2] = (i+1);
		}
		Arrays.sort(votes, new Comparator<int[]>(){

			@Override
			public int compare(int[] arg0, int[] arg1) {
				return Integer.compare(arg0[0], arg1[0]);
			}
			
		});
		int k = 0;
		for(int i = N-1; i > -1; i--){
			secondround[k] = votes[i];
			k++;
			if(k>=K){
				break;
			}
		}
		Arrays.sort(secondround, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
			
		});
		System.out.println(secondround[K-1][2]);
	}

}
