import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class lemonade_silver {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("lemonade.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
		int N = Integer.parseInt(br.readLine());
		int[] w = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			w[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(w);
		int count = 0;
		for (int i = N - 1; i >= 0; i--) {
			if(w[i]>=N-1-i){
				count++;
			}
		}
		pw.println(count);
		pw.close();
		br.close();
	}

}
