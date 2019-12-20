import java.util.Scanner;

public class Prob69 {

	public static void main(String[] args) {
		String player1, player2;
		int j =0;
		Scanner scan = new Scanner(System.in);
		System.out.println("How many rounds?");
		int rounds = scan.nextInt();
		System.out.println("First player, sign in.");
		player1 = scan.next();
		System.out.println("Second player, sign in");
		player2 = scan.next();
		
		while(j < rounds){
			double rand = Math.random();
			double guessnum = rand*100;
			double sqrtguessnum = Math.sqrt(guessnum);
			System.out.println("What is the square root of " + guessnum);
			System.out.println(player1 + ", your guess: ");
			double player1guess = scan.nextDouble();
			System.out.println(player2 + ", your guess: ");
			double player2guess = scan.nextDouble();
			if(Math.abs(sqrtguessnum - player1guess) > Math.abs(sqrtguessnum - player2guess)){
				System.out.println("The correct answer: " + sqrtguessnum);
				System.out.println(player1 + " is " + Math.abs(sqrtguessnum - player1guess) + " away.");
				System.out.println(player2 + " is " + Math.abs(sqrtguessnum - player2guess) + " away.");
				System.out.println(player2 + " wins!");
			} else if(Math.abs(sqrtguessnum - player1guess) < Math.abs(sqrtguessnum - player2guess)){
				System.out.println("The correct answer: " + sqrtguessnum);
				System.out.println(player1 + " is " + Math.abs(sqrtguessnum - player1guess) + " away.");
				System.out.println(player2 + " is " + Math.abs(sqrtguessnum - player2guess) + " away.");
				System.out.println(player1 + " wins!");
			}
			j++;
		}
		
		System.exit(0);
		
		
	}

}
