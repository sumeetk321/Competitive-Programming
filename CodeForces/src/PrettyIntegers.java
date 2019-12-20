import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PrettyIntegers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] l1 = new int[Integer.parseInt(st.nextToken())];
		int[] l2 = new int[Integer.parseInt(st.nextToken())];
		st = new StringTokenizer(br.readLine());
		int i = 0;
		while (st.hasMoreTokens()) {
			l1[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		st = new StringTokenizer(br.readLine());
		i = 0;
		while (st.hasMoreTokens()) {
			l2[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		Arrays.sort(l1);
		Arrays.sort(l2);
		int test = Integer.MAX_VALUE;
		loop: for(int j = 0; j < l1.length; j++){
			for(int k = 0; k < l2.length; k++){
				if(l1[j]==l2[k]){
					test = l1[j];
					break loop;
				}
			}
		}
		if (test<=(10*Math.min(l1[0], l2[0]))+Math.max(l1[0], l2[0])) {
			out.println(test);
		} else {
			out.println(Math.min(l1[0], l2[0]) + "" + Math.max(l1[0], l2[0]));
		}
		br.close();
		out.close();
	}

}
