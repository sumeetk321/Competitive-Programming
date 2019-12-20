import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MaximumSubsequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		out.print(maxMod(n, arr, m));
		br.close();
		out.close();
	}
	public static int maxMod(int size, int[] arr, int m){
		if(size==1){
			return arr[0]%m;
		}
		return(Math.max(maxMod(size-1, arr, m), (maxMod(size-1, arr, m)+arr[size-1])%m));
	}
}
