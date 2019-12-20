package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_Search_JuniorDivision {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Search2.txt");

		Scanner scan = new Scanner(file);

		String[] in = scan.nextLine().split(", ");
		boolean solved = false;
		ArrayList<String> matches;
		for (int i = 0; i < 5; i++) {
			matches = new ArrayList<String>();
			String str = scan.nextLine();

			if (str.contains("*")) {
				String temp = "";

				if (str.indexOf("*") == 0) {
					for (int j = 1; j < str.length(); j++) {
						temp += str.charAt(j);
					}
					for (String x : in) {
						if (x.endsWith(temp)) {
							matches.add(x);
						}
					}
				} else {
					for (int j = 0; j < str.length() - 1; j++) {
						temp += str.charAt(j);
					}
					for (String x : in) {
						if (x.startsWith(temp)) {
							matches.add(x);
						}
					}
				}
			}
			int length = str.length();
			if (str.contains("?")) {
				char[] temp1 = str.toCharArray();
				String temp = "";
				if (str.contains("*")) {

					if (str.indexOf("*") == 0) {
						for (int j = 65; j < 91; j++) {
							temp = "";
							temp1[str.indexOf("?")] = (char) j;
							for(int k = 1; k < temp1.length; k++){
								temp+=temp1[k];
							}
							for (String x : in) {
								if (x.endsWith(temp)) {
									matches.add(x);
								}
							}
						}
					} else {
						for (int j = 65; j < 91; j++) {
							temp = "";
							temp1[str.indexOf("?")] = (char) j;
							for(int k = 0; k < temp1.length-1; k++){
								temp+=temp1[k];
							}
							for (String x : in) {
								if (x.startsWith(temp)) {
									matches.add(x);
								}
							}

						}
					}
				} else {
					for (int j = 65; j < 91; j++) {
						temp = "";
						temp1[str.indexOf("?")] = (char) j;
						for(int k = 0; k < temp1.length; k++){
							temp+=temp1[k];
						}
						
						for(String x : in){
							if(x.equals(temp)){
								matches.add(x);
							}
						}
					}
				}
			}

			if (matches.size() == 0) {
				System.out.print("No match");
			} else {
				for (String x : matches) {
					System.out.print(x + " ");
				}
			}

			System.out.println("\n");
		}

	}
}
