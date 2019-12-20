import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HMSACSL {
	static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static ArrayList<String> hms = new ArrayList<String>(
			Arrays.asList("DL", "DO", "DH", "DU", "HD", "OD", "LD", "ALO", "ALU", "OU", "UL", "HL", "OL", "LL", "AHO",
					"UO", "HO", "OO", "LO", "UH", "HH", "LU", "OAH", "LAH", "OH", "OAL"));

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("HMSACSL.txt");
		Scanner scan = new Scanner(file);
		for (int i = 0; i < 5; i++) {
			String in = scan.nextLine();
			String[] inwords = in.split("#");
			for (String a : inwords) {
				String out = "";
				boolean solved = false;
				while (!solved) {
					for (String x : hms) {
						if (a.startsWith(x)) {
							out += alphabet.charAt(hms.indexOf(x));
							a = a.replaceFirst(x, "");
						}
					}
					if (a.length() == 0) {
						solved = true;
					}
				}
				System.out.print(out + " ");
			}
			System.out.println();
		}
		for(int i = 0; i < 5; i++){
			String in = scan.nextLine();
			String out = "";
			for(int j = 0; j < in.length(); j++){
				if(in.charAt(j)==' '){
					out+="#";
				} else {
					out+=hms.get(alphabet.indexOf(in.charAt(j)));
				}
			}
			System.out.println(out);
		}
	}

}
