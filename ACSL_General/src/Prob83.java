import java.util.Scanner;

public class Prob83 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean isValid = false;
		while(isValid==false){
			System.out.println("input file: ");
			String input = scan.nextLine();
			if(!input.endsWith(".dat")){
				System.out.println(">>>file name must end with .dat<<<");
			} else if(input.contains(" ")){
				System.out.println(">>>file name must not contain spaces<<<");
			} else if (input==".dat"){
				System.out.println(">>>file name missing<<<");
			} else {
				System.out.println("OK");
				isValid=true;
			}
		}
	}

}
