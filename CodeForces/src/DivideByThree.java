import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DivideByThree {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		String test = br.readLine();
		while(!isBeautiful(test)){
			test = beautifulLength(test);
		}
		out.println(test);
		out.close();
	}

	public static String beautifulLength(String test) {
		int sum = 0;
		for(int i = 0; i < test.length(); i++){
			sum+=Character.getNumericValue(test.charAt(i));
		}
		StringBuilder teststr = new StringBuilder(test);
		if (sum % 3 == 0) {
			return clean(test);
		} else if (sum % 3 == 1) {
			if (test.contains("1")) {
				return clean(teststr.deleteCharAt(test.indexOf("1")).toString());
			} else if (test.contains("4")) {
				return clean(teststr.deleteCharAt(test.indexOf("4")).toString());
			} else if (test.contains("7")) {
				return clean(teststr.deleteCharAt(test.indexOf("7")).toString());
			}
		} else if (sum % 3 == 2) {
			if (test.contains("2")) {
				return clean(teststr.deleteCharAt(test.indexOf("2")).toString());
			} else if (test.contains("5")) {
				return clean(teststr.deleteCharAt(test.indexOf("5")).toString());
			} else if (test.contains("8")) {
				return clean(teststr.deleteCharAt(test.indexOf("8")).toString());
			}
		}
		return "-1";
	}

	public static String clean(String test) {
		while (test.length() > 1 && test.startsWith("0")) {
			test = test.substring(1, test.length());
		}
		if (test.length() > 0) {
			return test;
		} else {
			return "-1";
		}
	}
	
	public static boolean isBeautiful(String test){
		int sum = 0;
		for(int i = 0; i < test.length(); i++){
			sum+=Character.getNumericValue(test.charAt(i));
		}
		if(sum%3==0&&test.length()>=1){
			if(test.startsWith("0")&&!test.equals("0")){
				return false;
			}
			return true;
		}
		return false;
	}
}
