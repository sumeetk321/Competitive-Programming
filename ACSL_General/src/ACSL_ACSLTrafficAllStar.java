import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_ACSLTrafficAllStar {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String in = scan.nextLine();
		String[] in1 = in.split(", ");
		String[][] grid = new String[5][5];
		boolean notsolved = true;
		int distance = 0;
		while (notsolved) {
			ArrayList<String> directionsallowed = new ArrayList<String>();
			if (Integer.parseInt(in1[0]) % 2 == 0) {
				directionsallowed.add("Up");
			} else if (Integer.parseInt(in1[0]) % 2 == 1) {
				directionsallowed.add("Down");
			} else if (Integer.parseInt(in1[1]) % 2 == 0) {
				directionsallowed.add("Right");
			} else if (Integer.parseInt(in1[1]) % 2 == 1) {
				directionsallowed.add("Left");
			}
			if (Integer.parseInt(in1[3]) < Integer.parseInt(in1[0])) {
				in1[0] = Integer.toString(Integer.parseInt(in1[0]) + 1);
				distance++;
				continue;
			}
		}
	}
}