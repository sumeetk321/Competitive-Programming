import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
ID: sumeetk1
LANG: JAVA
TASK: palsquare
 */
public class palsquare {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		int base = Integer.parseInt(br.readLine());
		int nums = 0;
		for(int i = 1; i <= 300; i++){
			if(Integer.toString((int) Math.pow(i, 2), base).equals(new StringBuilder(Integer.toString((int) Math.pow(i, 2), base)).reverse().toString())){
				out.println(Integer.toString(i, base).toUpperCase()+" "+Integer.toString((int) Math.pow(i, 2), base).toUpperCase());
			}
		}
		out.close();
		br.close();
		
	}

}
