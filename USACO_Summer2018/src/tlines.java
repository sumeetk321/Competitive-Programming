import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class tlines {
	static int distinctnum;
	static TreeMap<Integer, Integer> count = new TreeMap<Integer, Integer>();
	static Cowpoint1[] coords;
	static int sortnum = 0;
	static int N;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		coords = new Cowpoint1[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			coords[i] = new Cowpoint1(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		// System.out.println(max);
		if (solve()) {
			System.out.println("1");
		} else {
			for(int i = 0; i < N; i++){
				int tmp = coords[i].y;
				coords[i].y = coords[i].x;
				coords[i].x = tmp;
			}
			if (solve()) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}
	}

	public static boolean solve() {
		Arrays.sort(coords, new Comparator<Cowpoint1>() {

			@Override
			public int compare(Cowpoint1 arg0, Cowpoint1 arg1) {
				return Integer.compare(arg0.x, arg1.x);
			}

		});
		distinctnum = 0;
		count.clear();
		/*for (Cowpoint1 ye : coords) {
			System.out.println(ye.x + " " + ye.y);
		}*/
		for (int i = 0; i < N; i++) {
			addDistinct(coords[i].y);
		}
		//System.out.println(count);
		if (distinctnum <= 3) {
			return true;
		}
		int i = 0;
		int j = 0;
		while (i < N) {
			while (j < N && coords[i].x == coords[j].x) {
				j++;
			}
			for (int j1 = i; j1 < j; j1++) {
				//System.out.println("xval: "+coords[j1].x);
				removeDistinct(coords[j1].y);
			}
			if (distinctnum <= 2){
				//System.out.println("in here");
				return true;
			}
			for (int j1 = i; j1 < j; j1++) {
				addDistinct(coords[j1].y);
			}
			i = j;
		}
		return false;
	}

	public static void addDistinct(int x) {
		//System.out.println(x + " X");
		if (count.containsKey(x)) {
			if (count.get(x) == 0) {
				distinctnum++;
			}
			count.put(x, count.get(x) + 1);
		} else {
			count.put(x, 1);
			distinctnum++;
		}
		//System.out.println(count);
		//System.out.println(distinctnum);
	}

	public static void removeDistinct(int x) {
		//System.out.println(x + " x");
		if (count.containsKey(x)) {
			count.put(x, count.get(x) - 1);
			if (count.get(x) == 0) {
				distinctnum--;
			}
		} else {
			count.put(x, 0);
			distinctnum--;
		}
		//System.out.println(count);
		//System.out.println(distinctnum);
	}
}

class Cowpoint1 {
	public int x;
	public int y;

	public Cowpoint1(int x, int y) {
		this.x = x;
		this.y = y;
	}
}