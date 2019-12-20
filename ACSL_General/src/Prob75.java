import java.util.Scanner;

public class Prob75 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		
		while(line.length()>0){
			if(line.startsWith("//")==true){
				System.out.println(line);
				line = scan.nextLine();
			} else {
				line = scan.nextLine();
			}
		}
		
	}

}
