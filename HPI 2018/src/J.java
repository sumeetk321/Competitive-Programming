import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] adjmatr = new int[N][N];
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			adjmatr[num1-1][num2-1] = 1;
		}
		System.out.println(Arrays.deepToString(adjmatr));
		br.close();
	}
	
	/*public static int numoftimes(int[][] adjmatr, int startrow, int endrow, int num){
		if(startrow==endrow){
			return num;
		}
		for(int i = 0; i < adjmatr[startrow].length; i++){
			
		}
	}*/

}
