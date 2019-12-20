import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CowCode {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		long N = Long.parseLong(st.nextToken());
		for (int i = 0; i < 10; i++) {
			out.println(str);
			str = createCode(str);
		}
		out.close();
		br.close();
	}

	public static String createCode(String str) {
		str += (str.charAt(str.length() - 1) + str.substring(0, str.length() - 1));
		return str;
	}
}
