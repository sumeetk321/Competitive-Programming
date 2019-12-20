package ACSL_IntermediateDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_Search_IntermediateDivision {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("SearchI2.txt");

		Scanner scan = new Scanner(file);

		String[] in = scan.nextLine().split(", ");
		for (int i = 0; i < 5; i++) {
			ArrayList<String> matches = new ArrayList<String>();
			boolean question = false, star = false, range = false;
			String str = scan.nextLine();
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '?') {
					question = true;
				}
				if (str.charAt(j) == '*') {
					star = true;
				}
				if (str.charAt(j) == '[') {
					range = true;
				}

			}
			if (question && star) {
				char[] temp1 = str.toCharArray();
				String temp = "";

				if (str.indexOf("*") == 0) {
					for (int j = 65; j < 91; j++) {
						temp = "";
						temp1[str.indexOf("?")] = (char) j;
						for (int k = 1; k < temp1.length; k++) {
							temp += temp1[k];
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
						for (int k = 0; k < temp1.length - 1; k++) {
							temp += temp1[k];
						}
						for (String x : in) {
							if (x.startsWith(temp)) {
								matches.add(x);
							}
						}

					}
				}

			} else if (question && range) {
				int index = str.indexOf("[");
				String[] temp1 = new String[str.length()];
				for (int l = 0; l < str.length(); l++) {
					temp1[l] = str.charAt(l) + "";
				}
				int ran1 = Integer.parseInt(temp1[index + 1]);
				int ran2 = Integer.parseInt(temp1[index + 3]);
				temp1[index + 4] = "";
				temp1[index + 1] = "";
				temp1[index + 2] = "";
				temp1[index + 3] = "";
				for (; ran1 <= ran2; ran1++) {
					String tmp = "";
					temp1[index] = Integer.toString(ran1);
					for (int ab = 0; ab < temp1.length; ab++) {
						tmp += temp1[ab];
					}
					for (int j = 65; j < 91; j++) {
						String temp = "";
						char[] temp2 = tmp.toCharArray();
						temp2[tmp.indexOf("?")] = (char) j;
						for (int k = 0; k < temp2.length; k++) {
							temp += temp2[k];
						}

						for (String abc : in) {
							if (temp.equals(abc)) {
								matches.add(abc);
							}
						}
					}

				}
			} else if (star && range) {
				String temp = "";

				if (str.indexOf("*") == 0) {
					for (int j = 1; j < str.length(); j++) {
						temp += str.charAt(j);
					}
					int index = temp.indexOf("[");
					String[] temp1 = new String[temp.length()];
					for (int l = 0; l < temp.length(); l++) {
						temp1[l] = temp.charAt(l) + "";
					}
					int ran1 = Integer.parseInt(temp1[index + 1]);
					int ran2 = Integer.parseInt(temp1[index + 3]);
					temp1[index + 4] = "";
					temp1[index + 1] = "";
					temp1[index + 2] = "";
					temp1[index + 3] = "";
					for (; ran1 <= ran2; ran1++) {
						String tmp = "";
						temp1[index] = Integer.toString(ran1);
						for (int ab = 0; ab < temp1.length; ab++) {
							tmp += temp1[ab];
						}
						for (String abc : in) {
							if (abc.endsWith(tmp)) {
								matches.add(abc);
							}
						}
					}
				} else {
					for (int j = 0; j < str.length() - 1; j++) {
						temp += str.charAt(j);
					}
					int index = temp.indexOf("[");
					String[] temp1 = new String[temp.length()];
					for (int l = 0; l < temp.length(); l++) {
						temp1[l] = temp.charAt(l) + "";
					}
					int ran1 = Integer.parseInt(temp1[index + 1]);
					int ran2 = Integer.parseInt(temp1[index + 3]);
					temp1[index + 4] = "";
					temp1[index + 1] = "";
					temp1[index + 2] = "";
					temp1[index + 3] = "";
					for (; ran1 <= ran2; ran1++) {
						String tmp = "";
						temp1[index] = Integer.toString(ran1);
						for (int ab = 0; ab < temp1.length; ab++) {
							tmp += temp1[ab];
						}
						for (String abc : in) {
							if (abc.startsWith(tmp)) {
								matches.add(abc);
							}
						}
					}
				}

			} else if (question) {
				for (int j = 65; j < 91; j++) {
					String temp = "";
					char[] temp1 = str.toCharArray();
					temp1[str.indexOf("?")] = (char) j;
					for (int k = 0; k < temp1.length; k++) {
						temp += temp1[k];
					}

					for (String x : in) {
						if (x.equals(temp)) {
							matches.add(x);
						}
					}
				}
			} else if (star) {
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
			} else if (range) {
				int index = str.indexOf("[");
				String[] temp1 = new String[str.length()];
				for (int l = 0; l < str.length(); l++) {
					temp1[l] = str.charAt(l) + "";
				}
				int ran1 = Integer.parseInt(temp1[index + 1]);
				int ran2 = Integer.parseInt(temp1[index + 3]);
				temp1[index + 4] = "";
				temp1[index + 1] = "";
				temp1[index + 2] = "";
				temp1[index + 3] = "";
				for (; ran1 <= ran2; ran1++) {
					String tmp = "";
					temp1[index] = Integer.toString(ran1);
					for (int ab = 0; ab < temp1.length; ab++) {
						tmp += temp1[ab];
					}
					for (String abc : in) {
						if (tmp.equals(abc)) {
							matches.add(abc);
						}
					}
				}
			}
			if (matches.size() == 0) {
				System.out.print("No match");
			} else {
				for (String a : matches) {
					System.out.print(a + " ");
				}
			}
			System.out.println("\n");
		}
	}

}
