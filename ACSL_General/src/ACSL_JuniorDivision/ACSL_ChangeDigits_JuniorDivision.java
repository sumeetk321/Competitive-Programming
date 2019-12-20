package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ACSL_ChangeDigits_JuniorDivision {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("ACSL_2003_2004_JuniorDivision.txt");
		Scanner scan = new Scanner(file);
		int i = 0;
		
		int[] values = new int[5];
		while(scan.hasNextLine()){
			values[i] = scan.nextInt();
			i++;
		}
		
		for(i = 0; i < values.length; i++){
			String test = Integer.toString(values[i]);
			char largest = 0;
			int largestint = 0;
			for(int j = 0; j < test.length(); j++){
				if(Character.getNumericValue(test.charAt(j)) > largestint){
					largest = test.charAt(j);
					largestint = Character.getNumericValue(largest);
				}
			}
			
			
			double x = 4*(Math.pow(10, test.length()-(test.indexOf(largest)+1)));
			if(test.indexOf(largest)!=(test.lastIndexOf(largest)) ){
				
				if(largestint % 2 == 0){
					if(largestint+4<=9){
						values[i] = (int) (values[i] + x);
						System.out.println(values[i]);
						continue;
					} else if(largestint==6){
						values[i] = (int) (values[i] - 6*(Math.pow(10, test.length()-(test.indexOf(largest)+1))));
						System.out.println(values[i]);
						continue;
					} else if(largestint==8){
						values[i] = (int) ((int) values[i] - 6*(Math.pow(10, test.length()-(test.indexOf(largest)+1)))) ;
						System.out.println(values[i]);
						continue;
					} 
				} else {
					if(test.indexOf(largest)==0){
						values[i] = (int) (values[i] - largestint*(Math.pow(10, test.length()-1)));
						System.out.println(values[i]);
						continue;
					} else if(test.indexOf(largest)==test.length()-1){
						values[i] = values[i] - largestint;
						System.out.println(values[i]);
						continue;
					} else {
						values[i] = (int) (values[i] - largestint*(Math.pow(10, test.indexOf(largest)+1)));
						System.out.println(values[i]);
						continue;
					}
				}
			} else {
				if(largestint % 2 == 0){
					if(largestint + 4 <= 9){
						values[i] = (int) (values[i] + x);
						System.out.println(values[i]);
						continue;
					} else if(largestint==6){
						values[i] = (int) (values[i] - 6*(Math.pow(10, test.length()-(test.indexOf(largest)+1))));
						System.out.println(values[i]);
						continue;
					} else if(largestint==8){
						values[i] = (int) (values[i] - 6*(Math.pow(10, test.length()-(test.indexOf(largest)+1)))) ;
						System.out.println(values[i]);
						continue;
					} 
				} else {
					if(test.indexOf(largest)==0){
						values[i] = (int) (values[i] - largestint*(Math.pow(10, test.length()-1)));
						System.out.println(values[i]);
						continue;
					} else if(test.indexOf(largest)==test.length()-1){
						values[i] = values[i] - largestint;
						System.out.println(values[i]);
						continue;
					} else {
						values[i] = (int) (values[i] - largestint*(Math.pow(10, test.indexOf(largest))));
						System.out.println(values[i]);
						continue;
					}
				}
			}
		}
		
	}

}
