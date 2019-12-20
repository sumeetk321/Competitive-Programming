import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class calfflac {
	// static String alphabet =
	// "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static String input = "";
	static int tmpcount = 0;
	static int max = 0;
	static int l1 = 0;
	static int r1 = 0;
	static String output = "";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String test;
		input = "";
		while (!(test = br.readLine()).equals("")) {
			input += test;
			input+="\n";
		}
		for (int i = 0; i < input.length(); i++) {
			isPali(i, i);
			if (alphalen(input.substring(l1, r1 + 1)) > max) {
				max = alphalen(input.substring(l1, r1 + 1));
				output = input.substring(l1, r1 + 1);
			}
			isPali(i, i + 1);
			if (alphalen(input.substring(l1, r1 + 1)) > max) {
				max = alphalen(input.substring(l1, r1 + 1));
				output = input.substring(l1, r1 + 1);
			}
		}
		System.out.println(max);
		System.out.println(fix(output));
	}

	public static void isPali(int l, int r) {
		if (l < 0 || r >= input.length()) {
			return;
		}
		if (Character.toUpperCase(input.charAt(l)) != Character.toUpperCase(input.charAt(r))) {
			return;
		}
		for (int i = 0; i <= 1000; i++) {
			boolean cont = false;
			if (r > input.length() - 1 || l < 0) {
				break;
			}
			if (!alphabet(input.charAt(l))) {
				l--;
				cont = true;
			}
			if (!alphabet(input.charAt(r))) {
				r++;
				cont = true;
			}
			if (cont) {
				continue;
			}
			if (Character.toUpperCase(input.charAt(l)) != Character.toUpperCase(input.charAt(r))) {
				break;
			}
			//System.out.println(l + ", " + r + ", " + tmpcount);
			l--;
			r++;
		}
		l1 = l + 1;
		r1 = r - 1;
		return;
	}

	public static boolean alphabet(char c) {
		return ('A' <= Character.toUpperCase(c) && Character.toUpperCase(c) <= 'Z');
	}

	public static int alphalen(String str) {
		int out = 0;
		for (int i = 0; i < str.length(); i++) {
			if (alphabet(str.charAt(i))) {
				out++;
			}
		}
		return out;
	}

	public static String fix(String str) {
		str = str.trim();
		StringBuilder str1 = new StringBuilder(str);
		while (str1.length() > 0 && !alphabet(str1.charAt(0))) {
			str1.deleteCharAt(0);
		}
		while (str1.length() > 0 && !alphabet(str1.charAt(str1.length() - 1))) {
			str1.deleteCharAt(str1.length() - 1);
		}
		return str1.toString();
	}
}
