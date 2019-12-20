package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_ACSLMAN_JuniorDivision {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("Man2.txt");
		Scanner scan = new Scanner(file);

		for (int i = 0; i < 5; i++) {
			int strikes = 0;
			int counter = 0;
			String[] in = scan.nextLine().split(", ");
			String val = in[0];
			String[] man = {"  O", "\n+", "=", "[]", "=", "+", "\n  []", "\n  /", "\\"}; 
			String[] letters1 = new String[Integer.parseInt(in[1])];
			ArrayList<String> letters = new ArrayList<String>();
			ArrayList<Integer> nums = new ArrayList<Integer>();
			for(int j = 0; j < val.length(); j++){
				int tmp1 = 0;
				char tmp2 = val.charAt(j);
				if(letters.contains(val.charAt(j)+"")){
					continue;
				}else{
				letters.add(val.charAt(j)+"");
				}
				for(int k = 0; k < val.length(); k++){
					
					if(val.charAt(k)==tmp2){
						tmp1++;
					}
					if(k==val.length()-1){
						nums.add(tmp1);
					}
				}
			}
			
			for (int j = 2; j < in.length; j++) {
				letters1[j-2] = in[j];
			}
			

			for (String a : letters1) {
				if (val.contains(a)) {
					counter+=nums.get(letters.indexOf(a));
					
					if (counter == val.length()) {
						break;
					}
				} else {
					strikes++;
				}
			}
			if(strikes==0){
				System.out.println("NONE\n");
				continue;
			}
			if(strikes>9){
				for(String x : man){
					System.out.print(x);
				}
				System.out.println("\n");
				continue;
			}
			String out = "";
			for(int j = 0; j < strikes; j++){
				out+=man[j];
			}

			
			
			System.out.println(out+"\n");

		}
	}

}
