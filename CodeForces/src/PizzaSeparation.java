import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PizzaSeparation {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		int length = Integer.parseInt(br.readLine());
		String[] bin = createBin(length);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] pizza = new int[length];
		for (int i = 0; i < length; i++) {
			pizza[i] = Integer.parseInt(st.nextToken());
		}
		int smallestdif = 361;
		for (String x : bin) {
			int tmpsum = 0;
			for (int i = 0; i < x.length(); i++) {
				tmpsum += (x.charAt(i) == '0' ? 0 : pizza[i]);
			}
			smallestdif = Math.min(smallestdif, Math.abs(360 - 2 * tmpsum));
		}
		out.println(smallestdif);
		out.close();
		br.close();
	}

	public static String[] createBin(int length) {
		String[] out = new String[(int) Math.pow(2, length)];
		for (int i = 0; i < Math.pow(2, length); i++) {
			String bin = Integer.toBinaryString(i);
			if (bin.contains("101") && bin.length() != 3) {
				for (int j = 0; j < length; j++) {
					out[i] += "0";
				}
				continue;
			}
			if (bin.length() < length) {
				int len = bin.length();
				for (int j = 0; j < length - len; j++) {
					bin = "0" + bin;
				}
			}
			out[i] = bin;
		}
		return out;
	}

}
