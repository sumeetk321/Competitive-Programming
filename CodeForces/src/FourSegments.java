import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FourSegments {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		long size = Long.parseLong(br.readLine());
		long[] arr = new long[(int) size];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(long i = 0; i < size; i++){
			arr[(int) i] = Long.parseLong(st.nextToken());
		}
		long max = 0;
		String output = "0 0 0";
		for(long i = 0; i <= size; i++){
			for(long j = i; j <= size; j++){
				for(long k = j; k <= size; k++){
					long test = sum(0, i, arr)-sum(i, j, arr)+sum(j, k, arr)-sum(k, size, arr);
					if(test>max){
						max = test;
						output = i+" "+j+" "+k;
					}
				}
			}
		}
		out.println(output);
		out.close();
		br.close();
	}
	public static long sum(long l, long r, long[] arr){
		long sum = 0;
		for(long i = l; i < r; i++){
			sum+=arr[(int) i];
		}
		return sum;
	}
	
}
