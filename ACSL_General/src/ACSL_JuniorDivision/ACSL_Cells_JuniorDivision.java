package ACSL_JuniorDivision;

import java.util.Scanner;

public class ACSL_Cells_JuniorDivision {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			System.out.println("Enter input:");
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
			}
		}

	}

}
