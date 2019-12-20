import java.util.Scanner;

public class Prob55 {

	public static void main(String[] args) {
		
		Scanner a = new Scanner(System.in);
		String username = a.nextLine();
		String passwd = a.nextLine();
		
		String user1 = "gates";
		String pass1 = "monopoly";
		int priority1 = 1;
		
		String user2 = "joy";
		String pass2 = "sun";
		int priority2 = 4;
		
		String user3 = "jobs";
		String pass3 = "apple";
		int priority3 = 3;
		
		String user4 = "root";
		String pass4 = "secret";
		int priority4 = 5;
		
		String user5 = "quit";
		String pass5 = "exit";
		
		if (username .equals( user1)){
			if(passwd .equals( pass1)){
				System.out.println("You have logged on with priority " + priority1);
			} else {
				System.out.println("Logon Failed.");
			}
		} else if (username .equals( user2)){
			if(passwd .equals(pass2)){
				System.out.println("You have logged on with priority " + priority2);
			} else {
				System.out.println("Logon Failed.");
			}
		} else if (username.equals(user3)){
			if(passwd .equals( pass3)){
				System.out.println("You have logged on with priority " + priority3);
			} else {
				System.out.println("Logon Failed.");
			}
		} else if (username .equals( user4)){
			if(passwd .equals( pass4)){
				System.out.println("You have logged on with priority " + priority4);
			} else {
				System.out.println("Logon Failed.");
			}
		} else if (username .equals( user5)){
			if(passwd .equals( pass4)){
				System.out.println("System shutting down");
				System.exit(0);
			} else {
				System.out.println("Logon Failed.");
			}
		} else {
			System.out.println("Logon Failed.");
		}
		a.close();
	}

}
