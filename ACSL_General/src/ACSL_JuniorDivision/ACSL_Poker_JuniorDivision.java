package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ACSL_Poker_JuniorDivision {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < 5; i++){
			System.out.println("Enter 5 numbers to be tested: ");
			int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt(), d = scan.nextInt(), e = scan.nextInt();

			if(a >= 14 && a <= 26){
				a -= 13;
			} else if(a >= 27 && a <= 39){
				a -= 26;
			} else if(a >= 40 && a <= 52){
				a -= 39;
			}
			
			if(b >= 14 && b <= 26){
				b -= 13;
			} else if(b >= 27 && b <= 39){
				b -= 26;
			} else if(b >= 40 && b <= 52){
				b -= 39;
			}
			
			if(c >= 14 && c <= 26){
				c -= 13;
			} else if(c >= 27 && c <= 39){
				c -= 26;
			} else if(c >= 40 && c <= 52){
				c -= 39;
			}
			
			if(d >= 14 && d <= 26){
				d -= 13;
			} else if(d >= 27 && d <= 39){
				d -= 26;
			} else if(d >= 40 && d <= 52){
				d -= 39;
			}
			
			if(e >= 14 && e <= 26){
				e -= 13;
			} else if(e >= 27 && e <= 39){
				e -= 26;
			} else if(e >= 40 && e <= 52){
				e -= 39;
			}
			
			int[] ar = {a, b, c, d, e};
			int numequal = 1;
			
			Arrays.sort(ar);
			System.out.println(a+" " + b+" "+ c +" "+d+" " +e);
			
			count:
				{ if(ar[0]==ar[1]){
				numequal++;
				if(ar[0]==ar[2]){
					numequal++;
					if(ar[0]==ar[3]){
						numequal++;
						if(ar[0]==ar[4]){
							numequal++;
							break count;
						}
					}
				}
			}
				
				if(ar[0]==ar[2]){
					numequal++;
					if(ar[0]==ar[3]){
						numequal++;
						if(ar[0]==ar[4]){
							numequal++;
						}
					}
				}
				if(ar[0]==ar[3]){
					numequal++;
					if(ar[0]==ar[4]){
						numequal++;
					}
				}
				
				if(ar[0]==ar[4]){
					numequal++;
				}
			
			if(ar[1]==ar[2]){
				numequal++;
				if(ar[1]==ar[3]){
					numequal++;
					if(ar[1]==ar[4]){
						numequal++;
						break;
					}
				}
			}
			
			if(ar[2]==ar[3]){
				numequal++;
				if(ar[2]==ar[4]){
					numequal++;
				}
			}
			
			if(ar[3]==ar[4]){
				numequal++;
				break count;
			}
			
			}
			
			
			System.out.println(numequal);
			
			switch (numequal){
			case 2:
				System.out.println("PAIR");
				break;
			case 3:
				System.out.println("THREE OF A KIND");
				break;
			case 4:
				System.out.println("FOUR OF A KIND");
				break;
			case 5:
				System.out.println("FULL HOUSE");
				break;
			case 1:
				System.out.println("NONE");
				break;
			
			}
			
			
		
		}
		
	}
		
}
