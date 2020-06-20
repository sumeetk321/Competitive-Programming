//Author: Sumeet Kulkarni
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Contest1_ACEIntermediate_SumeetKulkarni {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("1int_testdata.txt"));
		String[] in;
		String num;
		int P;
		String out;
		for (int i = 0; i < 5; i++) {
			in = br.readLine().split(" ");
			num = in[0];
			P = Integer.parseInt(in[1]);
			out = "";
			int charP = Character.getNumericValue(num.charAt(num.length() - P));
			for (int j = 0; j < num.length() - P; j++) {
				String tmp = (charP + Character.getNumericValue(num.charAt(j))) + "";
				out += tmp.charAt(tmp.length() - 1);
			}
			out += charP + "";
			for (int j = num.length() - P + 1; j < num.length(); j++) {
				String tmp = (Math.abs(Character.getNumericValue(num.charAt(j)) - charP)) + "";
				out += tmp.charAt(tmp.length() - 1);
			}
			System.out.println(out);
		}
	}

}
