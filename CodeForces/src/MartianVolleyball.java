import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MartianVolleyball {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int high = (int) Math.max(x, y);
			int low = (int) Math.min(x, y);
			if(high>k){
				if(high>low+1){
					out.println(k-high);
				} else {
					out.println((low+2)-high);
				}
			} else {
				if(k>low+1){
					out.println(k-high);
				} else {
					out.println((low+2)-high);
				}
			}
		}
		br.close();
		out.close();
	}

}
