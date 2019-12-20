import java.io.*;
import java.util.*;
public class LieOrTruth{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    long n = Long.parseLong(st.nextToken());
	    long l = Long.parseLong(st.nextToken())-1;
	    long r = Long.parseLong(st.nextToken())-1;
	    long[] a = new long[(int)n];
	    long[] b = new long[(int)n];
	    st = new StringTokenizer(br.readLine());
	    for(long i = 0; i < n; i++){
	        a[(int)i] = Long.parseLong(st.nextToken());
	    }
	    st = new StringTokenizer(br.readLine());
	    for(long i = 0; i < n; i++){
	        b[(int)i] = Long.parseLong(st.nextToken());
	    }
	    long[] check1 = new long[(int)n];
	    long[] check2 = new long[(int)n];
	    
	    for(long i = l; i <= r; i++){
	        check1[(int) i] = a[(int)i];
	        check2[(int)i] = b[(int)i];
	    }
	    Arrays.sort(check1);
	    Arrays.sort(check2);
	    out.println(!Arrays.equals(check1, check2)?"LIE":"TRUTH");
	    out.close();
	    br.close();
	}
}
