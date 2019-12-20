package compumatics_set_1;

import java.util.Scanner;

public class Prob3 {

	

	public static void main(String[] args) {
		long i = 2;
		long input = 600851475143l;
		long factors = 2;
		
		while(true){
			
			if (input%i == 0){
				factors++;
				if(isPrime(i)==true){
					System.out.println(i);
				}
			}
			
			
			i++;
			
		}
		
	}
	static long input;
	private static boolean isPrime(long a) {
		input = a;
		long i = 2;
		long factors = 2;
		
		while(i <= input){
			
			if (input%i == 0){
				factors++;
			}
			
			if (i>(input/2)){
				if (factors==2){
					return true;
				} else {
					return false;
				}
			}
			i++;
			
		}
		return false;
		
		
	}

}
