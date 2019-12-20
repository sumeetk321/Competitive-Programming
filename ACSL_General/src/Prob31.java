import java.util.Scanner;

public class Prob31 {
	public static void main(String[] args){
		System.out.println("Welcome to Yertle's Quest!");
		Scanner a = new Scanner(System.in);
		System.out.println("Enter the name of your character: ");
		String name = a.nextLine();
		
		Scanner b = new Scanner(System.in);
		System.out.println("Enter strength (1 - 10)");
		int strength = b.nextInt();
		
		Scanner c = new Scanner(System.in);
		System.out.println("Enter health (1 - 10)");
		int health = c.nextInt();
		
		Scanner d = new Scanner(System.in);
		System.out.println("Enter luck (1 - 10)");
		int luck = d.nextInt();
		
		if(strength+health+luck>15){
			strength = 5;
			health = 5;
			luck = 5;
			System.out.println("You have given your character too many points! Default values have been assigned:\n" + name + ", strength: " + strength + ", health: " + health + ", luck: " + luck);
		} else if(strength+health+luck<=15){
			System.out.println("Here are the values for your character:\n" + name + ", strength: " + strength + ", health: " + health + ", luck: " + luck);

		}
		
		
	}
}