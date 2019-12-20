package ACSL_IntermediateDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ACSL_RegEx1_IntermediateDivision {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("RegExI2.txt");
		Scanner scan = new Scanner(file);
		String[] in = scan.nextLine().split(", ");

		for (int i = 0; i < 5; i++) {
			ArrayList<String> possibles = new ArrayList<String>();
			String s = scan.nextLine();
			for (String x : in) {
				Pattern p = Pattern.compile(s);
				Matcher m = p.matcher(x);
				if(m.matches()){
					possibles.add(x);
				}
			}
			if(possibles.size()>0){
				for(int j = 0; j < possibles.size(); j++){
					System.out.print(possibles.get(j)+" ");
				}
			} else {
				System.out.print("NONE");
			}
			System.out.println("\n");
		}

	}

}
