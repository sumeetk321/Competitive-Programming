//Author: Sumeet Kulkarni
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Contest2_ACEIntermediate_SumeetKulkarni {
	static ArrayList<Character> digits = new ArrayList<Character>(
			Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));

	public static void main(String[] args) throws IOException {

		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("js");
		BufferedReader br = new BufferedReader(new FileReader("Contest2Input.txt"));
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				ArrayList<Integer> possibleindices = new ArrayList<Integer>();
				String exp = br.readLine();
				StringBuilder sb = new StringBuilder(exp);
				String missingbracket = "";
				if (exp.contains("(") && !exp.contains(")")) {
					missingbracket = ")";
				} else if (exp.contains(")") && !exp.contains("(")) {
					missingbracket = "(";
				} else if (exp.contains("[") && !exp.contains("]")) {
					missingbracket = "]";
				} else if (exp.contains("]") && !exp.contains("[")) {
					missingbracket = "[";
				}
				for (int k = 0; k <= exp.length(); k++) {
					sb.insert(k, missingbracket);
					String test = sb.toString();
					if (containsBadBrackets(test)) {
						sb = new StringBuilder(exp);
						continue;
					}
					try {
						if (engine.eval(test) == null||engine.eval(test).equals(Double.NaN)) {
							sb = new StringBuilder(exp);
							continue;
						}
					} catch (ScriptException se) {
						sb = new StringBuilder(exp);
						continue;
					}
					possibleindices.add(k + 1);
					sb = new StringBuilder(exp);
				}
				System.out.print(possibleindices.get(0));

				for (int k = 1; k < possibleindices.size(); k++) {
					System.out.print(", " + possibleindices.get(k));
				}

				System.out.println();
			}
		}
	}

	private static boolean containsBadBrackets(String test) {
		boolean out = false;
		if (test.contains("(") && test.indexOf("(") < test.indexOf(")")) {
			if (test.substring(test.indexOf("("), test.indexOf(")") + 1).length() <= 4) {
				for (int i = test.indexOf("("); i < test.indexOf(")") + 1; i++) {
					if (digits.contains(test.charAt(i))) {
						continue;
					} else {
						out = true;
					}
				}
			}
		}
		if (test.contains("[") && test.indexOf("[") < test.indexOf("]")) {
			if (test.substring(test.indexOf("["), test.indexOf("]") + 1).length() <= 4) {
				for (int i = test.indexOf("["); i < test.indexOf("]") + 1; i++) {
					if (digits.contains(test.charAt(i))) {
						continue;
					} else {
						out = true;
					}
				}
			}
		}
		return out;
	}
}
