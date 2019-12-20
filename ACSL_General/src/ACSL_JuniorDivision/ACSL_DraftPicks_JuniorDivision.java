package ACSL_JuniorDivision;

import java.util.Scanner;

public class ACSL_DraftPicks_JuniorDivision {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		double contractworth, avgsal = 0, avgsal16 = 0, avgsal18 = 0, lowestsal = Double.MAX_VALUE, highestsal = 0, range;
		int salm10mil = 0, contractlength;
		
		for(int i = 0; i < 5; i++){
			System.out.println("Enter contract length and contract worth");
			contractlength = scan.nextInt();
			contractworth = scan.nextDouble();
			avgsal+=(contractworth/contractlength)*1000000;
			avgsal16+=((contractworth/contractlength)*1000000)/16;
			avgsal18+=((contractworth/contractlength)*1000000)/18;
			if(contractworth/contractlength > 10){
				salm10mil+=1;
			}
			
			if(((contractworth/contractlength)*1000000)/16 < lowestsal){
				lowestsal = (((contractworth/contractlength)*1000000)/16);
			}
			
			if(((contractworth/contractlength)*1000000)/18 > highestsal){
				highestsal = (((contractworth/contractlength)*1000000)/18);
			}
			
			
		}
		
		range = Math.abs(Math.round((Math.round(avgsal18/5) - (Math.round(avgsal16/5)))));
		
		
		System.out.println(salm10mil);
		System.out.println(Math.round((avgsal)/5));
		System.out.println(Math.round(lowestsal));
		System.out.println(Math.round(highestsal));
		System.out.println(Math.round(range));
		
	}

}
