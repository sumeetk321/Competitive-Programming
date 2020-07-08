/*
ID: sumeetk1
LANG: JAVA
TASK: namenum
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class namenum {
	final static String[][] code = { { "" }, { "" }, { "A", "B", "C" }, { "D", "E", "F" }, { "G", "H", "I" },
			{ "J", "K", "L" }, { "M", "N", "O" }, { "P", "R", "S" }, { "T", "U", "V" }, { "W", "X", "Y" } };
	static boolean hasName = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("namenum.in"));
		BufferedReader dictreader = new BufferedReader(new FileReader("dict.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		String[] dict = new String[4617];
		for (int i = 0; i < 4617; i++) {
			dict[i] = dictreader.readLine();
		}
		String num = br.readLine();
		tryPossibles(num, "", dict, num.length(), out);
		if(!hasName){
			out.println("NONE");
		}
		out.close();
		dictreader.close();
		br.close();
	}

	public static void tryPossibles(String num, String test, String[] dict, int depth, PrintWriter out) {
		int testnum = Character.getNumericValue(num.charAt(num.length() - depth));
		for (int i = 0; i < 3; i++) {
			test += code[testnum][i];
			if (depth == 1) {
				if(Arrays.binarySearch(dict, test)>=0){
					hasName = true;
					out.println(test);
				}
			} else {
				tryPossibles(num, test, dict, depth - 1, out);
			}
			test = test.substring(0, test.length() - 1);
		}

	}

}
