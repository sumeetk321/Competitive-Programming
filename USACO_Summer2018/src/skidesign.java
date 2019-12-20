import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class skidesign {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] hillheights = new int[n];
		for (int i = 0; i < n; i++) {
			hillheights[i] = Integer.parseInt(br.readLine());
		}
		int mincost = Integer.MAX_VALUE;
		for (int i = 0; i <= n; i++) {
			int tmpcost = 0;
			for (int x : hillheights) {
				if (x < i) {
					tmpcost += Math.pow(i - x, 2);
				} else if (x > i + 17) {
					tmpcost += Math.pow(x - i - 17, 2);
				}
			}
			mincost = Math.min(mincost, tmpcost);
		}
		System.out.println(mincost);
	}

}
