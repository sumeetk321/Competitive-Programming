/*
ID: sumeetk1
LANG: JAVA
TASK: skidesign
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class skidesign {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("skidesign.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
		int n = Integer.parseInt(br.readLine());
		int[] hills = new int[n];
		for (int i = 0; i < n; i++) {
			hills[i] = Integer.parseInt(br.readLine());
		}
		int mincost = Integer.MAX_VALUE;
		for (int i = 0; i <= 83; i++) {
			int tmpcost = 0;
			for (int x : hills) {
				if (x < i) {
					tmpcost += Math.pow(i - x, 2);
				} else if (x > i + 17) {
					tmpcost += Math.pow(x - i - 17, 2);
				}
			}
			mincost = Math.min(mincost, tmpcost);
		}
		out.println(mincost);
		out.close();
	}

}
