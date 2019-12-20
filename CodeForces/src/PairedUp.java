import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class PairedUp {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> cows = new ArrayList<Integer>();
		StringTokenizer st;
		for(int i= 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			int cownum = Integer.parseInt(st.nextToken());
			int milk = Integer.parseInt(st.nextToken());
			for(int j = 0; j < cownum; j++){
				cows.add(milk);
			}
		}
		Collections.sort(cows);
		int max = 0;
		while(cows.size()>0){
			max = Math.max(max, cows.get(0)+cows.get(cows.size()-1));
			cows.remove(0);
			cows.remove(cows.size()-1);
		}
		out.print(max);
		br.close();
		out.close();
	}

}
