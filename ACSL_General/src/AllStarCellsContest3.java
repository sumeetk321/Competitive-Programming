import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AllStarCellsContest3 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("AllStarCells1.txt");
		Scanner scan = new Scanner(file);
		String x = scan.nextLine();
		String y = scan.nextLine();
		String z = scan.nextLine();
		
	}

	public static String divide(String in) {
		String[] out = new String[2];
		String str1 = "";
		String str2 = "";
		str1 = in.substring(0, 4);
		str2 = in.substring(4, 8);
		out[0] = str1 + str1;
		out[1] = str2 + str2;
		return out[0] + " and " + out[1];
	}

	public static String add(String in, int n) {
		String str = in.substring(0, n);
		String out = "";
		out = out + str;
		out = out + str;
		out = out + in.substring(n, 8 - n);
		return out;
	}

	public static String subtract(String in, int n) {
		String out = in.substring(n);
		String rep = in.substring(8 - n, 8);
		char[] darn = rep.toCharArray();
		Arrays.sort(darn);
		for (int i = 0; i < darn.length; i++) {
			out += darn[i];
		}
		return out;
	}

	public static String union(String str1, String str2) {
		String concat2 = str2.substring(0, 4);
		char[] concat2array = concat2.toCharArray();
		Arrays.sort(concat2array);
		String concat1 = str1.substring(4);
		char[] concat1array = concat1.toCharArray();
		Arrays.sort(concat1array);
		concat1 = "";
		concat2 = "";
		for (int i = 0; i < 4; i++) {

			concat1 += concat1array[i];
			concat2 += concat2array[i];

		}
		return concat1 + concat2;
	}

	public static String intersect(String str1, String str2) {
		String grp1 = str1.substring(0, 2);

		String grp2 = str1.substring(6);
		char[] darn1 = (grp1 + grp2).toCharArray();
		Arrays.sort(darn1);
		String grp3 = str2.substring(0, 2);
		String grp4 = str2.substring(6);
		char[] darn2 = (grp3 + grp4).toCharArray();
		Arrays.sort(darn2);
		return darn1[0]+""+darn1[1]+""+darn1[2]+""+darn1[3]+""+darn2[0]+""+darn2[1]+""+darn2[2]+""+darn2[3];
	}
	
	public static String align(String in){
		char[] out = in.toCharArray();
		Arrays.sort(out);
		String out1 = "";
		for(int i = 7; i > -1; i--){
			out1+=out[i];
		}
		return out1;
			
	}

}
