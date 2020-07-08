
/*
ID: sumeetk1
LANG: JAVA
TASK: combo
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class combo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("combo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
		int N = Integer.parseInt(br.readLine());
		int[] FJCombo = new int[3];
		int[] MasterCombo = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			FJCombo[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			MasterCombo[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Combination> combos = new ArrayList<Combination>();
		// Checking fj combos
		for (int i = FJCombo[0] - 2; i <= FJCombo[0] + 2; i++) {
			for (int j = FJCombo[1] - 2; j <= FJCombo[1] + 2; j++) {
				for (int k = FJCombo[2] - 2; k <= FJCombo[2] + 2; k++) {
					Combination testcombo = new Combination(dialNum(N, i), dialNum(N, j), dialNum(N, k));
					if (!(testcombo.getNum1() == 0 || testcombo.getNum2() == 0 || testcombo.getNum3() == 0)) {
						if (!combos.contains(testcombo)) {
							combos.add(testcombo);
						}
					}
				}
			}
		}
		/// Checking Master combos
		for (int i = MasterCombo[0] - 2; i <= MasterCombo[0] + 2; i++) {
			for (int j = MasterCombo[1] - 2; j <= MasterCombo[1] + 2; j++) {
				for (int k = MasterCombo[2] - 2; k <= MasterCombo[2] + 2; k++) {
					Combination testcombo = new Combination(dialNum(N, i), dialNum(N, j), dialNum(N, k));
					if (dialNum(N, k) == 0) {
						dialNum(N, k);
					}

					if (!(testcombo.getNum1() == 0 || testcombo.getNum2() == 0 || testcombo.getNum3() == 0)) {
						if (!combos.contains(testcombo)) {
							combos.add(testcombo);
						}
					}
				}
			}
		}
		out.println(combos.size());
		out.close();
	}

	public static int dialNum(int N, int test) {
		if (test <= 0) {
			return N + test;
		} else if (test > N) {
			int tmp = test % N;
			if (tmp == 0) {
				return N;
			} else {
				return tmp;
			}
		}
		return test;
	}
}

class Combination {
	private int num1;
	private int num2;
	private int num3;

	public Combination(int num1, int num2, int num3) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}

	@Override
	public boolean equals(Object other) {
		boolean result = false;
		if (other instanceof Combination) {
			Combination that = (Combination) other;
			result = (this.getNum1() == that.getNum1() && this.getNum2() == that.getNum2()
					&& this.getNum3() == that.getNum3());
		}
		return result;
	}

	public int getNum1() {
		return num1;
	}

	public int getNum2() {
		return num2;
	}

	public int getNum3() {
		return num3;
	}
}
