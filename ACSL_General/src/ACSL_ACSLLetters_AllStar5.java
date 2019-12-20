import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ACSL_ACSLLetters_AllStar5 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Letters1.txt");
		Scanner scan = new Scanner(file);
		for (int j = 0; j < 2; j++) {
			String input = scan.nextLine().toUpperCase();
			String tmp = "";
			for (int i = 0; i < input.length(); i++) {
				if (((int) (input.charAt(i)) < 65 || (int) (input.charAt(i)) > 90) && (int) (input.charAt(i)) != 32) {
					if (i < input.length() - 1) {
						if (input.charAt(i + 1) == ' ') {
							continue;
						}
					}
					tmp += " ";
				} else {

					tmp += input.charAt(i);
				}
			}
			tmp.trim();
			String[] inwords = tmp.split(" ");

			// Part 1
			int[] occurences = new int[26];
			for (int i = 0; i < 26; i++) {
				occurences[i] = 0;
			}
			for (int i = 0; i < input.length(); i++) {
				if (((int) input.charAt(i)) - 65 >= 0) {
					occurences[((int) input.charAt(i)) - 65]++;
				}
			}
			int greatest = 0, index = 0;
			for (int i = 0; i < 26; i++) {
				if (occurences[i] > greatest) {
					greatest = occurences[i];
					index = i;
				}
			}
			System.out.println(((char) (index + 65)) + " " + greatest);
			for (int i = 0; i < 26; i++) {
				occurences[i] = 0;
			}
			// Part 2
			for (String x : inwords) {
				for (int k = 0; k < 26; k++) {
					if (x.contains(((char) (k + 65)) + "")) {
						occurences[k]++;
					}
				}
			}
			greatest = 0;
			index = 0;
			for (int i = 0; i < 26; i++) {
				if (occurences[i] > greatest) {
					greatest = occurences[i];
					index = i;
				}
			}
			System.out.println(((char) (index + 65)) + " " + greatest);
			// Part 3
			occurences = new int[26];
			for (int i = 0; i < 26; i++) {
				occurences[i] = 0;
			}
			for (int i = 0; i < input.length(); i++) {
				if (((int) input.charAt(i)) - 65 >= 0) {
					occurences[((int) input.charAt(i)) - 65]++;
				}
			}
			ArrayList<String> let1 = new ArrayList<String>();
			for (int i = 0; i < 26; i++) {
				if (occurences[i] > 0) {
					let1.add(((char) (i + 65)) + "");
				}
			}
			Collections.sort(let1);
			Collections.reverse(let1);
			for (String x : let1) {
				System.out.print(x);
			}
			System.out.print("\n");
			for (int i = 0; i < 26; i++) {
				occurences[i] = 0;
			}
			// Part 4
			for (int i = 0; i < 26; i++) {
				occurences[i] = 0;
			}
			ArrayList<String> letters = new ArrayList<String>();
			for (String x : inwords) {
				for (int k = 0; k < x.length(); k++) {
					if ((int) (x.charAt(k)) - 65 >= 0) {
						occurences[(int) (x.charAt(k)) - 65]++;
					}
				}
				for (int i = 0; i < 26; i++) {
					if (occurences[i] > 1) {
						letters.add(((char) (i + 65)) + "");
					}
				}
				for (int i = 0; i < 26; i++) {
					occurences[i] = 0;
				}
			}
			Set<String> set = new HashSet<String>();
			set.addAll(letters);
			letters.clear();
			letters.addAll(set);
			set.clear();
			Collections.sort(letters);
			for (String x : letters) {
				System.out.print(x);
			}
			System.out.print("\n");
			// Part 5
			occurences = new int[26];
			for (int i = 0; i < 26; i++) {
				occurences[i] = 0;
			}
			for (int i = 0; i < input.length(); i++) {
				if (((int) input.charAt(i)) - 65 >= 0) {
					occurences[((int) input.charAt(i)) - 65]++;
				}
			}
			greatest = 0;
			index = 0;
			ArrayList<ArrayList<String>> darn = new ArrayList<ArrayList<String>>();
			for (int i = 0; i < 26; i++) {
				if (occurences[i] > greatest) {
					greatest = occurences[i];
				}
			}
			for (int i = 2; i <= greatest; i++) {
				ArrayList<String> tmp1 = new ArrayList<String>();
				for (int k = 0; k < 26; k++) {
					if (occurences[k] == i) {
						tmp1.add(((char) (k + 65)) + "");
					}
				}
				Collections.sort(tmp1);
				darn.add(tmp1);
			}
			Collections.reverse(darn);
			for (ArrayList<String> x : darn) {
				for (String y : x) {
					System.out.print(y + "");
				}
			}
			System.out.print("\n");
			for (int i = 0; i < 26; i++) {
				occurences[i] = 0;
			}
		}
	}

}
