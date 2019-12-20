package ACSL_JuniorDivision;

import java.util.Scanner;

public class ACSL_ACSLGolf_JuniorDivision {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int par, score, difference, total = 0;
		
		for(int i = 0; i < 4; i++){
			System.out.println("Enter par and score");
			par = scan.nextInt();
			score = scan.nextInt();
			difference = par - score;
			
			
			
			if(difference==-2){
				total += 2;
				System.out.println("double bogey");
			} else if(difference==-1){
				total += 1;
				System.out.println("bogey");
			} else if(difference==0){
				System.out.println("par");
			} else if(difference==1){
				total-=1;
				System.out.println("birdie");
			} else if(difference==2){
				total-=2;
				System.out.println("eagle");
			}
			
			if(i==3){
				if(total > 0){
					System.out.println(total + " over par" );
				} else if(total < 0){
					System.out.println(Math.abs(total) + " over par");
				} else if(total==0){
					System.out.println("par");
				}
			}
			
			
			
			
			
		}
		
	}

}
