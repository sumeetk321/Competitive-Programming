import java.util.Scanner;

public class Caesar_cipher {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter string:");
		String in = scan.nextLine();
		System.out.println("Enter key:");
		int key1 = Integer.parseInt(scan.nextLine());

		Caesar_cipher cipher = new Caesar_cipher();
		String yee = cipher.encode(in, key1);
		System.out.println("Encoded to: " + yee);
		String yee1 = cipher.decode(yee, in);
		System.out.println("Decoding: " + yee1);
	}

	public String encode(String a, int k) {
		String outputreal = "";
		String alphabet1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphabet2 = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		int key = k;
		char[] output = a.toCharArray();

		for (int i = 0; i < output.length; i++) {
			if (output[i] == ' ') {
				continue;
			}
			if (Character.isUpperCase(output[i])) {
				output[i] = alphabet1.charAt(alphabet1.indexOf(a.charAt(i)) + key);
			} else {
				output[i] = alphabet2.charAt(alphabet2.indexOf(a.charAt(i)) + key);
			}
		}

		for (char x : output) {
			outputreal += x;
		}

		return outputreal;
	}

	public String decode(String a, String b) {
		String[] output = new String[a.length()];
		String outputreal = "";
		String alphabet1 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphabet2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

		for (int i = 1; i < 26; i++) {
			outputreal = "";
			for (int j = 0; j < a.length(); j++) {
				if (a.charAt(j) == ' ') {
					output[j] = " ";
					continue;
				}
				if (Character.isUpperCase(a.charAt(j))) {
					output[j] = Character.toString(alphabet1.charAt(alphabet1.indexOf(a.charAt(j)) - i)).toUpperCase();
				} else {
					output[j] = Character.toString(alphabet2.charAt(alphabet2.indexOf(a.charAt(j)) - i)).toLowerCase();
				}

			}
			for (String x : output) {
				outputreal += x;
			}
			if (outputreal.equals(b)) {
				break;
			}

		}

		return outputreal;
	}

	public String rot13encode(String a) {
		return encode(a, 13);
	}

	public String rot13decode(String a, String b) {
		return decode(a, b);
	}
}
