import java.math.BigInteger;
import java.util.Scanner;

public class ValidNumber {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(isNumber(scan.nextLine()));
	}

	public static boolean isNumber(String s) {

		s = s.trim();
		try {
			if (s.contains(".")) {
				String pos = s.substring(0, s.indexOf("."));
				String frac = s.substring(s.indexOf(".") + 1, s.length());
				Long.parseLong(pos);
				Long.parseLong(frac);
				return true;
			} else {
				if(s.matches(".*[0-9].*")){
				for (int j = 2; j <= 16; j++) {
					try {
						long test = new BigInteger(s, j).longValue();
						return true;
					} catch (Exception e) {
						continue;
					}
				}
				return false;
				} else {
					return false;
				}
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}
}