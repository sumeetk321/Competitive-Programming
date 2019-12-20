package ACSL_JuniorDivision;

import java.util.Scanner;

public class ACSL_TimeSheets_JuniorDivision {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int location, sum = 0;
		double rate = 0, salary = 0;
		String startingtime;
		String endingtime;
		for(int i = 0; i < 4; i++){
			System.out.println("Enter location, start time, and end time.");
			location = scan.nextInt();
			startingtime = scan.next();
			endingtime = scan.next();
			
			
			
			if(startingtime.equals("A")){
				startingtime = "10";
			} else if(startingtime.equals("B")){
				startingtime = "11";
			} else if(startingtime.equals("C")){
				startingtime = "12";
			} else if(startingtime.equals("D")){
				startingtime = "13";
			} else if(startingtime.equals("E")){
				startingtime = "14";
			} else if(startingtime.equals("F")){
				startingtime = "15";
			} else if(startingtime.equals("F")){
				startingtime = "16";
			} else if(startingtime.equals("G")){
				startingtime = "17";
			} else if(startingtime.equals("H")){
				startingtime = "18";
			}
			
			if(endingtime.equals("A")){
				endingtime = "10";
			} else if(endingtime.equals("B")){
				endingtime = "11";
			} else if(endingtime.equals("C")){
				endingtime = "12";
			} else if(endingtime.equals("D")){
				endingtime = "13";
			} else if(endingtime.equals("E")){
				endingtime = "14";
			} else if(endingtime.equals("F")){
				endingtime = "15";
			} else if(endingtime.equals("F")){
				endingtime = "16";
			} else if(endingtime.equals("G")){
				endingtime = "17";
			} else if(endingtime.equals("H")){
				endingtime = "18";
			}
			
			
			
			if(location>=1 && location <= 9){
				rate = 10.00;
				salary = ((Double.parseDouble(endingtime) - Double.parseDouble(startingtime) - 1)/2)*rate;

			} else if(location>=10 && location<=19){
				rate = 8.00;
				if((Double.parseDouble(endingtime) - Double.parseDouble(startingtime))/2 > 4){
					salary = (((Double.parseDouble(endingtime) - Double.parseDouble(startingtime))/2)-4)*12 + (4*rate);
				} else {
					salary = ((Double.parseDouble(endingtime) - Double.parseDouble(startingtime))/2)*rate;
				}
			} else if(location>=20 && location<=29){
				rate = 12.00;
				if((Double.parseDouble(endingtime) - Double.parseDouble(startingtime) - 1)/2 > 4){
					salary = (((Double.parseDouble(endingtime) - Double.parseDouble(startingtime) - 1)/2)-4)*(rate*2)+ (4*rate);
				} else {
					salary = ((Double.parseDouble(endingtime) - Double.parseDouble(startingtime))/2)*rate;
				}
			}
			
			
			System.out.println("$"+((double) salary));
			sum+=salary;
		}
		
		System.out.println("$" + sum);
		
	}

}
