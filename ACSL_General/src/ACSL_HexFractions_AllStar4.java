import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_HexFractions_AllStar4 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("HexFractions2.txt");
		Scanner scan = new Scanner(file);

		for (int i = 0; i < 10; i++) {
			double x = scan.nextDouble();
			String tmp = ".";
			int j = 0;

			while (x != 0.0 && j != 10) {
				x *= 16;
				if (x > 1) {
					if ((int) x > 9) {
						switch ((int) x) {
						case 10:
							tmp = tmp + "A";
							break;
						case 11:
							tmp = tmp + "B";
							break;
						case 12:
							tmp = tmp + "C";
							break;
						case 13:
							tmp = tmp + "D";
							break;
						case 14:
							tmp = tmp + "E";
							break;
						case 15:
							tmp = tmp + "F";
							break;
						}
					} else {
						tmp = tmp + Integer.toString((int) x);
					}

					x = x - ((int) x);

				} else {
					if ((int) x > 9) {
						switch ((int) x) {
						case 10:
							tmp = tmp + "A";
							break;
						case 11:
							tmp = tmp + "B";
							break;
						case 12:
							tmp = tmp + "C";
							break;
						case 13:
							tmp = tmp + "D";
							break;
						case 14:
							tmp = tmp + "E";
							break;
						case 15:
							tmp = tmp + "F";
							break;
						}
					} else {
						tmp = tmp + Integer.toString((int) x);
					}
				}

				j++;
			}
			System.out.println(pattern(tmp));

		}
	}

	public static String pattern(String in) {
		int j = 0, notflagged = 0;
		String out = in;
		boolean flagged = false;
		String tmp = "";
		ArrayList<String> chars = new ArrayList<String>();
		for (int i = 0; i < out.length(); i++) {

			if (flagged) {
				if (chars.contains(out.charAt(i) + "")) {

					j++;
					if (j == 3) {
						chars.remove(chars.size() - 1);
						break;
					} else {
						chars.add(out.charAt(i) + "");
						continue;
					}
				} else {
					flagged = false;

					j = 0;
				}
			}

			if (chars.contains(out.charAt(i) + "")) {
				j++;
				flagged = true;
			}
			chars.add(out.charAt(i) + "");

		}
		if(chars.size()<10 && flagged) chars.remove(chars.size()-1);
		for (int i = 0; i < chars.size(); i++) {
			tmp += chars.get(i);
		}
		return tmp;
	}

}
