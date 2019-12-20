import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kayaking {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] w = new int[n*2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int i = 0;
		while (st.hasMoreTokens()) {
			w[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		Arrays.sort(w);
		w[w.length-1] = -1;
		w[w.length-2] = -1;
		for(int j = 0; j < w.length-1; j++){
			if(w[j]==w[j+1]){
				w[j] = -1;
				w[j+1] = -1;
			}
		}
		
		int sum = 0;
		for(int j = 0; j < w.length; j++){
			if(w[j]==-1){
				continue;
			} else {
				for(int k = j+1; k < w.length; k++){
					if(w[k] == -1){
						continue;
					} else {
						sum += w[k] - w[j];
						w[k] = -1;
						w[j] = -1;
						break;
					}
				}
			}
		}
		out.println(sum);
		br.close();
		out.close();
	}

}
