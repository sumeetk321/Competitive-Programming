import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class haybale {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] haybales = new int[N];
		int min = Integer.MAX_VALUE;
		int max = 0;
		for(int i = 0; i < N; i++){
			haybales[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(haybales);
		for(int i = 0; i < Q; i++){
			st = new StringTokenizer(br.readLine());
			int h1 = Integer.parseInt(st.nextToken());
			int h2 = Integer.parseInt(st.nextToken());
			int ind1 = Arrays.binarySearch(haybales, h1);
			int ind2 = Arrays.binarySearch(haybales, h2);
			if(ind1<0){
				ind1 = -ind1-1;
			}
			if(ind2<0){
				ind2 = -ind2-2;
			}
			if(ind1>=N||ind2<0){
				pw.println(0);
			} else {
				if(ind2>=N){
					ind2 = N-1;
				}
				pw.println(ind2-ind1+1);
			}
		}
		pw.close();
		br.close();
	}

}
