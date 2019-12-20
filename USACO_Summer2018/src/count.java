import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class count {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int count = 0;
		int i = 1;
		while (true) {
			if (Integer.toString(i).contains(Integer.toString(L))) {
				i++;
				continue;
			}
			count++;
			if (count == N) {
				System.out.println(i);
				System.exit(0);
			}
			i++;
		}
	}

}
