package ACSL_JuniorDivision;

import java.util.Scanner;

public class ACSL_ACSLScrabble_JuniorDivision {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int multiplier = 0, startingnumber, score = 0, wordmultiplier = 0;
		char[] letters = new char[4];
		int[] scores = new int[5];
		for (int i = 0; i < 4; i++) {
			System.out.println("Enter letter");
			letters[i] = scan.nextLine().charAt(0);
		}

		for (int i = 0; i < 5; i++) {
			score = 0;
			wordmultiplier = 1;
			System.out.println("Enter starting number");
			startingnumber = scan.nextInt();
			for (int j = startingnumber; j <= startingnumber + 3; j++) {
				int index = j - startingnumber;
				if (j % 3 == 0 && j % 2 != 0) {
					multiplier = 2;
				} else if (j % 5 == 0) {
					multiplier = 3;
				} else if (j % 7 == 0) {
					wordmultiplier = 2;
					multiplier = 1;
				} else if (j % 8 == 0) {
					wordmultiplier = 3;
					multiplier = 1;
				} else {
					multiplier = 1;
				}

				if (letters[index] == 'A' || letters[index] == 'E') {
					score += (1 * multiplier);
				} else if (letters[index] == 'D' || letters[index] == 'R') {
					score += (2 * multiplier);
				} else if (letters[index] == 'B' || letters[index] == 'M') {
					score += (3 * multiplier);
				} else if (letters[index] == 'V' || letters[index] == 'Y') {
					score += (4 * multiplier);
				} else if (letters[index] == 'J' || letters[index] == 'X') {
					score += (8 * multiplier);
				}

			}

			score *= wordmultiplier;
			scores[i] = score;

		}
		int i = 1;
		for (int x : scores) {

			System.out.println(i + ". " + x);
			i++;
		}

	}

}
