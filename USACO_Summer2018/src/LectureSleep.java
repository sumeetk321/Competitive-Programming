import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LectureSleep {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long maxchange = 0;
		long currsum = 0;
		int[] theorems = new int[n];
		int[] sleep = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			theorems[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			sleep[i] = Integer.parseInt(st.nextToken());
			if (sleep[i] == 1) {
				currsum += theorems[i];
			}
		}
		//System.out.println(currsum);
		for (int i = 0; i <= n - k; i++) {
			int[] tmp = new int[n];
			for (int j = 0; j < n; j++) {
				tmp[j] = sleep[j];
			}
			long tmpsum = 0;
			for (int j = i; j < i + k; j++) {
				tmp[j] = 1;
				if (sleep[j] == 0) {
					tmpsum += theorems[j];
				}
				//System.out.println(tmpsum);
			}
			maxchange = Math.max(maxchange, tmpsum);
		}
		System.out.println(currsum + maxchange);
	}

}
