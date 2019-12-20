
public class Dinesman {

	public static void main(String[] args) {
		int baker = 0, cooper = 0, fletcher = 0, miller = 0, smith = 0;
		for (int b = 0; b < 5; b++) {
			for (int c = 1; c <= 5; c++) {
				for (int f = 1; f <= 5; f++) {
					for (int m = 1; m <= 5; m++) {
						for (int s = 1; s <= 5; s++) {
							if (b == c || b == f || b == m || b == s) {
								continue;
							} else if (c == f || c == m || c == s) {
								continue;
							} else if (f == m || f == s) {
								continue;
							} else if (m == s) {
								continue;
							} else if (b != 5 && c != 1 && (f != 5 && f != 1) && m > c && (s + 1 != f && s - 1 != f)
									&& (f + 1 != c && f - 1 != c)) {
								baker = b;
								cooper = c;
								fletcher = f;
								miller = m;
								smith = s;
							}
						}
					}
				}
			}
		}

		System.out.println("Baker: " + baker + " Cooper: " + cooper + " Fletcher: " + fletcher + " Miller: " + miller
				+ " Smith: " + smith);

	}
}
