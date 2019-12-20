import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class dishes {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> dirty = new Stack<Integer>();
		Stack<Integer> washed = new Stack<Integer>();
		Stack<Integer> clean = new Stack<Integer>();
		for (int i = N; i > 0; i--) {
			dirty.push(i);
		}
		String test;
		while ((test = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(test);
			int C = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			/*
			 * System.out.println(dirty); System.out.println(washed);
			 * System.out.println(clean); System.out.println();
			 */
			if (C == 1) {
				for (int j = 0; j < D; j++) {
					washed.push(dirty.pop());
				}
			} else {
				for (int j = 0; j < D; j++) {
					clean.push(washed.pop());
				}
			}
		}
		while(!clean.isEmpty()){
			System.out.println(clean.pop());
		}
	}

}
