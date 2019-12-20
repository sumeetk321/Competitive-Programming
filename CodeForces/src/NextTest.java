import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NextTest {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] indices = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int i = 0;
		while (st.hasMoreTokens()) {
			indices[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		Arrays.sort(indices);
		if (indices[0] > 1) {
			out.println("1");
		} else if (indices.length == 1) {
			out.println(indices[0] + 1);
		} else {
			for (i = 0; i < indices.length - 1; i++) {
				if (indices[i] + 1 < indices[i + 1]) {
					out.println(indices[i] + 1);
					break;
				} else if (i == indices.length - 2) {
					out.println(indices[indices.length - 1] + 1);
					break;
				}
			}
		}
		br.close();
		out.close();
	}

}
