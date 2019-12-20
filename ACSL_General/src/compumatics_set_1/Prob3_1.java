package compumatics_set_1;

import java.util.Scanner;
/* Name of the class has to be "Main" only if the class is public. */
public class Prob3_1
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner a = new Scanner(System.in);
		System.out.println("Enter a number to be tested:");
		int n = a.nextInt();
 
		int j = 5;
		if (n <= 1){
			
		} else if (n <= 3){
			
		} else if (n % 2 == 0 || n % 3 == 0){
			System.out.println("Composite.");
			
		} else {
  
		while((j*j) <= n){
			if (n%j == 0 || n%(j+2) == 0){
				System.out.println("Composite.");
				
			}
			 
			j = j + 6;
		}
 
		System.out.println("Prime!");
		
	}
	}
}