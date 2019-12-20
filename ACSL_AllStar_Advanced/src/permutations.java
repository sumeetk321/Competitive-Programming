import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class permutations {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			String in = br.readLine();
			if (in.length() == 1) {
				System.out.println("1");
			} else {
				ArrayList<String> perms = recurse(in);
				Collections.sort(perms);
				System.out.println(perms.indexOf(in) + 1);
			}
		}
	}

	public static ArrayList<String> recurse(String str) {
		ArrayList<String> out = new ArrayList<String>();
		if (str.length() == 2) {
			out.add(str.charAt(0) + "" + str.charAt(1));
			out.add(str.charAt(1) + "" + str.charAt(0));
		}
		for (int i = 0; i < str.length(); i++) {
			String next = "";
			for (int j = 0; j < str.length(); j++) {
				if (i != j) {
					next += str.charAt(j);
				}
			}
			for (String x : recurse(next)) {
				if (!out.contains(str.charAt(i) + x)) {
					out.add(str.charAt(i) + x);
				}
			}
		}
		return out;
	}
}
