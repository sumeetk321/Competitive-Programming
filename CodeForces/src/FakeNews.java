import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FakeNews {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		String test = br.readLine();
		if (test.contains("h")) {
			test = test.substring(test.indexOf("h") + 1, test.length());
			if (test.contains("e")) {
				test = test.substring(test.indexOf("e") + 1, test.length());
				if (test.contains("i")) {
					test = test.substring(test.indexOf("i") + 1, test.length());
					if (test.contains("d")) {
						test = test.substring(test.indexOf("d") + 1, test.length());
						if (test.contains("i")) {
							out.println("YES");
						} else {
							out.println("NO");
						}
					} else {
						out.print("NO");
					}
				} else {
					out.println("NO");
				}
			} else {
				out.println("NO");
			}
		} else {
			out.println("NO");
		}
		br.close();
		out.close();
	}

}
