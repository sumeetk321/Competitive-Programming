package ACSL_JuniorDivision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ACSL_BullsandCows {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int bulls, cows;
		bulls = cows = 0;

		ArrayList<Integer> num = new ArrayList<Integer>();
		ArrayList<Integer> digits = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		for(int i = 0; i < 4; i++){
			int rand = (int) (Math.random()*digits.size());
			num.add(digits.get(rand));
			digits.remove(rand);
		}
		System.out.println(num.get(0) + "" + num.get(1) + "" + num.get(2) + "" + num.get(3));

		boolean guessed = false;
		while (!guessed) {

			System.out.println("Enter guess");

			String input = scan.nextLine();
			if (input.equals(num.get(0) + "" + num.get(1) + "" + num.get(2) + "" + num.get(3))) {
				System.out.println("Bulls: " + bulls + " Cows: " + cows);
				guessed = true;
			} else {
				for (int i = 0; i < 4; i++) {
					if (num.get(i) == Character.getNumericValue(input.charAt(i))) {
						bulls++;
						System.out.println("BULL");
					} else if (num.contains(Character.getNumericValue(input.charAt(i)))
							&& ((num.indexOf(Character.getNumericValue(input.charAt(i))) != i))) {
						cows++;
						System.out.println("COW");
					}
				}

			}

		}

	}

}
