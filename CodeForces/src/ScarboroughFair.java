import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ScarboroughFair {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		for(int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			String c1 = st.nextToken();
			String c2 = st.nextToken();
			str = operation(str, l-1, r-1, c1, c2);
		}
		out.println(str);
		out.close();
	}
	public static String operation(String in, int l, int r, String c1, String c2){
		String tmp = in.substring(0, l);
		for(int i = l; i <= r; i++){
			if((in.charAt(i)+"").equals(c1)){
				tmp+=c2;
			} else {
				tmp+=in.charAt(i);
			}
		}
		tmp+=in.substring(r+1, in.length());
		return tmp;
	}
}
