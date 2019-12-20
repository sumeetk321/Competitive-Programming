import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Challenge {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] in = new String[N];
		int maxLength = 0;
		for (int i = 0; i < N; i++) {
			in[i] = br.readLine();
			maxLength = Math.max(maxLength, in[i].length());
		}
		for (int i = 0; i < N; i++) while (in[i].length() < maxLength) in[i] += "0";
		for (int i = 0; i < N; i++) {
			if (in[i].contains("0") && in[i].substring(0, in[i].indexOf("0")).length() < maxLength) {
				String test = in[i].substring(0, in[i].indexOf("0"));
				for (int j = i + 1; j < N; j++) if (in[j].length() > test.length() && in[j].startsWith(test)) {
					System.out.println("NO");
					System.exit(0);
				}
			}
		}
		for (int i = 0; i < maxLength; i++) {
			ArrayList<Character> order = new ArrayList<Character>();
			for (int j = 0; j < N; j++) {
				char c = in[j].charAt(i);
				if (c == '0') continue;
				if (!order.contains(c)) order.add(c);
				else if (j > 0 && order.indexOf(c) < order.indexOf(in[j - 1].charAt(i))) {
					System.out.println("NO");
					System.exit(0);
				}
			}
		}
		System.out.println("YES");
		br.close();
	}

}
