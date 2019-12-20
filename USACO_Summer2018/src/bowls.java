import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bowls {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 20; i++) {
			sb.append(st.nextToken());
		}
		StringBuilder sb1 = new StringBuilder(sb);
		int flips = 0;
		for (int i = 1; i < sb.length(); i++) {
			if (sb.charAt(i - 1) == '1') {
				sb.setCharAt(i - 1, '0');
				sb.setCharAt(i, sb.charAt(i) == '0' ? '1' : '0');
				if (i < sb.length() - 1) {
					sb.setCharAt(i + 1, sb.charAt(i + 1) == '0' ? '1' : '0');
				}
				flips++;
			}
		}
		if (!sb.toString().equals("00000000000000000000")) {
			flips = Integer.MAX_VALUE;
		}
		int flips1 = 1;
		sb1.setCharAt(0, sb1.charAt(0) == '0' ? '1' : '0');
		sb1.setCharAt(1, sb1.charAt(0) == '0' ? '1' : '0');
		for (int i = 1; i < sb1.length(); i++) {
			if (sb1.charAt(i - 1) == '1') {
				sb1.setCharAt(i - 1, '0');
				sb1.setCharAt(i, sb1.charAt(i) == '0' ? '1' : '0');
				if (i < sb1.length() - 1) {
					sb1.setCharAt(i + 1, sb1.charAt(i + 1) == '0' ? '1' : '0');
				}
				flips1++;
			}
		}
		if(!sb1.toString().equals("00000000000000000000")){
			flips1 = Integer.MAX_VALUE;
		}
		System.out.println(Math.min(flips, flips1));
	}
}
