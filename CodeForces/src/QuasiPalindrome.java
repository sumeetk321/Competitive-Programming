import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class QuasiPalindrome {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
		boolean qp = false;
		String num = br.readLine();
		if (new StringBuilder(num).reverse().toString().equals(num)) {
			pw.println("YES");
			qp = true;
		} else {
			int num1 = Integer.parseInt(num);
			String pref = "";
			while (num1 % 10 == 0) {
				num1 /= 10;
				pref += "0";
			}
			if (new StringBuilder(pref + "" + num).reverse().toString().equals(pref + "" + num)) {
				pw.println("YES");
				qp = true;
			}
		}
		if (!qp)
			pw.println("NO");
		br.close();
		pw.close();
	}

}
