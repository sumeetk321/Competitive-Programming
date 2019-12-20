package compumatics_set_3;

import java.math.BigInteger;

public class Prob6 {

	public static void main(String[] args) {
		int longest = -1;
		for (int i = 3; i <= 1000; i+=2) {
			
			if(RepeatingString(Double.toString((double) 1/i)).length()>longest) {
				longest = i;
				System.out.println(Double.toString((double) 1/i)+" "+RepeatingString(Double.toString((double) 1/i)).length());
				continue;
			}
		}
		System.out.println(longest);
	}

	public static String RepeatingString(String x) {
		String tmp = x;
		double y = Double.parseDouble(x);
		x = x.substring(2, x.length());
		int offset = 0;
		while (offset < x.length()) {
			String out = "";
			for (int i = offset; i < x.length(); i++) {
				out += x.charAt(i);
				if (i != 0 && out.charAt(0) == x.charAt(i)) {
					if (i+out.length() < x.length() && out.equals(x.substring(i, i + out.length()))) {
						return out.substring(0, out.length() - 1);
					} else
						continue;
				}
			}
			offset++;
		}
		return "";

	}

}
