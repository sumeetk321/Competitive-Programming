package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ACSL_STRINGS_JuniorDivision {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("STRINGS2.txt");
		Scanner scan = new Scanner(file);

		for (int i = 0; i < 5; i++) {
			String in = scan.nextLine();
			String[] commands = in.split("/");
			char[] str = commands[commands.length - 1].toCharArray();
			for (int j = 0; j < commands.length - 1; j++) {
				String temp = "";
				if (commands[j].startsWith("LS")) {
					int x = Character.getNumericValue(commands[j].charAt(3));
					for (int k = x; k < str.length; k++) {
						temp += str[k];
					}
					for (int k = 0; k < x; k++) {
						temp += "#";
					}

					str = temp.toCharArray();

				} else if (commands[j].startsWith("RS")) {
					int x = Character.getNumericValue(commands[j].charAt(3));
					for (int k = 0; k < x; k++) {
						temp += "#";
					}
					for (int k = 0; k < str.length - x; k++) {
						temp += str[k];
					}
					str = temp.toCharArray();
				} else if (commands[j].startsWith("LC")) {
					int x = Character.getNumericValue(commands[j].charAt(3));
					for (int k = x; k < str.length; k++) {
						temp += str[k];
					}
					for (int k = 0; k < x; k++) {
						temp += str[k];
					}
					str = temp.toCharArray();
				} else if (commands[j].startsWith("RC")) {
					int x = Character.getNumericValue(commands[j].charAt(3));
					for (int k = str.length - x; k < str.length; k++) {
						temp += str[k];
					}
					for (int k = 0; k < str.length - x; k++) {
						temp += str[k];
					}
					str = temp.toCharArray();
				} else if (commands[j].startsWith("MC")) {
					int s = Character.getNumericValue(commands[j].charAt(3));
					int l = Character.getNumericValue(commands[j].charAt(4));
					int x = Character.getNumericValue(commands[j].charAt(5));
					char d = (commands[j].charAt(6));
					String temp1 = "";
					String temp2 = "";
					String sub = "";
					for (int k = s - 1; k < s + l - 1; k++) {
						sub += str[k];
					}
					for (int k = 0; k < s - 1; k++) {
						temp1 += str[k];
					}
					for (int k = s + l - 1; k < str.length; k++) {
						temp2 += str[k];
					}
					switch (d) {
					case 'L':
						for (int k = x; k < sub.length(); k++) {
							temp += sub.charAt(k);
						}
						for (int k = 0; k < x; k++) {
							temp += sub.charAt(k);
						}
						break;
					case 'R':
						for (int k = sub.length() - x; k < sub.length(); k++) {
							temp += sub.charAt(k);
						}
						for (int k = 0; k < sub.length() - x; k++) {
							temp += sub.charAt(k);
						}
						break;
					}

					temp = temp1 + temp + temp2;
					str = temp.toCharArray();

				}
			}
			System.out.print((i+1)+". ");
			
			for(char x : str){
				System.out.print(x);
			}
			System.out.println("\n");
				
		}
	}

}
