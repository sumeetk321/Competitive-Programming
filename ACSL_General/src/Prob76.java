import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Prob76 {

	public static void main(String[] args) throws FileNotFoundException {
		String string;
		File textfile = new File("sample.txt");
		Scanner scan = new Scanner(textfile);
		while(scan.hasNextLine()){
			string = scan.nextLine();
			if (string.startsWith("//")){
				System.out.println(string);
			} else if (string.startsWith("/*")){
				while(!(string.endsWith("*/"))){
					System.out.println(string);
					string = scan.nextLine();
				}
				System.out.println(string);
			} else if (string.startsWith("*/")){
				System.out.println(string);
			} else {
				continue;
			}
		}
	}
}
