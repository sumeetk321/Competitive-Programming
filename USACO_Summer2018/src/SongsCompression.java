import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SongsCompression {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long amtover = 0;
		int[][] files = new int[n][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			files[i][0] = Integer.parseInt(st.nextToken());
			files[i][1] = Integer.parseInt(st.nextToken());
			files[i][2] = files[i][0] - files[i][1];
			amtover += files[i][0];
		}
		int compressionsneeded = 0;
		Arrays.sort(files, new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				return -Integer.compare(arg0[2], arg1[2]);
			}

		});
		//System.out.println(amtover);
		//System.out.println(Arrays.deepToString(files));
		for (int i = 0; i < n; i++) {
			//System.out.println(amtover);
			if (amtover <= m) {
				break;
			}
			amtover -= files[i][2];
			compressionsneeded++;
		}
		if (amtover > m) {
			System.out.println("-1");
		} else {
			System.out.println(compressionsneeded);
		}

	}
}
