import java.util.Scanner;

public class Prob72 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in)
;
		String input = scan.nextLine();
		
		int j = 0;
		
		while(j < (input.length())){
			System.out.println(input.charAt(j));
			j++;
		}
		
	}

}
