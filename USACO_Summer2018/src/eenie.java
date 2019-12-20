import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class eenie {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] elimseq = new int[L];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < L; i++) {
			elimseq[i] = Integer.parseInt(st.nextToken());
		}
		int currentheifer = 0;
		int heifersleft = N;
		int round = 0;
		int[] heifers = new int[N];
		for (int i = 0; i < N; i++) {
			heifers[i] = i + 1;
		}
		int roundindex = 0;
		int jump = 0;

		while (heifersleft > 1) {
			round = elimseq[roundindex];
			for (int i = 0; i < round + jump; i++) {
				if (heifers[(currentheifer + i) % N] == 0) {
					jump++;
				} else {
					if (i == (round + jump - 1)) {
						heifersleft--;
						heifers[(i + currentheifer) % N] = 0;
						roundindex = (roundindex + 1) % L;
						currentheifer = (i + currentheifer) % N;
					}
				}
			}
			jump = 0;
		}
		for(int x : heifers){
			if(x!=0){
				System.out.println(x);
				break;
			}
		}
	}
}