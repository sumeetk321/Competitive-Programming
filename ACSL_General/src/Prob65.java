import java.util.*;


public class Prob65 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int digits = 0;
		
		while (digits < 5 )
		{
			System.out.println("Your password must have at least 5 characters.");
			System.out.println("How many characters do you want in your password?");
			digits = scan.nextInt();
		}
		
		String choices = "abcdefghijklmnopqrstuvwxyz";
		choices = choices + choices.toUpperCase();
		choices = choices + "1234567890";
		
		String password = "";
		int j = 0;
		while (j<digits)
		{
			password = password + choices.charAt(rand.nextInt(choices.length()));
			j = j + 1;
		}
		System.out.println("Here is your password: " + password);
	}

}
