import java.util.Scanner;

public class Prob62 {

	public static void main(String[] args) {
		double guessnum = Math.round((Math.random()*10));
		System.out.println("I am thinking of a number from 1 to 10. You must guess what it is in three tries.");
		Scanner a = new Scanner(System.in);
		int in1 = a.nextInt();
		if(in1==guessnum){
			System.out.println("Correct! " + in1 + " was the number!");
			System.exit(0);
		} else if (in1!=guessnum || in1 >= guessnum-2 && in1 <= guessnum+2){
			System.out.println("Wrong, but warm. Try again.");
			int in2 = a.nextInt();
			if(in2==guessnum){
				System.out.println("Correct! " + in2 + " was the number!");
				System.exit(0);
			} else {
				System.out.println("Wrong. Try again.");
				int in3 = a.nextInt();
				if(in3==guessnum){
					System.out.println("Correct! " + in3 + " was the number!");
					System.exit(0);
				} else {
					System.out.println("The correct number was " + (int) guessnum + ". You have lost the game.");
					System.exit(0);
				}
			}
		}
	}

}
