package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ACSL_ACSLABC_JuniorDivision {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("ABC2.txt");
		Scanner scan = new Scanner(file);

		for (int i = 0; i < 5; i++) {

			String[] input1 = scan.nextLine().split(", ");
			int n = Integer.parseInt(input1[0]);

			String[] grids = { "ABCCABBCA", "ACBBACCBA", "ABCBCACAB", "ACBCBABAC", "BACACBCBA", "BACCBAACB",
					"BCACABABC", "BCAABCCAB", "CABABCBCA", "CABBCAABC", "CBABACACB", "CBAACBBAC" };

			boolean matching = false;

			for (int j = 0; j < 12; j++) {
				matching = true;
				for (int k = 0; k < n; k++) {

					if (!(grids[j].charAt(Integer.parseInt(input1[2 * k + 1]) - 1) + "").equals(input1[2 * k + 2])) {
						matching = false;
					}
				}
				if (matching) {
					System.out.println(grids[j]);
				}

			}

		}

	}
}
