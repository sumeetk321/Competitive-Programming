import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PaintingtheWall {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = Integer.parseInt(br.readLine());
		mainloop: for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[][] wall;
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			wall = new int[n][m];
			boolean ok = true;
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				int layersum = 0;
				for (int l = 0; l < m; l++) {
					int in = Integer.parseInt(st.nextToken());
					wall[j][l] = in;
					layersum += in;
				}
				if (layersum > k) {
					ok = false;
				}
			}
			for (int j = 0; j < m; j++) {
				int colsum = 0;
				for (int l = 0; l < n; l++) {
					colsum+=wall[l][j];
				}
				if(colsum>k){
					ok = false;
				}
			}
			if(!ok){
				out.println("NO");
				continue;
			} else {
				
			}
		}
		br.close();
		out.close();
	}

}
