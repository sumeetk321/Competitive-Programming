import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WattoMechanism {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[] memory = new String[n];
		String[] query = new String[m];
		String[] regex;
		int c = 0;
		for (int i = 0; i < n; i++) {
			memory[i] = br.readLine();
			c += memory[i].length() * n;
		}
		regex = new String[c];
		for (int i = 0; i < m; i++) {
			query[i] = br.readLine();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < memory[i].length(); j++) {
				StringBuilder sb = new StringBuilder(memory[i]);
				regex[memory[i].length() * i + j] = sb.replace(j, j + 1, "[^" + sb.charAt(j) + "]").toString();
			}
		}
		
		loop: for (String x : query) {
			boolean matched = false;
			for (String y : regex) {
				System.out.println(x+", "+y);
					Pattern pat = Pattern.compile(y);
					Matcher mat = pat.matcher(x);
					if (mat.matches()) {
						pw.println("YES");
						matched = true;
						continue loop;
					}
				
			}
			if(!matched){
				pw.println("NO");
			}
		}
		br.close();
		pw.close();
	}

}
