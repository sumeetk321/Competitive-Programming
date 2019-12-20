package ACSL_JuniorDivision;

import java.util.Scanner;

public class ACSL_Probability_JuniorDivision {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int marblesSelected, red, blue, probability;
		String event1, event2, replacement;

		for (int i = 0; i < 5; i++) {
			System.out.println("Enter marbles to be selected: ");
			marblesSelected = scan.nextInt();
			if (marblesSelected == 1) {
				System.out.println("Enter # of red marbles: ");
				red = scan.nextInt();
				System.out.println("Enter # of blue marbles: ");
				blue = scan.nextInt();
				System.out.println("Enter event(s): ");
				event1 = scan.next();

				if (event1.equals("R")) {
					System.out.println(red + "/" + (red + blue));
				} else if (event1.equals("B")) {
					System.out.println(blue + "/" + (red + blue));
				}
				// Case 2
			} else if (marblesSelected == 2) {
				System.out.println("Enter # of red marbles: ");
				red = scan.nextInt();
				System.out.println("Enter # of blue marbles: ");
				blue = scan.nextInt();
				System.out.println("Enter replacement (Y/N): ");
				replacement = scan.next();
				System.out.println("Enter event(s): ");
				event1 = scan.next();
				event2 = scan.next();

				if (replacement.equals("Y")) {
					if (event1.equals(event2)) {
						if (event1.equals("R")) {
							System.out.println((red * red) + "/" + ((int) Math.pow(red + blue, 2)));
						} else if (event2.equals("B")) {
							System.out.println((blue * blue) + "/" + ((int) Math.pow(red + blue, 2)));
						}
						continue;
					}
					System.out.println((red * blue) + "/" + ((int) Math.pow(red + blue, 2)));
					// Case 3
				} else if (replacement.equals("N")) {
					if (event1.equals(event2)) {
						if (event1.equals("R")) {
							System.out.println((red * (red - 1)) + "/" + ((int) ((red + blue) * (red + blue - 1))));
						} else if (event1.equals("B")) {
							System.out.println((blue * (blue - 1)) + "/" + ((int) ((red + blue) * (red + blue - 1))));
						}
						continue;
					}
					System.out.println((red * blue) + "/" + ((int) (red + blue) * (red + blue - 1)));
				}

			}

		}
	}

}
