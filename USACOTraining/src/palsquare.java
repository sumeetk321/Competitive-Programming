/*
ID: sumeetk1
LANG: JAVA
TASK: palsquare
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class palsquare {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		int B = Integer.parseInt(br.readLine());
		for(int i = 1; i <= 300; i++){
			String test1 = Integer.toString(i, B).toUpperCase();
			String test2 = Integer.toString((int)Math.pow(i, 2), B).toUpperCase();
			if(isPalindrome(test2)){
				out.println(test1+" "+test2);
			}
		}
		out.close();
		br.close();
	}
	public static boolean isPalindrome(String in){
		return (in.equals(new StringBuilder(in).reverse().toString()));
	}
}
