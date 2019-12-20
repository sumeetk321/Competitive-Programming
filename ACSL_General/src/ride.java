
/*
ID: sumeetk1
LANG: JAVA
TASK: ride
 */

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ride {

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

		int m1 = 1, m2 = 1;

		String s1 = scan.nextLine();
		String s2 = scan.nextLine();
		for (int i = 0; i < s1.length(); i++) {
			m1 *= Character.getNumericValue(s1.charAt(i)) - 9;
		}
		for (int i = 0; i < s2.length(); i++) {
			m2 *= Character.getNumericValue(s2.charAt(i)) - 9;
		}

		if (m1 % 47 == m2 % 47) {
			out.println("GO");
		} else {
			out.println("STAY");
		}

		out.close();
		scan.close();

	}

}
