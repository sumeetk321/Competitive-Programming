package ACSL_JuniorDivision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ACSL_Poker_IntermediateDivision {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String suita = null, suitb = null, suitc = null, suitd = null, suite = null;
		for(int i = 0; i < 5; i++){
			System.out.println("Enter 5 numbers to be tested:");
			int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt(), d = scan.nextInt(), e = scan.nextInt();
			
			if(a >= 1 && a <= 13){
				suita = "Diamonds";
			} else if(a >= 14 && a <= 26){
				a -= 13;
				suita = "Hearts";
			} else if(a >= 27 && a <= 39){
				a -= 26;
				suita = "Spades";
			} else if(a >= 40 && a <= 52){
				a -= 39;
				suita = "Clubs";
			}
			
			if(b >= 1 && b <= 13){
				suitb = "Diamonds";
			} else if(b >= 14 && b <= 26){
				b -= 13;
				suitb = "Hearts";
			} else if(b >= 27 && b <= 39){
				b -= 26;
				suitb = "Spades";
			} else if(b >= 40 && b <= 52){
				b -= 39;
				suitb = "Clubs";
			}
			if(c >= 1 && c <= 13){
				suitc = "Diamonds";
			} else if(c >= 14 && c <= 26){
				c -= 13;
				suitc = "Hearts";
			} else if(c >= 27 && c <= 39){
				c -= 26;
				suitc = "Spades";
			} else if(c >= 40 && c <= 52){
				c -= 39;
				suitc = "Clubs";
			}
			if(d >= 1 && d <= 13){
				suitd = "Diamonds";
			} else if(d >= 14 && d <= 26){
				d -= 13;
				suitd = "Hearts";
			} else if(d >= 27 && d <= 39){
				d -= 26;
				suitd = "Spades";
			} else if(d >= 40 && d <= 52){
				d -= 39;
				suitd = "Clubs";
			}
			if(e >= 1 && e <= 13){
				suite = "Diamonds";
			} else if(e >= 14 && e <= 26){
				e -= 13;
				suite = "Hearts";
			} else if(e >= 27 && e <= 39){
				e -= 26;
				suite = "Spades";
			} else if(e >= 40 && e <= 52){
				e -= 39;
				suite = "Clubs";
			}
			
			int[] ar = {a, b, c, d, e};
			int numequal = 1, temp;
			
			//System.out.println(a+" "+b+" "+c+" "+d+" "+e);
			boolean duplicate = false;
			for(int x = 0; x < 5; x++){
				temp = ar[x];
				for(int k = x+1; k < ar.length; k++){
					if(temp==ar[k%6]){
						numequal++;
						if(ar[0]==ar[4] || (ar[0]==ar[1] && ar[3]==ar[4]) || (ar[0]==ar[1] && ar[1]==ar[2])) duplicate = true;
						//System.out.println(numequal);
					}
					
				}
				
			}
			
			if(duplicate == true && numequal!=5){
				numequal--;
			}
			
			
			//System.out.println(numequal);
			
			if(suita.equals(suitb)&& suitb.equals(suitc) && suitc.equals(suitd) && suitd.equals(suite)){
				System.out.println("FLUSH");
				continue;
			}
			
			
			switch (numequal){
			case 1:
				System.out.println("NONE");
				break;
			case 2:
				if(a==b && c==d){
					System.out.println("TWO PAIRS");
				} else if(a==b && c==e){
					System.out.println("TWO PAIRS");
				} else if(a==b&& d==e){
					System.out.println("TWO PAIRS");
				} else if(b==c && d==e){
					System.out.println("TWO PAIRS");
				}else if(b==c && d==a){
					System.out.println("TWO PAIRS");
				} else if(b==c && e==a){
					System.out.println("TWO PAIRS");
				} else if(c==d&&e==a){
					System.out.println("TWO PAIRS");
				} else if(c==d&&e==b){
					System.out.println("TWO PAIRS");
				} else if(d==e&&a==c){
					System.out.println("TWO PAIRS");
				} else if(e==a && b==d){
					System.out.println("TWO PAIRS");
				} else{
					System.out.println("PAIR");
				}
				break; 
			case 3:
				System.out.println("THREE OF A KIND");
				 break;
			case 4:
				System.out.println("FOUR OF A KIND");
				break;
			case 5:
				if(a==b && d==e && a==d){
					System.out.println("FOUR OF A KIND");
				}else{
					System.out.println("FULL HOUSE");
				}
				break;
			case 6:
				System.out.println("FOUR OF A KIND");
				break;
			
			
		}
		
	}

}
}
