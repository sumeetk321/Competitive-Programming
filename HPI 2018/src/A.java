import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		for (int i = 0; i < 3; i++) {
			int in = Integer.parseInt(st.nextToken());
			ans = Math.max(ans, in);
		}
		System.out.println(ans);
		br.close();
	}

}
