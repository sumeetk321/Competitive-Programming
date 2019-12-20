import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("RegExp.txt");
		Scanner scan = new Scanner(file);
		for (int a = 0; a < 2; a++) {
			String[] strs = scan.nextLine().split(", ");
			for (int i = 0; i < 5; i++) {
				Pattern p = Pattern.compile(scan.nextLine());
				int counter = 0;
				for (int j = 1; j < strs.length; j++) {
					Matcher m = p.matcher(strs[j]);
					if (m.matches()) {
						System.out.print(strs[j] + " ");
						counter++;
					}
				}
				if (counter == 0) {
					System.out.println("NONE");
				} else {
					System.out.println();
				}
			}
		}

	}

}
