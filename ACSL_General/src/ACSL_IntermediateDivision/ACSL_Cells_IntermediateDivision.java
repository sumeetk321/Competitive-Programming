package ACSL_IntermediateDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ACSL_Cells_IntermediateDivision {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("CellsI2.txt");
		Scanner scan = new Scanner(file);

		for (int i = 0; i < 5; i++) {
			String[] input = scan.nextLine().split(", ");

			if ("DIVIDE".equals(input[0])) {
				String str1 = input[1].substring(0, 4), str2 = input[1].substring(4, 8);
				str1 = str1 + str1;
				str2 = str2 + str2;
				System.out.println(str1 + " and " + str2);
			} else if(input[0].startsWith("ADD")){
				String str1 = input[1].substring(0, Character.getNumericValue(input[0].charAt(3)));
				String str2 = input[1].substring(Character.getNumericValue(input[0].charAt(3)), ((8-Character.getNumericValue(input[0].charAt(3)))));
				
				String str = str1+str1+str2;
				System.out.println(str);
				
			} else if(input[0].startsWith("SUBTRACT")){
				String str1 = input[1].substring(Character.getNumericValue(input[0].charAt(8)), ((8-Character.getNumericValue(input[0].charAt(8)))));
				String str2 = input[1].substring(7- Character.getNumericValue(input[0].charAt(8))+1, 8);
				
				String str = str1+str2+str2;
				System.out.println(str);
			} else if(input[0].equals("UNION")){
				String str1 = input[1].substring(4, 8);
				String str2 = input[2].substring(0, 4);
				String str = str1+str2;
				System.out.println(str);
			} else if(input[0].equals("INTERSECT")){
				String str1 = input[1].substring(0, 2) + input[1].substring(6, 8);
				String str2 = input[2].substring(0, 2) + input[2].substring(6, 8);
				
				String str = str1+str2;
				System.out.println(str);
			}
		}

	}

}
