import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class rerouting {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 2; i++) {
			int inputnum = (i == 0 ? 4 : 5);
			for (int j = 0; j < inputnum; j++) {
				String[] in = br.readLine().split(", ");
				String message = in[0];
				int routernum = Integer.parseInt(in[1]);
				String[] routers = new String[routernum];
				for (int k = 2; k < routernum + 2; k++) {
					routers[k - 2] = in[k];
				}
				int index = Integer.parseInt(in[in.length - 1]);
				System.out.println(encode(message, routers).charAt(index - 1));
			}
			for(int j = 0; j < inputnum; j++){
				String[] in = br.readLine().split(", ");
				String message = in[0];
				int routernum = Integer.parseInt(in[1]);
				String[] routers = new String[routernum];
				for (int k = 2; k < in.length; k++) {
					routers[k - 2] = in[k];
				}
				System.out.println(decode(message, routers));
			}
		}
	}

	public static String encode(String str, String[] hexarr) {
		for (int i = 0; i < hexarr.length; i++) {
			String hex = hexarr[i];
			String dec = Integer.parseInt(hex, 16) + "";
			int switch1 = Math.min(Character.getNumericValue(dec.charAt(1)), Character.getNumericValue(dec.charAt(2)));
			int switch2 = Math.max(Character.getNumericValue(dec.charAt(1)), Character.getNumericValue(dec.charAt(2)));
			switch (Character.getNumericValue(dec.charAt(0)) % 2) {
			case 0:
				String tmp = "";
				for (int j = 0; j < str.length(); j++) {
					if (j == switch1 - 1) {
						tmp += str.charAt(switch2 - 1);
					} else if (j == switch2 - 1) {
						tmp += str.charAt(switch1 - 1);
					} else {
						tmp += str.charAt(j);
					}
				}
				str = tmp;
				break;
			case 1:
				String tmp1 = "";
				for (int j = str.length() - 1; j > -1; j--) {
					if (j == str.length() - switch1) {
						tmp1 += str.charAt(str.length() - switch2);
					} else if (j == str.length() - switch2) {
						tmp1 += str.charAt(str.length() - switch1);
					} else {
						tmp1 += str.charAt(j);
					}
				}
				tmp1 = new StringBuilder(tmp1).reverse().toString();
				str = tmp1;
				break;
			}
			if (i == 0) {
				str = "A" + str + "AA";
			}
			str = hex.charAt(0) + str + hex.charAt(2);
		}
		return str;
	}
	
	public static String decode(String str, String[] midchars) {
		for (int i = 0; i < midchars.length; i++) {
			String hex = str.charAt(0) + midchars[i]+str.charAt(str.length() - 1) + "";
			str = str.substring(1, str.length() - 1);
			String dec= Integer.parseInt(hex, 16)+"";
			int switch1 = Math.min(Character.getNumericValue(dec.charAt(1)), Character.getNumericValue(dec.charAt(2)));
			int switch2 = Math.max(Character.getNumericValue(dec.charAt(1)), Character.getNumericValue(dec.charAt(2)));
			//System.out.println(dec+" "+switch1+" "+switch2);
			if(str.startsWith("A")&&str.endsWith("AA")){
				str = str.substring(1, str.length()-2);
			}
			switch (Character.getNumericValue(dec.charAt(0)) % 2) {
			case 0:
				String tmp = "";
				for (int j = 0; j < str.length(); j++) {
					if (j == switch1 - 1) {
						tmp += str.charAt(switch2 - 1);
					} else if (j == switch2 - 1) {
						tmp += str.charAt(switch1 - 1);
					} else {
						tmp += str.charAt(j);
					}
				}
				str = tmp;
				break;
			case 1:
				String tmp1 = "";
				for (int j = str.length() - 1; j > -1; j--) {
					if (j == str.length() - switch1) {
						tmp1 += str.charAt(str.length() - switch2);
					} else if (j == str.length() - switch2) {
						tmp1 += str.charAt(str.length() - switch1);
					} else {
						tmp1 += str.charAt(j);
					}
				}
				tmp1 = new StringBuilder(tmp1).reverse().toString();
				str = tmp1;
				//System.out.println(str);
				break;
			}
		}
		return str;
	}

}
