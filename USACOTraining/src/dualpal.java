import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
/*
ID: sumeetk1
LANG: JAVA
TASK: dualpal
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class dualpal {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int counter = S+1, total = 0;
		while(total<N){
			if(isDualPalindrome(counter)){
				out.println(counter);
				total++;
			}
			counter++;
		}
		out.close();
	}

	public static boolean isPalindrome(String in) {
		return (in.equals(new StringBuilder(in).reverse().toString()));
	}

	public static boolean isDualPalindrome(int in) {
		for (int i = 2; i <= 10; i++) {
			for (int j = i+1; j <= 10; j++) {
				String test1 = Integer.toString(in, i);
				String test2 = Integer.toString(in, j);
				if(isPalindrome(test1)&&isPalindrome(test2)){
					return true;
				}
			}
		}
		return false;
	}
}
