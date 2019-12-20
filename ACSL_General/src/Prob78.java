import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Prob78 {

	public static void main(String[] args) throws FileNotFoundException {
		File textfile = new File("SecretCode.txt");
		
		Scanner scan = new Scanner(textfile);
		String message = scan.nextLine();
		while(scan.hasNext()){
			String code = scan.next();
			System.out.print(message.charAt(Integer.parseInt(code.trim())));
		}
	}

}
