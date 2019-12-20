import java.util.Scanner;

public class Prob52 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int lowr = a.nextInt();
		
		//Scanner b = new Scanner(System.in);
		int highr = a.nextInt();
		int j = 0;
		int k = 0;
		for(int i = 0; i < 999999; i++){
			//Scanner c = new Scanner(System.in);
			int input = a.nextInt();
			
			
			if (input == 0){
				System.out.println("Sum of in-range values: " + j);
				System.out.println("Sum of out-of-range values: " + k);
				System.exit(0);
			}
			else if(input <= highr && input >= lowr){
				j = j + input;
			} else if (input > highr || input < lowr){
				k = k + input;
			} 
			
		}
	}

}
