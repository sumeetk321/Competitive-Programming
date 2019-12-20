package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_ACSLNYSIIS_JuniorDivision {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("NYSIIS2.txt");
		Scanner scan = new Scanner(file);
		
		
		for(int i = 0; i < 5; i++){
			System.out.println("\n");
			String name = scan.nextLine();
			ArrayList<String> in = new ArrayList<String>();
			for(int j = 0; j < name.length(); j++){
				in.add(name.charAt(j)+"");
			}
			if(name.startsWith("MAC")){
				in.remove(1);
			} else if(name.startsWith("KN")){
				in.remove(0);
			} else if(name.startsWith("K")){
				in.set(0, "C");
			} else if(name.startsWith("PH")){
				in.remove(1);
				in.set(0, "F");
			} else if(name.startsWith("PF")){
				in.remove(0);
			} else if(name.startsWith("SCH")){
				in.remove(1);
				in.remove(1);
			}
			if(name.endsWith("EE")){
				in.remove(in.size()-1);
				in.set(in.size()-1, "Y");
			} else if(name.endsWith("IE")){
				in.remove(in.size()-1);
				in.set(in.size()-1, "Y");
			} else if(name.endsWith("DT") || name.endsWith("RT") || name.endsWith("RD") || name.endsWith("NT")||name.endsWith("ND")){
				in.remove(in.size()-1);
				in.set(in.size()-1, "D");
			}
			
			for(int j = 1; j < in.size(); j++){
				
				if(in.get(j).equals("E") || in.get(j).equals("I") ||in.get(j).equals("O")||in.get(j).equals("U")){
					in.set(j, "A");
				}
				
			}
			if(in.get(in.size()-1).equals("S")){
				in.remove(in.size()-1);
			}
			if(in.get(in.size()-1).equals("Y")&&in.get(in.size()-2).equals("A")){
				in.remove(in.size()-2);
			}
			if(in.get(in.size()-1).equals("A")){
				in.remove(in.size()-1);
			}
			ArrayList<String> temp = in;
			for(int j = 0; j < temp.size()-1; j++){
				if(temp.get(j).equals(temp.get(j+1))){
					in.remove(j+1);
					j--;
				}
			}
			
			if(in.size()>6){
				for(int j = 0; j < 6; j++){
					System.out.print(in.get(j));
				}
			} else {
				for(String x : in){
					System.out.print(x);
				}
			}
		}
	}

}
