import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class GreatestTreasure {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		int[][] vals = new int[N][2];
		for(int i = 0; i < N; i++){
			StringTokenizer st =new StringTokenizer(br.readLine());
			vals[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			max = Math.max(max, vals[i][1]);
		}
		Arrays.sort(vals, new Comparator<int[]>(){

			@Override
			public int compare(int[] arg0, int[] arg1) {
				return Integer.compare(arg0[0], arg1[0]);
			}
			
		});
		for(int i = 0; i < N; i++){
			if(vals[i][1]==max){
				System.out.println(i+1);
			}
		}
		
	}

}
