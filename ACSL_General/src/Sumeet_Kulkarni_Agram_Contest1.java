
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sumeet_Kulkarni_Agram_Contest1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			System.out.println("Enter input: ");
			ArrayList<Integer> vals = new ArrayList<Integer>();
			String[] in = scan.nextLine().split(", ");
			String suit = in[1];
			int opval = Integer.parseInt(in[0]);
			int lowestval = 0;
			for (int j = 3; j < in.length; j += 2) {
				if (suit.equals(in[j])) {
					vals.add(Integer.parseInt(in[j - 1]));
				}
			}
			if (vals.size() == 0) {
				System.out.println("NONE");
				continue;
			}
			Collections.sort(vals);

			for (int x = 0; x < vals.size(); x++) {
				if (vals.get(x) > opval) {
					lowestval = vals.get(x);
					break;
				}

			}
			if (lowestval == 0) {
				lowestval = vals.get(0);
			}

			System.out.println(lowestval + ", " + suit);

		}
	}

}
