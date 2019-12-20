package ACSL_JuniorDivision;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ACSL_ACSLPOSTOFFICE_JuniorDivision {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		StringTokenizer st;
		double length, height, thickness;

		for (int i = 0; i < 5; i++) {
			System.out.println("Enter input");
			String initial = scan.nextLine();
			String[] input = initial.split(", ");
			length = Double.parseDouble(input[0]);
			height = Double.parseDouble(input[1]);
			thickness = Double.parseDouble(input[2]);
			
			System.out.println(length+" " + height + " " + thickness);

			if ((length >= 3.5 && length <= 4.25) && (height >= 3.5 && height <= 6)
					&& (thickness >= 0.007 && thickness <= 0.16)) {
				System.out.println("REGULAR POST CARD");
				continue;
			} else if ((length >= 4.25 && length <= 6) && (height >= 6 && height <= 11.5)
					&& (thickness >= 0.007 && thickness <= 0.016)) {
				System.out.println("LARGE POST CARD");
				continue;
			} else if ((length >= 3.5 && length <= 6.125) && (height >= 5 && height <= 11.5)
					&& (thickness >= 0.016 && thickness <= 0.25)) {
				System.out.println("ENVELOPE");
				continue;
			} else if ((length >= 6.125 && length <= 24) && (height >= 11 && height <= 18)
					&& (thickness >= 0.25 && thickness <= 0.5)) {
				System.out.println("LARGE ENVELOPE");
				continue;
			} else if ((length > 24 && height > 11.5 && thickness > 0.025) && (4*height + 4*length + 4*thickness <= 84)) {
				System.out.println("PACKAGE");
				continue;
			} else if (((4*height + 4*length)) > 84 && (4*height + 4*length< 130)) {
				System.out.println("LARGE PACKAGE");
				continue;
			} else {
				System.out.println("UNMAILABLE");
			}
		}

	}

}
