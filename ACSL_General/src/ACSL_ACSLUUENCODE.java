import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_ACSLUUENCODE {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			String in = scan.nextLine();
			char[] chars = in.toCharArray();
			int[] asciidecimal = new int[chars.length];
			for (int j = 0; j < chars.length; j++) {
				asciidecimal[j] = (int) chars[j];
				System.out.println(asciidecimal[j]);
			}
			System.out.println(Integer.toString(115, 2));
			ArrayList<String> binaries = new ArrayList<String>();
			String cumulative = "";
			for (int x : asciidecimal) {
				String out = Integer.toBinaryString(x);
				for (int j = 0; j < 8 - out.length(); j++) {
					out = "0" + out;
				}
				cumulative += out;
			}

			boolean notsolved = true;
			while (notsolved) {
				if (cumulative.length() % 6 == 0) {
					notsolved = false;
				} else {
					cumulative = cumulative + "0";
				}
			}
			System.out.println(cumulative);
			System.out.println(cumulative.length());
			int index = 0;
			int[] nums = new int[cumulative.length() / 6];
			for (int j = 0; j < cumulative.length() / 6; j++) {
				nums[j] = Integer.parseInt(Integer.toString(Integer.parseInt(cumulative.substring(index, index + 6))));
				index += 6;
			}
			int[] newnums = new int[nums.length];
			for (int j = 0; j < nums.length; j++) {
				newnums[j] = Integer.parseInt(Integer.toString((nums[j])), 2) + 32;
				System.out.println(newnums[j]);
			}

			for (int j = 0; j < newnums.length; j++) {
				if (newnums[j] == 32) {
					System.out.print("");
				} else if (newnums[j] == 95) {
					System.out.print("_");
				} else if (newnums[j] == 126) {
					System.out.print("~");
				}else {
					System.out.print(Character.toChars(newnums[j]));
				}
			}
			if(in.length()>3) System.out.print("P");

			System.out.println();

		}

	}

}
