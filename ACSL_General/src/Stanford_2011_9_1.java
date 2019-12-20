import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Stanford_2011_9_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String num = br.readLine();
		ArrayList<String> graycode = new ArrayList<String>(Arrays.asList("0", "1"));

		for (int i = 1; i < n; i++) {
			ArrayList<String> tmp = new ArrayList<String>();

			for (int j = graycode.size() - 1; j > -1; j--) {
				tmp.add("1" + graycode.get(j));
				graycode.set(j, "0" + graycode.get(j));
			}
			for (int j = 0; j < tmp.size(); j++) {
				graycode.add(tmp.get(j));
			}
		}
		String out = (Integer.toBinaryString(graycode.indexOf(num)));
		if (out.length() < num.length()) {
			for (int i = 0; i < num.length() - out.length(); i++) {
				out = "0" + out;
			}
		}

		System.out.println(out);

	}

}
