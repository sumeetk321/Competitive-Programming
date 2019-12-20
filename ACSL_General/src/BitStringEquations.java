import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class BitStringEquations {

	public static void main(String[] args) throws FileNotFoundException, ScriptException {
		Scanner scan = new Scanner(new File("BitStringEquations.txt"));
		for (int i = 0; i < 2; i++) {
			ScriptEngineManager mgr = new ScriptEngineManager();
			ScriptEngine engine = mgr.getEngineByName("js");
			for (int j = 0; j < (i == 0 ? 5 : 10); j++) {
				String[] in = scan.nextLine().split(" = ");
				String exp = in[0];

				ArrayList<String> solutions = new ArrayList<String>();
				for (int k = 0; k < 32; k++) {
					String test = Integer.toBinaryString(k);
					int len = test.length();
					for (int l = 0; l < 5 - len; l++) {
						test = "0" + test;
					}
					String tmp = exp.replace("X", test);
					if (tmp.contains("+")) {
						String[] arr = tmp.split("\\+");
						if (!arr[0].contains(")")) {
							arr[0] += ")";
						}
						if (!arr[1].contains("(")) {
							arr[1] = "(" + arr[1];
						}
						if (Integer
								.toBinaryString(Integer.parseInt(simplify(arr[0].substring(1, arr[0].length())), 2)
										| Integer.parseInt(simplify(arr[1].substring(0, arr[1].length() - 1)), 2))
								.equals(in[1])) {
							solutions.add(test);

						}
					} else if (tmp.contains("*")) {
						String[] arr = tmp.split("\\*");
						if (!arr[0].contains(")")) {
							arr[0] += ")";
						}
						if (!arr[1].contains("(")) {
							arr[1] = "(" + arr[1];
						}
						if (Integer
								.toBinaryString(Integer.parseInt(simplify(arr[0].substring(1, arr[0].length())), 2)
										& Integer.parseInt(simplify(arr[1].substring(0, arr[1].length() - 1)), 2))
								.equals(in[1])) {
							solutions.add(test);

						}
					} else if (tmp.contains("@")) {
						String[] arr = tmp.split("@");
						if (!arr[0].contains(")")) {
							arr[0] += ")";
						}
						if (!arr[1].contains("(")) {
							arr[1] = "(" + arr[1];
						}
						if (Integer
								.toBinaryString(Integer.parseInt(simplify(arr[0].substring(1, arr[0].length())), 2)
										^ Integer.parseInt(simplify(arr[1].substring(0, arr[1].length() - 1)), 2))
								.equals(in[1])) {
							solutions.add(test);

						}
					} else {
						if (simplify(tmp).equals(in[1])) {
							solutions.add(test);
						}
					}

				}
				String out = "";
				for (int l = 0; l < 5; l++) {
					int[] bits = { 0, 0 };
					for (String x : solutions) {
						if (x.charAt(l) == '0') {
							bits[0]++;
						} else {
							bits[1]++;
						}
					}
					if (bits[0] < solutions.size() && bits[1] < solutions.size()) {
						out += "*";
					} else {
						out += (bits[1] > bits[0] ? "1" : "0");
					}
				}
				System.out.println(out);
			}
		}
	}

	public static String simplify(String exp) {
		int leftpar = 0;
		int rightpar = 0;
		for(int i = 0; i < exp.length(); i++){
			if(exp.charAt(i)=='('){
				leftpar++;
			} else if(exp.charAt(i)==')'){
				rightpar++;
			}
		}
		if(leftpar>rightpar){
			exp+=")";
		} else if(rightpar>leftpar){
			exp+="(";
		}
		while (exp.contains("(")) {
			if (exp.matches("\\(\\([0-1]+\\)\\)")) {
				return exp.substring(2, 7);
			}
			if(exp.matches("\\([0-1]+\\)")){
				return exp.substring(1, 6);
			}
			String substr = exp.substring(exp.lastIndexOf("(") + 1, exp.indexOf(")"));
			String tmp = "";
			if (substr.startsWith("RS")) {
				int shiftnum = Character.getNumericValue(substr.charAt(3));
				String bin = substr.substring(5, substr.length());
				for (int i = 0; i < shiftnum; i++) {
					tmp += "0";
				}
				for (int i = 0; i < 5 - shiftnum; i++) {
					tmp += bin.charAt(i);
				}
			} else if (substr.startsWith("LS")) {
				int shiftnum = Character.getNumericValue(substr.charAt(3));
				String bin = substr.substring(5, substr.length());

				for (int i = shiftnum; i < 5; i++) {
					tmp += bin.charAt(i);
				}
				for (int i = 0; i < shiftnum; i++) {
					tmp += "0";
				}
			} else if (substr.startsWith("RC")) {
				int circnum = Character.getNumericValue(substr.charAt(3));
				String bin = substr.substring(5, substr.length());
				String pt1 = bin.substring(0, 5 - circnum);
				String pt2 = bin.substring(5 - circnum, 5);
				tmp = pt2 + pt1;
			} else if (substr.startsWith("LC")) {
				int circnum = Character.getNumericValue(substr.charAt(3));
				String bin = substr.substring(5, substr.length());
				String pt1 = bin.substring(0, circnum);
				String pt2 = bin.substring(circnum, 5);
				tmp = pt2 + pt1;
			} else if (substr.startsWith("NT")) {
				String bin = substr.substring(3, substr.length());
				for (int i = 0; i < bin.length(); i++) {
					tmp += (bin.charAt(i) == '0' ? "1" : "0");
				}
			}
			exp = exp.replace("(" + substr + ")", " " + tmp);
		}
		return exp.trim();
	}
}
