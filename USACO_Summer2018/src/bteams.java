import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class bteams {
	static int ans = Integer.MAX_VALUE;
	static int[] cows = new int[12];
	static int[] teams = new int[12];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 12; i++) {
			cows[i] = (Integer.parseInt(br.readLine()));
		}
		recurse(0);
		System.out.println(ans);
	}

	public static void recurse(int curr) {
		if (curr == 12) {
			int ones = 0;
			int twos = 0;
			int threes = 0;
			int fours = 0;
			for (int i = 0; i < 12; i++) {
				switch (teams[i]) {
				case 1:
					ones++;
					break;
				case 2:
					twos++;
					break;
				case 3:
					threes++;
					break;
				case 4:
					fours++;
					break;
				}
			}
			if (ones == 3 && twos == 3 && threes == 3 && fours == 3) {
				int max = 0;
				int min = Integer.MAX_VALUE;
				for (int i = 1; i <= 4; i++) {
					int tmp = 0;
					for (int j = 0; j < 12; j++) {
						if (teams[j] == i) {
							tmp += cows[j];
						}
					}
					max = Math.max(max, tmp);
					min = Math.min(min, tmp);
				}
				ans = Math.min(ans, max - min);
			}
			return;
		}
		teams[curr] = 1;
		recurse(curr + 1);
		teams[curr] = 2;
		recurse(curr + 1);
		teams[curr] = 3;
		recurse(curr + 1);
		teams[curr] = 4;
		recurse(curr + 1);
	}
}
