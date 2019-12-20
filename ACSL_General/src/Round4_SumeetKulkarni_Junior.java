import java.util.Scanner;
//Round4_SumeetKulkarni_Junior
public class Round4_SumeetKulkarni_Junior {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			String[] in = scan.nextLine().split(", ");
			int ways = 0;
			for (int j = 1; j <= 5; j++) {
				for (int k = 1; k <= 5; k++) {
					for (int l = 1; l <= 5; l++) {
						for (int m = 1; m <= 5; m++) {
							for (int n = 1; n <= 5; n++) {
								if (j != k && j != l && j != m && j != n && k != l && k != m && k != n && l != m
										&& l != n && m != n) {
									int visiblefromleft = 1, visiblefromright = 1;
									if (k > j)
										visiblefromleft++;
									if (l > j && l > k)
										visiblefromleft++;
									if (m > l && m > k && m > j)
										visiblefromleft++;
									if (n > m && n > l && n > k && n > j)
										visiblefromleft++;

									if (m > n)
										visiblefromright++;
									if (l > m && l > n)
										visiblefromright++;
									if (k > l && k > m && k > n)
										visiblefromright++;
									if (j > k && j > l && j > m && j > n)
										visiblefromright++;

									if (Integer.toString(visiblefromleft).equals(in[0])
											&& Integer.toString(visiblefromright).equals(in[1])) {
										ways++;
									}
								}
							}
						}
					}
				}
			}

			System.out.println(ways);
		}

	}

}
