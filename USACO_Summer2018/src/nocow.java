import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.StringTokenizer;

public class nocow {
	static int K;
	static TreeSet<String>[] adjectives;
	static String[] nothave;
	static int cownum = 1;
	static int numadj = 0;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] choices = null;
		nothave = new String[N];
		for (int i = 0; i < N; i++) {
			nothave[i] = "{";
		}
		boolean done = false;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			numadj = st.countTokens() - 5;
			if (!done) {
				adjectives = new TreeSet[numadj];
				for (int j = 0; j < numadj; j++) {
					adjectives[j] = new TreeSet<String>();
				}
				choices = new int[numadj];
			}
			done = true;
			int adjindex = 0;
			String add = "";
			st.nextToken();
			st.nextToken();
			st.nextToken();
			st.nextToken();
			while (st.hasMoreTokens()) {
				String test = st.nextToken();
				if (test.equals("cow.")) {
					break;
				}
				add += test + " ";
				adjectives[adjindex].add(test);
				adjindex++;
			}
			add = add.trim();
			nothave[i] = add;
		}
		for (int i = 0; i < numadj; i++) {
			choices[i] = adjectives[i].size();
		}

		Arrays.sort(nothave);
		for (int i = 0; i < numadj; i++) {
			System.out.println(adjectives[i]);
		}
		System.out.println();
		System.out.println(Arrays.toString(nothave));
		System.out.println(Arrays.toString(choices));
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 2; k++) {
					System.out.println(i + "" + j + "" + k);
				}
			}
		}
		/*
		 * 000 - 1 001 - 2 010 - 3 011 - 4 020 - 5 021 - 6 ...
		 */
		// recurse(0, "");
	}

	public static int[] convert(int N, int[] check){
		return check;
	}
}
