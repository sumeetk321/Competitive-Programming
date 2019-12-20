import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Differentiate {

	public static void main(String[] args) throws FileNotFoundException, ScriptException {
		File file = new File("Differentiate.txt");
		Scanner scan = new Scanner(file);

		for (int i = 0; i < 10; i++) {
			String exp = scan.nextLine();
			System.out.println(multidifferentiate(exp) + ", " + multidifferentiate(multidifferentiate(exp)));
		}

	}

	public static String multidifferentiate(String exp) throws ScriptException {
		if (exp.contains("+") || ((exp.contains("-") && (exp.contains("-X"))||(exp.contains("-")&&!exp.contains("-X"))))) {
			if (exp.contains("-X") && !exp.contains("+-X")) {
				exp = exp.replace("-X", "+-X");
			} else {
				exp = exp.replace("-", "+-");
			}
			exp = exp.replace("^+", "^");
			exp = exp.replace("^(+", "^(");

			String[] terms = exp.split("\\+");
			String out = "";
			
			for (String x : terms) {
				String add = differentiate(x) + "+";
				add = add.replace("^1", "");
				add = add.replace(".0", "");
				add = add.replace("1X", "X");
				add = add.replace("0-", "-");
				add = add.replace("-0", "");
				add = add.replace("+0", "");
				out += add;
			}
			out = out.replace("+-", "-");
			if (out.endsWith("+") || out.endsWith("-")) {
				out = out.substring(0, out.length() - 1);
			}
			out = out.replace("^1", "");
			out = out.replace(".0", "");
			out = out.replace("1X", "X");
			out = out.replace("0-", "-");
			out = out.replace("-0", "");
			out = out.replace("+0", "");
			return out;
		} else {
			return differentiate(exp);
		}
	}

	public static String differentiate(String exp) throws ScriptException {
		if (exp.contains("^")) {
			ScriptEngineManager mgr = new ScriptEngineManager();
			ScriptEngine engine = mgr.getEngineByName("JavaScript");
			if (exp.charAt(0) == 'X') {
				exp = exp.replace("X", "1X");
			}
			if(exp.startsWith("-X")){
				exp = exp.replace("-X", "-1X");
			}
			String[] baseexponent = exp.split("X\\^");
			double base = Double.parseDouble(engine.eval(baseexponent[0]) + "");
			double exponent = Double.parseDouble(engine.eval(baseexponent[1]) + "");
			String out = (toFraction(base * exponent)) + "X^" + (toFraction(exponent - 1));
			out = out.replace("^1", "");
			out = out.replace(".0", "");
			out = out.replace("1X", "X");
			out = out.replace("0-", "-");
			out = out.replace("-0", "");
			out = out.replace("+0", "");
			return out;
		} else if (exp.contains("X")) {
			return exp.substring(0, exp.length() - 1);
		} else {
			return "0";
		}
	}

	public static String toFraction(double x) {
		if (Double.toString(x).charAt(Double.toString(x).length() - 1) == '0') {
			return ((int) x) + "";
		} else {
			String num = Integer.toString((int) ((int) 2 * x));
			if (num.equals("0")) {
				num = Integer.toString((int) ((int) 4 * x));
				return "(" + num + "/4)";
			} else {
				return "(" + num + "/2)";
			}
		}
	}

}