import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class AlexAndBrokenContest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

		String contest = br.readLine();
		out.println(solve(contest));
		br.close();
		out.close();
	}

	public static String solve(String contest) {
		String[] names = { "Danil", "Olya", "Slava", "Ann", "Nikita" };
		for (int i = 0; i < 5; i++) {
			boolean contains = true;
			if (contest.contains(names[i])) {
				for (int j = 0; j < 5; j++) {
					if (j == i) {
						String tmp = contest.substring(contest.indexOf(names[i]) + names[i].length(), contest.length());
						if (tmp.contains(names[i])) {
							return "NO";
						}
					} else if (contest.contains(names[j]))
						contains = false;
				}

			} else
				contains = false;
			if (contains) {
				return "YES";
			}
		}
		return "NO";
	}

}
