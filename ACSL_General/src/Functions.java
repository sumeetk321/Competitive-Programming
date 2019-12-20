import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Functions {

	public static void main(String[] args) throws FileNotFoundException, ScriptException {
		File file = new File("Functions.txt");
		Scanner scan = new Scanner(file);
		for (int i = 0; i < 4; i++) {
			String[] exps = scan.nextLine().split(", ");
			exps[0] = exps[0].replace("-", "+-");
			exps[1] = exps[1].replace("-", "+-");
			if (exps[0].charAt(0) == 'x') {
				exps[0] = "1" + exps[0];
			}
			if (exps[1].charAt(0) == 'x') {
				exps[1] = "1" + exps[1];
			}
			ArrayList<String> first = new ArrayList<String>(Arrays.asList(exps[0].split("\\+")));
			ArrayList<String> second = new ArrayList<String>(Arrays.asList(exps[1].split("\\+")));
			if (first.get(first.size() - 1).contains("x")) {
				first.add("0");
			} else if (second.get(second.size() - 1).contains("x")) {
				second.add("0");
			}
			ArrayList<Integer> coeffs1 = new ArrayList<Integer>();
			ArrayList<Integer> coeffs2 = new ArrayList<Integer>();
			for (int j = 0; j < first.size(); j++) {
				coeffs1.add(Integer.parseInt(first.get(j).split("x")[0]));
			}
			for (int j = 0; j < second.size(); j++) {
				coeffs2.add(Integer.parseInt(second.get(j).split("x")[0]));
			}
			ArrayList<Integer> add = add(coeffs1, coeffs2);
			String out = "";
			for (int j = 0; j < add.size(); j++) {
				int deg = add.size() - j - 1;
				if (deg == 1) {
					out += "+" + add.get(j) + "x";
				} else if (deg == 0) {
					out += "+" + add.get(j);
				} else {
					out += "+" + add.get(j) + ("x^" + deg);
				}
			}

			System.out.println(fix(out));
			ArrayList<Integer> sub = sub(coeffs1, coeffs2);
			out = "";
			for (int j = 0; j < sub.size(); j++) {
				int deg = sub.size() - j - 1;
				if (deg == 1) {
					out += "+" + sub.get(j) + "x";
				} else if (deg == 0) {
					out += "+" + sub.get(j);
				} else {
					out += "+" + sub.get(j) + ("x^" + deg);
				}
			}
			System.out.println(fix(out));
			ArrayList<Integer> mult = multiply(coeffs1, coeffs2);
			out = "";
			for (int j = 0; j < mult.size(); j++) {
				int deg = mult.size() - j - 1;
				if (deg == 1) {
					out += "+" + mult.get(j) + "x";
				} else if (deg == 0) {
					out += "+" + mult.get(j);
				} else {
					out += "+" + mult.get(j) + ("x^" + deg);
				}
			}
			System.out.println(fix(out));
			ArrayList<Integer> div = divide(coeffs1, coeffs2);
			if (div.size() != 0) {
				out = "";
				for (int j = 0; j < div.size(); j++) {
					int deg = div.size() - j - 1;
					if (deg == 1) {
						out += "+" + div.get(j) + "x";
					} else if (deg == 0) {
						out += "+" + div.get(j);
					} else {
						out += "+" + div.get(j) + ("x^" + deg);
					}
				}
				System.out.println(fix(out));
			}
			ArrayList<Integer> comp = composite(coeffs1, coeffs2);
			if (comp.size() != 0) {
				out = "";
				for (int j = 0; j < comp.size(); j++) {
					int deg = comp.size() - j - 1;
					if (deg == 1) {
						out += "+" + comp.get(j) + "x";
					} else if (deg == 0) {
						out += "+" + comp.get(j);
					} else {
						out += "+" + comp.get(j) + ("x^" + deg);
					}
				}
				System.out.println(fix(out));
			}
			
		}
	}

	public static String fix(String out) {
		out = out.replace("0x+", "");
		out = out.replace("0x^2", "");
		out = out.substring(1, out.length()).replace("+-", "-");
		out = out.replace("1x", "x");
		out = out.replace("+0", "");

		return out;
	}

	public static ArrayList<Integer> add(ArrayList<Integer> first, ArrayList<Integer> second) {
		Collections.reverse(first);
		Collections.reverse(second);
		ArrayList<Integer> out = new ArrayList<Integer>();
		for (int i = 0; i < Math.max(first.size(), second.size()); i++) {
			if (second.size() > i) {
				out.add(first.get(i) + second.get(i));
			} else {
				out.add(first.get(i));
			}
		}
		Collections.reverse(out);
		return out;
	}

	public static ArrayList<Integer> sub(ArrayList<Integer> first, ArrayList<Integer> second) {

		ArrayList<Integer> out = new ArrayList<Integer>();
		for (int i = 0; i < Math.max(first.size(), second.size()); i++) {
			if (second.size() > i) {
				out.add(first.get(i) - second.get(i));
			} else {
				out.add(first.get(i));
			}
		}
		Collections.reverse(out);
		return out;
	}

	public static ArrayList<Integer> multiply(ArrayList<Integer> first, ArrayList<Integer> second) {
		/*
		 * Collections.reverse(first); Collections.reverse(second);
		 */
		if(first.size()==1){
			for(int i = 0; i < second.size(); i++){
				second.set(i, second.get(i)*first.get(0));
			}
			return second;
		}
		int length = first.size() + second.size() - 1;
		Integer[] coefarr = new Integer[length];
		for (int i = 0; i < coefarr.length; i++) {
			coefarr[i] = 0;
		}
		for (int i = 0; i < first.size(); i++) {
			for (int j = 0; j < second.size(); j++) {
				coefarr[i + j] += first.get(i) * second.get(j);
			}
		}
		ArrayList<Integer> out = new ArrayList<Integer>(Arrays.asList(coefarr));
		Collections.reverse(out);
		return out;
	}

	public static ArrayList<Integer> divide(ArrayList<Integer> first, ArrayList<Integer> second) {
		Collections.reverse(first);
		Collections.reverse(second);
		if (second.size() > 1 && second.get(0) > 1) {
			System.out.println("NONE");
			return new ArrayList<Integer>();
		}
		if (second.size() == 1) {
			int div = second.get(0);
			ArrayList<Integer> out = new ArrayList<Integer>();
			for (int i = 0; i < first.size(); i++) {
				out.add(first.get(i) / div);
			}
			return out;
		}
		int left = -1 * (second.get(second.size() - 1));
		ArrayList<Integer> out = new ArrayList<Integer>();
		out.add(first.get(0));
		for (int i = 1; i < first.size() - 1; i++) {
			out.add(first.get(i) + (left * out.get(i - 1)));
		}

		return out;
	}
	public static ArrayList<Integer> composite(ArrayList<Integer> first, ArrayList<Integer> second) throws ScriptException{
		if(second.size()==1){
			ScriptEngineManager mgr = new ScriptEngineManager();
			ScriptEngine engine = mgr.getEngineByName("JavaScript");
			String out = first.get(0)+"*"+second.get(0)+"+"+first.get(1);
			return new ArrayList<Integer>(Arrays.asList((int) engine.eval(out)));
		} else if(second.size()==2&&first.size()==2){
			ArrayList<Integer> out = new ArrayList<Integer>();
			out.add(first.get(0)*second.get(0));
			out.add(first.get(0)*second.get(1));
			out.set(out.size()-1, out.get(out.size()-1)+first.get(1));
			return out;
		} else {
			ArrayList<Integer> mult1 = new ArrayList<Integer>(Arrays.asList(first.get(0)));
			ArrayList<Integer> add1 = multiply(mult1, multiply(second, second));
		
			ArrayList<Integer> first1 = new ArrayList<Integer>(Arrays.asList(first.get(1)));
			ArrayList<Integer> mult2 = multiply(first1, second);
			
			ArrayList<Integer> out = sub(add1, mult2);
			return out;
		}
	}

}
