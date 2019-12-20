import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Harker2011_5_3 {

	public static void main(String[] args) throws IOException {
		/*
		 * 4 7 The Legion of Doom Mr. Lex Luthor Chief Executive Officer
		 * Metropolis Congratulations <2>! <1> would like to offer you the
		 * position of <3> starting Monday. We here at <1>'s <4> office are
		 * looking forward to working with you <2> on your world-domination
		 * plans.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		String[] info = new String[a];
		for (int i = 0; i < a; i++) {
			String in = br.readLine();
			info[i] = in;
		}
		for (int i = 0; i < b; i++) {
			String in = br.readLine();
			if (in.contains("<")) {
				String[] line = in.split("");
				for (int k = 0; k < line.length; k++) {
					if (line[k].equals("<")) {
						line[k] = "";
						line[k + 2] = "";
						int num = Integer.parseInt(line[k + 1]);
						line[k+1] = info[num - 1];
					}
				}
				for (int k = 0; k < line.length; k++) {
					System.out.print(line[k]);
				}
			} else {
				System.out.println(in);
			}
			System.out.print("\n");
		}

	}

}
