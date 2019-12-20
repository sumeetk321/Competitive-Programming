import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
public class RockPaperScissors {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			ArrayList<String> tmp = new ArrayList<String>();
			ArrayList<String> tmp1 = new ArrayList<String>();
			while(st.hasMoreTokens()){
				String add = st.nextToken();
				if (!tmp.contains(add)) tmp.add(add);
				tmp1.add(add);
			}
			Collections.sort(tmp1);
			if (tmp.size() == 1 || tmp.size() == 3) System.out.println("NO WINNER");
			else {
				if (tmp1.contains("R") && tmp1.contains("S")) {
					if (tmp1.indexOf("S") == 1) System.out.println("ROCK");
					else System.out.println("NO WINNER");
				}
				else if (tmp1.contains("P") && tmp1.contains("S")) {
					if (tmp1.indexOf("S") == tmp1.size() - 1) System.out.println("SCISSORS");
					else System.out.println("NO WINNER");
				}
				else if (tmp1.contains("P") && tmp1.contains("R")) {
					if (tmp1.indexOf("R") == 1) System.out.println("PAPER");
					else System.out.println("NO WINNER");
				}
			}
		}
	}

}
