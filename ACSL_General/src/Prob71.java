import java.util.Scanner;

public class Prob71 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		String realname = name.trim();
		
		String space = "";
		
		int spaceposition = realname.indexOf(space);
		String lastname = realname.substring(spaceposition);
		String firstname = realname.substring(0, spaceposition);
		String change = lastname.toUpperCase();
		System.out.println(firstname + " " + change);
		
	}

}
