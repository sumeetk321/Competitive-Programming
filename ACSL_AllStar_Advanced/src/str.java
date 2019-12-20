import java.text.DecimalFormat;
import java.util.*;

public class str {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Scanner scan = new Scanner(System.in);
		for (int x = 0; x < 10; x++) {
			String[] in = scan.nextLine().split(", ");
			double exp = Double.parseDouble(in[0]);
			int length = (in.length >= 2) ? Integer.parseInt(in[1]) : 10;
			int decimal = (in.length == 3) ? Integer.parseInt(in[2]) : 0;
			if (decimal >= length) System.out.println("ERROR");
			else print(exp, length, decimal);
		}
		scan.close();
	}

	private static void print(double exp, int length, int decimal) {
		String format = "#####";
		for (int i = 0; i < decimal; i++) {
			if (i == 0) format += ".";
			format += "0";
		}
		DecimalFormat df = new DecimalFormat(format);
		if (exp >= 0) exp = (Math.round(exp * Math.pow(10, decimal))) / Math.pow(10, decimal);
		else exp = -(Math.round(Math.abs(exp) * Math.pow(10, decimal))) / Math.pow(10, decimal);
		String ans = df.format(exp);
		if (length >= ans.length()) {
			while (ans.length() < length) ans = "#" + ans;
			System.out.println(ans);
		}
		else {
			String ans1 = "";
			int count = 0;
			for (int i = ans.length() - 1; count < length; i--, count++) {
				if (ans.charAt(i) == '.') ans1 = '.' + ans1;
				else ans1 = '#' + ans1;
			}
			System.out.println(ans1);
		}
	}
	
}