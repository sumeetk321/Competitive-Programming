package ACSL_IntermediateDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ACSL_ACSLFLOCK_IntermediateDivision {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("FlockI2.txt");
		Scanner scan = new Scanner(file);
		for (int i = 0; i < 5; i++) {
			int counter = 0, gcounter = -1;
			String[] in = scan.nextLine().split(", ");
			String[] array = { " ", " ", " ", " ", " ", " ", " ", " ", " ", " " };

			int stage = Integer.parseInt(in[in.length - 1]);
			for (int j = 1; j <= Integer.parseInt(in[0]); j++) {
				array[Integer.parseInt(in[j]) - 1] = "B";
			}
			String[] tmp = array;
			for (int k = 0; k < stage; k++) {
				tmp = array;

				if (k == stage - 1) {
					String compare = "";
					for (String x : array) {
						compare += x;
					}
					for (int m = 0; m < 10; m++) {
						if (compare.charAt(m) == 'B') {
							counter++;
						} else {
							if (counter >= gcounter) {
								gcounter = counter;
							}
							counter = 0;
						}
						if (counter >= gcounter) {
							gcounter = counter;
						}
					}
					break;
				}
				boolean used = false;
				if (tmp[9].equals("B") && tmp[0].equals(" ")) {
					tmp[9] = " ";
					tmp[0] = "B";
					used = true;
				}
				if (used) {
					for (int l = 1; l < 9; l++) {
						if (tmp[l].equals("B") && tmp[l + 1].equals(" ")) {
							tmp[l] = " ";
							tmp[l + 1] = "B";
							l++;
						}
					}
				} else {
					for (int l = 0; l < 9; l++) {
						if (tmp[l].equals("B") && tmp[l + 1].equals(" ")) {
							tmp[l] = " ";
							tmp[l + 1] = "B";
							l++;
						}
					}
				}
				array = tmp;

			}
			System.out.println(gcounter);
		}
	}

}
