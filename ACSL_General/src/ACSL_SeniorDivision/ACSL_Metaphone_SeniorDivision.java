package ACSL_SeniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ACSL_Metaphone_SeniorDivision {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("Metaphone1.txt");
		Scanner scan = new Scanner(file);
		
		for(int i = 0; i < 5; i++){
			String word = scan.nextLine();
			ArrayList<String> in = new ArrayList<String>();
			
			for(int j = 0; j < word.length(); j++){
				in.add(word.charAt(j)+"");
			}
			
			if(word.startsWith("AE")||word.startsWith("GN")||word.startsWith("KN")||word.startsWith("PN")||word.startsWith("WR")){
				in.remove(0);
			} else if(word.startsWith("X")){
				in.set(0, "S");
			} else if(word.startsWith("WH")){
				in.remove(1);
			}
		}
		
	}

}
