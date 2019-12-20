import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class goodgrs {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] pasture = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				pasture[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int maxsum = 0;
		int out1 = 0;
		int out2 = 0;
		for (int i = 0; i < R - 2; i++) {
			int tmpsum = 0;
			for (int j = 0; j < C - 2; j++) {
				tmpsum = (pasture[i][j] + pasture[i][j + 1] + pasture[i][j + 2])
						+ (pasture[i + 1][j] + pasture[i + 1][j + 1] + pasture[i + 1][j + 2])
						+ (pasture[i + 2][j] + pasture[i + 2][j + 1] + pasture[i + 2][j + 2]);
				if(tmpsum>maxsum){
					maxsum = tmpsum;
					out1 = i+1;
					out2 = j+1;
				}
			}
		}
		System.out.println(maxsum);
		System.out.println(out1+" "+out2);
	}

}
