import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BarkToUnlock {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
		String pswd = br.readLine();
		String c1 = pswd.charAt(0) + "";
		String c2 = pswd.charAt(1) + "";
		int n = Integer.parseInt(br.readLine());
		String[] vocab = new String[n];
		for (int i = 0; i < n; i++) {
			vocab[i] = br.readLine();
		}
		boolean yes = false;
		loop: for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(vocab[i].equals(pswd)){
					yes = true;
					break loop;
				}
				if (vocab[i].endsWith(c1) && vocab[j].startsWith(c2)) {
					yes = true;
					break loop;
				}
			}
		}
		if (yes) {
			pw.println("YES");
		} else {
			pw.print("NO");
		}
		br.close();
		pw.close();
	}

}
