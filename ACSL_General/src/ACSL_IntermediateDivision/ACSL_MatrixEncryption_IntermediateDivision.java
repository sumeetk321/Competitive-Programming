package ACSL_IntermediateDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ACSL_MatrixEncryption_IntermediateDivision {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("MatrixEncryptionI2.txt");
		Scanner scan = new Scanner(file);
		
		for (int i = 0; i < 5; i++) {
			String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
			String[] in = scan.nextLine().split(", ");
			int[] matr1 = new int[Integer.parseInt(in[0]) / 2];
			int[] matr2 = new int[Integer.parseInt(in[0]) / 2];
			for (int j = 1; j <= Integer.parseInt(in[0]) / 2; j++) {
				matr1[j - 1] = Integer.parseInt(in[j]);
				if (Integer.parseInt(in[0]) % 2 == 1 && j==Integer.parseInt(in[0])) {
					matr2[j - 1] = 27;

				} else {
					matr2[j - 1] = Integer.parseInt(in[j + Integer.parseInt(in[0]) / 2]);
				}
			}

			int a = Integer.parseInt(in[Integer.parseInt(in[0]) + 1]),
					b = Integer.parseInt(in[Integer.parseInt(in[0]) + 2]),
					c = Integer.parseInt(in[Integer.parseInt(in[0]) + 3]),
					d = Integer.parseInt(in[Integer.parseInt(in[0]) + 4]);
			int multiplier = 1 / ((a * d) - (b * c));
			int tmp1 = a;
			a = d * multiplier;
			b = -b * multiplier;
			c = -c * multiplier;
			d = tmp1 * multiplier;

			for (int j = 0; j < matr1.length; j++) {
				int tmp = matr1[j];
				matr1[j] = a*matr1[j] + b*matr2[j];
				matr2[j] = c*tmp + d*matr2[j];
			}
			
			for(int j = 0; j < matr1.length; j++){
				System.out.print(alpha.charAt(matr1[j]-1)+""+alpha.charAt(matr2[j]-1));
			}
			System.out.println("\n");
		}

	}

}
