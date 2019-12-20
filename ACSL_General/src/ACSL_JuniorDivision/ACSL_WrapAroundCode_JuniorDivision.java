package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ACSL_WrapAroundCode_JuniorDivision {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("ACSL_2001_2002_JuniorDivision.txt");
		Scanner scan = new Scanner(file);
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String[] input = {"", "", "", "", ""};
		int i = 0;
		while(scan.hasNextLine()){
			input[i] = scan.nextLine();
			i++;
		}
		
		for(int j = 0;j < input.length;j++){
			int location = alphabet.indexOf(input[j])+1;
			if(location >= 1 && location <= 5){
				if(((location+1)*2)-1 == 0){
					System.out.println((j+1) + ". #");
				}else {
					System.out.println((j+1)+". " + alphabet.charAt(((location)*2)-1));
					continue;
				}
				
			} else if(location >=6 && location <= 10){
				if(((location%3)*5)-1 == 0){
					System.out.println((j+1) + ". #");
				}else {
					System.out.println((j+1) + ". " + alphabet.charAt(((location%3)*5)-1));
					continue;
				}
			} else if(location >= 11 && location <= 15){
				if(((location+1)*2)-1 == 0){
					System.out.println((j+1) + ". #");
				} else {
					System.out.println((j+1) + ". " + alphabet.charAt(((location/4)*8)-1));
					continue;
						
				}
			} else if(location >= 16 && location <= 20){
				
				int digit1 = location/10;
				int digit2 = location%10;
				int sum = digit1 + digit2;
				if((sum*10-1)%26 == 0){
					System.out.println((j+1) + ". #");
				}
				System.out.println((j+1) + ". " + alphabet.charAt(((sum*10)-1)%26));
				continue;
			} else if(location>=21 && location <= 26){
				if((largestFactor(location)*12)%26 == 0){
					System.out.println((j+1) + ". Z");
				} else {
					System.out.println((j+1) + ". " + alphabet.charAt((((largestFactor(location))*12)%26)-1));
				}
			}
		
		}
		
		
	}
	
	static int largestFactor(int a){
		int input = a, largest = -1;
		for(int z = 1; z <= input/2;z++){
			if(input%z == 0 && z > largest){
				largest = z;
			}
		}
		
		return largest;
	}
}
