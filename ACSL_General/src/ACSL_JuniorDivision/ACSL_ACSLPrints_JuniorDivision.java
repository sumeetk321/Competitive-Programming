package ACSL_JuniorDivision;

import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_ACSLPrints_JuniorDivision {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int[] whorls = { 16, 16, 8, 8, 4, 4, 2, 2, 1, 1 };
		for (int k = 0; k < 5; k++) {
			int evensum = 1, oddsum = 1;
			/*
			 * input = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, evenNum, oddNum; evenNum
			 * = oddNum = new int[10];
			 */
			System.out.println("Enter finger numbers");
			int i = 0;
			while (scan.hasNextLine()) {
				int in = Integer.parseInt(scan.nextLine());
				if (in == 0) {
					break;
				} else {
					if (isEven(in)) {
						// System.out.println("even");
						evensum += whorls[in - 1];
						// System.out.println(evensum);
					} else {
						// System.out.println("odd");
						oddsum += whorls[in - 1];
						// System.out.println(oddsum);
					}
				}
			}

			System.out.println(evensum + "/" + oddsum);
		}

	}
	
	

	public static boolean isEven(int a) {
		if (a % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

}
