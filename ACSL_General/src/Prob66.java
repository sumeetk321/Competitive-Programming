import java.util.Random;
import java.util.Scanner;

public class Prob66 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String usrpasswd = scan.next();
		
		Random rand = new Random();
		String choices = "abcdefghijklmnopqrstuvwxyz";

		long guesses = 0;
		
		//String guesspasswd = "";
		
		while(true){
			String guesspasswd = "";
			int j = 0;
			while(j < usrpasswd.length()){
				guesspasswd = guesspasswd + choices.charAt(rand.nextInt(choices.length()));
				System.out.println();
				guesses++;
				j++;
			}
			
			if(guesspasswd.equals(usrpasswd)){
				System.out.println("Your password: " + guesspasswd + "\tIt took + " + guesses + " guesses to guess your password.");
				break;
			}
			
			
		}
	}
}
