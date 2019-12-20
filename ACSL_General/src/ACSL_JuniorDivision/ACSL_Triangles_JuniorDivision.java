package ACSL_JuniorDivision;

import java.util.*;

public class ACSL_Triangles_JuniorDivision {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		for (int j = 0; j < 5; j++) {
			int pairs = 0;
			System.out.println("Enter triangle's length of sides: ");
			double triangle1side1 = scan.nextDouble(), triangle1side2 = scan.nextDouble(),
					triangle1side3 = scan.nextDouble(), triangle2side1 = scan.nextDouble(),
					triangle2side2 = scan.nextDouble(), triangle2side3 = scan.nextDouble();
			double[] triangle1sides = { triangle1side1, triangle1side2, triangle1side3 },
					triangle2sides = { triangle2side1, triangle2side2, triangle2side3 };
			for (int i = 0; i < 3; i++) {

				for (int x = 0; x < 3; x++) {
					for (int l = 0; l < 3; l++) {
						if ((triangle1sides[x] == triangle2sides[l])
								&& (triangle1sides[x] != 0 && triangle2sides[l] != 0)) {
							pairs++;
							triangle1sides[x] = 0;
							triangle2sides[l] = 0;
							continue;
						}
					}

				}
			}

			System.out.println((int) pairs);
			continue;

		}

	}

}
