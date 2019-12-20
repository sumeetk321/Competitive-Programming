import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class reduce {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Cowpoint[] cows = new Cowpoint[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cows[i] = new Cowpoint(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(cows, new Comparator<Cowpoint>() {

			@Override
			public int compare(Cowpoint arg0, Cowpoint arg1) {
				return Integer.compare(arg0.x, arg1.x);
			}

		});
		cows[0].possible = true;
		cows[1].possible = true;
		cows[2].possible = true;
		cows[N - 3].possible = true;
		cows[N - 2].possible = true;
		cows[N - 1].possible = true;
		Arrays.sort(cows, new Comparator<Cowpoint>() {

			@Override
			public int compare(Cowpoint arg0, Cowpoint arg1) {
				return Integer.compare(arg0.y, arg1.y);
			}

		});
		cows[0].possible = true;
		cows[1].possible = true;
		cows[2].possible = true;
		cows[N - 3].possible = true;
		cows[N - 2].possible = true;
		cows[N - 1].possible = true;
		ArrayList<Cowpoint> possibles = new ArrayList<Cowpoint>();
		for (Cowpoint t : cows) {
			if (t.possible && !possibles.contains(t)) {
				possibles.add(t);
			}
		}

		int area = Integer.MAX_VALUE;
		for (int i = 0; i < Math.pow(2, possibles.size()); i++) {
			String bin = Integer.toBinaryString(i);
			while (bin.length() < possibles.size()) {
				bin = "0" + bin;
			}
			//System.out.println(bin);
			int binsum = 0;
			for (int j = 0; j < bin.length(); j++) {
				binsum += Character.getNumericValue(bin.charAt(j));
			}
			if (binsum == 3) {
				ArrayList<Cowpoint> tmpremove = new ArrayList<Cowpoint>();
				for (int j = 0; j < bin.length(); j++) {
					if (bin.charAt(j) == '1') {
						tmpremove.add(possibles.get(j));
					}
				}

				int minx = Integer.MAX_VALUE;
				int maxx = 0;
				int miny = Integer.MAX_VALUE;
				int maxy = 0;
				for (Cowpoint test : cows) {
					if (tmpremove.contains(test)) {
						continue;
					}
					minx = Math.min(minx, test.x);
					maxx = Math.max(maxx, test.x);
					miny = Math.min(miny, test.y);
					maxy = Math.max(maxy, test.y);
				}
				area = Math.min(area, (maxx - minx) * (maxy - miny));
			}
		}
		System.out.println(area);
	}

}

class Cowpoint {
	public int x;
	public int y;
	public boolean possible = false;

	public Cowpoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}