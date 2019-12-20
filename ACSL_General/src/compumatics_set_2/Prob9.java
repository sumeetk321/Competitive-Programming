package compumatics_set_2;

import java.math.BigInteger;

public class Prob9 {

	public static void main(String[] args) {
		int regularyear = 31+28+31+30+31+30+31+31+30+31+30+31;
		int leapyear = 31+29+31+30+31+30+31+31+30+31+30+31;
		//first day is tuesday
		int day = 2;
		int dayval = 1;
		int year;
		int sundays = 0;
		for(int i = 0; i < 100; i++){
			year = i+1901;
			//jan
			if(day==0) sundays++;
			for(int j = 0; j < 32; j++){
				day++;
				System.out.println(day);
				day%=7;
			}
			
			System.out.println("FEB: "+i+"" + day);
			//feb
			if(day==0) sundays++;
			if(i%4==0 || i==2000){
				for(int j = 0; j < 30; j++){
					day++;
					day%=7;
				}
			} else {
				for(int j = 0; j < 29; j++){
					day++;
					day%=7;
				}
			}
			//mar
			if(day==0) sundays++;
			for(int j = 0; j < 32; j++){
				day++;
				day%=7;
			}
			//apr
			if(day==0) sundays++;
			for(int j = 0; j < 31; j++){
				day++;
				day%=7;
			}
			//may
			if(day==0) sundays++;
			for(int j = 0; j < 32; j++){
				day++;
				day%=7;
			}
			//jun
			if(day==0) sundays++;
			for(int j = 0; j < 31; j++){
				day++;
				day%=7;
			}
			//jul
			if(day==0) sundays++;
			for(int j = 0; j < 32; j++){
				day++;
				day%=7;
			}
			//aug
			if(day==0) sundays++;
			for(int j = 0; j < 32; j++){
				day++;
				day%=7;
			}
			//sep
			if(day==0) sundays++;
			for(int j = 0; j < 31; j++){
				day++;
				day%=7;
			}
			//oct
			if(day==0) sundays++;
			for(int j = 0; j < 32; j++){
				day++;
				day%=7;
			}
			//nov
			if(day==0) sundays++;
			for(int j = 0; j < 31; j++){
				day++;
				day%=7;
			}
			//dec
			if(day==0) sundays++;
			for(int j = 0; j < 32; j++){
				day++;
				day%=7;
			}
			
		}
		System.out.println(sundays);
	}

}
