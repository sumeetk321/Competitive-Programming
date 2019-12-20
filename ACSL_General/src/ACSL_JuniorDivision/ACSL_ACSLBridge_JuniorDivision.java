package ACSL_JuniorDivision;

import java.util.Scanner;

public class ACSL_ACSLBridge_JuniorDivision {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int bidAmt, tricks, line, aboveLineAmt, belowLineAmt;
		String suit;

		for (int i = 0; i < 10; i++) {
			System.out.println("Enter bid amount, number of tricks won, and suit");
			bidAmt = scan.nextInt();
			tricks = scan.nextInt();
			suit = scan.next();
			line = bidAmt + 6;
			belowLineAmt = line - 6;
			if (tricks > line) {
				aboveLineAmt = tricks - line;
			} else {
				aboveLineAmt = 0;
			}

			if (suit.equals("H") || suit.equals("S")) {
				System.out.println(belowLineAmt * 30 + ", " + aboveLineAmt * 30);
				continue;
			} else if (suit.equals("C") || suit.equals("D")) {
				System.out.println(belowLineAmt * 20 + ", " + aboveLineAmt * 20);
				continue;
			} else if (suit.equals("N")) {
				System.out.println((40 + (belowLineAmt - 1) * 30) + ", " + aboveLineAmt * 30);
				continue;
			}

		}

	}

}
