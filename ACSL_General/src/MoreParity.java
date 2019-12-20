import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MoreParity {
	static ArrayList<Integer> powersoftwo = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 8, 16, 32, 64, 128));

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan = new Scanner(new File("MoreParity.txt"));
		for (int i = 0; i < 14; i++) {
			String[] in = scan.nextLine().split(", ");
			String parity = toBin(in[0]);
			String origparity = in[1];
			
			ArrayList<ArrayList<Integer>> bitgroups = new ArrayList<ArrayList<Integer>>();
			for (int x : powersoftwo) {
				if (x > parity.length()) {
					break;
				} else {
					bitgroups.add(new ArrayList<Integer>());
					for (int j = x; j <= parity.length(); j += (x * 2)) {
						for (int k = 0; k < x; k++) {
							if (j + k > parity.length()) {
								break;
							}
							bitgroups.get(bitgroups.size() - 1).add(j + k);
						}
					}
				}
			}
			String tmp = parity;
			for(int j = 0; j < parity.length(); j++){
				StringBuilder sb = new StringBuilder(parity);
				sb.replace(j, j+1, parity.charAt(j)=='0'?"1":"0");
				if(isValid(bitgroups, sb.toString(), origparity)){
					System.out.println(j+1);
				}
				parity = tmp;
			}
		}

	}
	public static boolean isValid(ArrayList<ArrayList<Integer>> bitgroups, String bin, String origparity){
		for(ArrayList<Integer> x : bitgroups){
			int sum = 0;
			for(int y : x){
				sum+=Character.getNumericValue(bin.charAt(y-1));
			}
			String parity = sum%2==0?"EVEN":"ODD";
			if(!parity.equals(origparity)){
				return false;
			}
		}
		return true;
	}
	public static String toBin(String hex) {
		String out = "";
		for (int i = 0; i < hex.length(); i++) {
			String tmp = Long.toBinaryString(Long.parseLong(hex.charAt(i) + "", 16));
			int len = tmp.length();
			for (int j = 0; j < 4 - len; j++) {
				tmp = "0" + tmp;
			}
			out += tmp;
		}
		return out;
	}
}

