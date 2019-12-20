import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class makelake {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] stomp = new int[N][3];
		int[][] lake = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				lake[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				stomp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int[] inst : stomp) {
			int max = 0;
			int x = inst[0] - 1;
			int y = inst[1] - 1;
			max = updateMax(lake, x, y);
			for (int i = inst[2]; i > 0; i--) {
				loop: for (int j = x; j < x + 3; j++) {
					for (int k = y; k < y + 3; k++) {
						if (lake[j][k] == max) {
							lake[j][k]--;
						}
					}
				}
				max = updateMax(lake, x, y);
			}
			/*for(int i = 0; i < lake.length; i++){
				for(int j = 0; j < lake[0].length; j++){
					System.out.print(lake[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();*/
		}
		int aggsum = 0;
		for(int i = 0; i < R; i++){
			for(int j = 0; j < C; j++){
				if(E-lake[i][j]>0){
					aggsum+=E-lake[i][j];
				}
			}
		}
		System.out.println(aggsum);
		System.out.println(aggsum*72*72);
	}
	
	public static int updateMax(int[][] lake, int x, int y){
		int max = 0;
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				max = Math.max(max, lake[i][j]);
			}
		}
		return max;
	}

}
