package ACSL_IntermediateDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_RegEx_IntermediateDivision {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("RegExI1.txt");
		Scanner scan = new Scanner(file);

		String[] exprs = scan.nextLine().split(", ");
		ArrayList<String> possibles;
		for (int i = 0; i < 5; i++) {
			possibles = new ArrayList<String>();
			String in = scan.nextLine();
			if (in.contains(".")) {
				for (String x : exprs) {
					int match = 0;
					if (x.length() == in.length()) {
						for (int j = 0; j < x.length(); j++) {

							if (in.charAt(j) == '.') {
								match++;
							} else if (x.charAt(j) == in.charAt(j)) {
								match++;
							}
						}
						if (match == in.length()) {
							possibles.add(x);
						}
					}
				}

			} else if (in.contains("^")) {
				String params = in.substring(in.indexOf("[") + 1, in.indexOf("]"));
				for (String x : exprs) {
					int match = 0;
					int diff = 0;
					if (x.length() == in.length() - params.length() - 1) {
						for (int j = 0; j < x.length(); j++) {
							if (in.charAt(j) == '[') {
								if (!(params.contains(x.charAt(j) + ""))) {
									match++;
								}
								diff += params.length() + 1;
							} else if (x.charAt(j) == in.charAt(j + diff)) {
								match++;
							}
						}
						if (match == x.length()) {
							possibles.add(x);
						}
					}
				}
			} else if (in.contains("[")) {
				String params = in.substring(in.indexOf("[") + 1, in.indexOf("]"));
				for (String x : exprs) {
					int match = 0;
					int diff = 0;
					if (x.length() == in.length() - params.length() - 1) {
						for (int j = 0; j < x.length(); j++) {
							if (in.charAt(j) == '[') {
								if (params.contains(x.charAt(j) + "")) {
									match++;
								}
								diff += params.length() + 1;
							} else if (x.charAt(j) == in.charAt(j + diff)) {
								match++;
							}
						}
						if (match == x.length()) {
							possibles.add(x);
						}
					}
				}
			} else if (in.contains("*")) {
				int length = 0;
				for(String x : exprs){
					if(x.length()>length) length = x.length();
				}
				String pre = "", post = "";
				String recur = "";
				if(in.charAt(1)!= '*') pre = in.charAt(0)+"";
				if(!(in.indexOf('*')==in.length()-1)){
					for(int a = in.indexOf('*')+1; a < in.length(); a++){
						post+=in.charAt(a);
					}
				}
				int a = 0;
				while(a<=length - pre.length() - post.length()){
					String complete = pre + recur + post;
					for(String x : exprs){
						if(x.equals(complete)) possibles.add(x);
					}
					recur+=in.charAt(in.indexOf('*')-1);
					a++;
					
				}
			} else if (in.contains("{")) {
				int num1 = Character.getNumericValue(in.charAt(in.indexOf("{")+1));
				int num2 = Character.getNumericValue(in.charAt(in.indexOf("{")+3));
				String pre = "", post = "";
				if(in.charAt(1)!= '{') pre = in.charAt(0)+"";
				if(!(in.indexOf('}')==in.length()-1)){
					for(int a = in.indexOf('}')+1; a < in.length(); a++){
						post+=in.charAt(a);
					}
				}
				String test = "";
				for(int a = 0; a < num1-1; a++){
					test+=in.charAt(in.indexOf('{')-1);
				}
				for(int a = num1; a <= num2; a++){
					test+=in.charAt(in.indexOf('{')-1);
					String complete = pre + test + post;
					for(String b : exprs){
						if(b.equals(complete)){
							possibles.add(b);
						}
					}
				}
			}
			System.out.print((i + 1) + ". ");
			if (possibles.size() > 0) {
				for (String x : possibles) {
					System.out.print(x + " ");
				}
			} else {
				System.out.print("NONE");
			}
			System.out.println("\n");
		}
	}

}
