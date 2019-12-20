import java.util.Scanner;

public class Prob73 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a name:");
		String input = scan.nextLine();
		while(input.length()>0){
			if(input.startsWith("Amy")){
				System.out.println("Ms. " + input);
				input = scan.nextLine();
			} else if(input.startsWith("Buffy")){
				System.out.println("Ms. " + input);
				input = scan.nextLine();
			} else if(input.startsWith("Cathy")){
				System.out.println("Ms. " + input);
				input = scan.nextLine();
			} else if(input.startsWith("Elroy")){
				System.out.println("Mr. " + input);
				input = scan.nextLine();
			} else if(input.startsWith("Fred")){
				System.out.println("Mr. " + input);
				input = scan.nextLine();
			} else if(input.startsWith("Graham")){
				System.out.println("Mr. " + input);
				input = scan.nextLine();
			} else {
				System.out.println(input);
				input = scan.nextLine();
			}
		}
		
		
	}

}
