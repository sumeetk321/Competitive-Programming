//Round2_SumeetKulkarni_Junior

import java.util.ArrayList;
import java.util.Scanner;

public class Round2_SumeetKulkarni_Junior {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.println("Enter input: ");
			String num = scan.nextLine();
			boolean notsolved = true;
			int j = 0;
			int tmp = 0;
			mainloop: while (notsolved) {
				if (j >= num.length() - 1) {

					notsolved = false;
				}

				String tmp1 = "";
				for (int k = j; k < num.length(); k++) {
					tmp1 += num.charAt(k);
					if (Integer.parseInt(tmp1) > tmp) {
						System.out.print(tmp1 + " ");
						tmp = Integer.parseInt(tmp1);
						j = k + 1;
						continue mainloop;
					} else {
						if (k == num.length() - 1) {
							notsolved = false;
						} else {
							continue;
						}
					}
				}

			}

			System.out.println("\n");

		}
		System.exit(0);
	}

}
