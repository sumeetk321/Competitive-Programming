import java.util.HashSet;
import java.util.Scanner;

public class boost2 {

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		Scanner scan = new Scanner(System.in);
		int F = scan.nextInt();
		int M = scan.nextInt();
		int N = scan.nextInt();
		scan.nextLine();
		int[][] parts = new int[N][2];
		for (int i = 0; i < N; i++) {
			parts[i][0] = scan.nextInt();
			parts[i][1] = scan.nextInt();
			scan.nextLine();
		}
		double maxacc = 0;
		HashSet<Integer> usedparts = new HashSet<Integer>();
		for (int i = 0; i < (1 << N); i++) {
			int currforce = F;
			int currmass = M;
			HashSet<Integer> tmp = new HashSet<Integer>();
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) {
					currforce += parts[j][0];
					currmass += parts[j][1];
					tmp.add(j);
				}
			}
			if (((double) currforce / (double) currmass) > maxacc) {
				maxacc = ((double) currforce / (double) currmass);
				usedparts = new HashSet<Integer>(tmp);
			}
		}
		// System.out.println(usedparts.size());
		if (usedparts.size() == 0) {
			System.out.println("NONE");
		} else {
			for (int x : usedparts) {
				System.out.println(x + 1);
			}
		}
	}
}
