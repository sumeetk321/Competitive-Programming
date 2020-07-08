import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class fruitfeast_gold {

	public static void main(String[] args) throws IOException {

		
		  BufferedReader br = new BufferedReader(new FileReader("feast.in"));
		  PrintWriter out = new PrintWriter(new BufferedWriter(new
		  FileWriter("feast.out")));
		 

		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));*/

		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		if (T % A == 0 || T % B == 0) {
			out.println(T);
			out.close();
			System.exit(0);
		}
		ArrayDeque<Integer> fullness = new ArrayDeque<Integer>();
		ArrayDeque<Boolean> usedWater = new ArrayDeque<Boolean>();
		fullness.add(0);
		usedWater.add(false);
		int max = 0;
		while (!fullness.isEmpty()) {
			int len = fullness.size();
			for (int i = 0; i < len; i++) {
				int currf = fullness.removeFirst();
				boolean used = usedWater.removeFirst();
				max = Math.max(currf, max);
				boolean done = false;
				if (currf + A > T && !used && !done) {
					fullness.add((int) currf / 2);
					usedWater.add(true);
					done = true;
				} else if (currf + A <= T) {
					fullness.add(currf + A);
					usedWater.add(used);
				}
				if (currf + B > T && !used && !done) {
					fullness.add((int) currf / 2);
					usedWater.add(true);
					done = true;
				} else if (currf + B <= T) {
					fullness.add(currf + B);
					usedWater.add(used);
				}
				if (!used && !done && currf != 0) {
					fullness.add((int) currf / 2);
					usedWater.add(true);
				}

			}
		}
		out.print(max);
		out.close();
		br.close();
	}

}
