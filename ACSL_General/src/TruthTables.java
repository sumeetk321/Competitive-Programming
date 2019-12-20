import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import javax.script.ScriptException;

public class TruthTables {
	static String priority = "()+#*@";
	static String lets = "ABC";
	public static ArrayList<String> lengths = new ArrayList<String>();

	public static void main(String[] args) throws FileNotFoundException, ScriptException {

		File file = new File("TruthTables.txt");
		Scanner scan = new Scanner(file);
		for (int i = 0; i < 13; i++) {
			lengths = new ArrayList<String>();
			String exp = scan.nextLine();
			String tmp = exp;
			if (tmp.contains("C")) {
				System.out.print("A B C ");
				eval(tmp);
				System.out.println();
				for (int a = 0; a < 2; a++) {
					for (int b = 0; b < 2; b++) {
						for (int c = 0; c < 2; c++) {
							System.out.print(a + " " + b + " " + c + " ");
							ArrayList<String> len1 = lengths;
							for (String x : len1) {

								String tmp1 = x;
								tmp1 = tmp1.replace("A", a + "");
								tmp1 = tmp1.replace("B", b + "");
								tmp1 = tmp1.replace("C", c + "");
								eval(tmp1);
								for (int j = 0; j < x.length(); j++) {
									System.out.print(" ");
								}
							}
							System.out.println();
						}
					}
				}
			} else {
				System.out.print("A B ");
				eval(tmp);
				System.out.println();
				for (int a = 0; a < 2; a++) {
					for (int b = 0; b < 2; b++) {
						System.out.print(a + " " + b + " ");
						ArrayList<String> len1 = lengths;
						for (String x : len1) {

							String tmp1 = x;
							tmp1 = tmp1.replace("A", a + "");
							tmp1 = tmp1.replace("B", b + "");
							eval(tmp1);
							for (int j = 0; j < x.length(); j++) {
								System.out.print(" ");
							}
						}
						System.out.println();

					}
				}
			}
			System.out.println();
		}
	}

	public static void eval(String exp) throws ScriptException {
		/*
		 * ScriptEngineManager mgr = new ScriptEngineManager(); ScriptEngine
		 * engine = mgr.getEngineByName("JavaScript"); boolean result =
		 * Boolean.parseBoolean(engine.eval(s)+"");
		 * System.out.print((result?"1":"0")+" ");
		 */
		exp = exp.replace(" ", "");
		String out = "";
		Stack<String> st = new Stack<String>();
		for (int j = 0; j < exp.length(); j++) {
			String in = exp.charAt(j) + "";
			if (!priority.contains(in)) {
				out += in;
			} else if (in.equals("(")) {
				st.push("(");
			} else if (in.equals(")")) {
				while (!st.isEmpty() && st.peek() != "(") {
					out += st.pop();
				}
				st.pop();
				// st.push(")");
			} else if (st.isEmpty()) {
				st.push(in);
			} else {
				while (!st.isEmpty() && priority.indexOf(st.peek()) >= priority.indexOf(in)) {
					out += st.pop();
				}
				st.push(in);
			}

		}
		while (!st.isEmpty()) {
			if (st.peek().equals("(") || st.peek().equals(")")) {
				st.pop();
				continue;
			} else {
				out += st.pop();
			}
		}
		st.clear();
		if (exp.contains("A")) {
			for (int j = 0; j < out.length(); j++) {
				String in = out.charAt(j) + "";
				if (!priority.contains(in)) {
					st.push(in);
				} else {
					if (in.equals("+")) {
						String x = st.pop();
						String y = st.pop();

						lengths.add((x + "+" + y));
						System.out.print(x + "+" + y + " ");
						st.push("(" + x + "+" + y + ")");
					} else if (in.equals("#")) {
						String x = st.pop();
						String y = st.pop();
						lengths.add((x + "#" + y));
						System.out.print(x + "#" + y + " ");
						st.push("(" + x + "#" + y + ")");
					} else if (in.equals("*")) {
						String x = st.pop();
						String y = st.pop();
						lengths.add((x + "*" + y));
						System.out.print(x + "*" + y + " ");
						st.push("(" + x + "*" + y + ")");
					} else if (in.equals("@")) {
						String x = st.pop();
						lengths.add("@" + x);
						System.out.print("@" + x + " ");
						st.push("(@" + x + ")");
					}
				}

			}
		} else {
			for (int j = 0; j < out.length(); j++) {
				String in = out.charAt(j) + "";
				if (!priority.contains(in)) {
					st.push(in);
				} else {
					if (in.equals("+")) {

						if (st.pop().equals("0")) {
							if (st.pop().equals("1")) {
								st.push("1");
							} else {
								st.push("0");
							}
						} else {
							st.pop();
							st.push("1");
						}
					} else if (in.equals("#")) {
						if (st.pop().equals("0")) {
							if (st.pop().equals("1")) {
								st.push("1");
							} else {
								st.push("0");
							}
						} else {
							if (st.pop().equals("1")) {
								st.push("0");
							} else {
								st.push("1");
							}
						}
					} else if (in.equals("*")) {
						if (st.pop().equals("1")) {
							if (st.pop().equals("1")) {
								st.push("1");
							} else {
								st.push("0");
							}
						} else {
							st.pop();
							st.push("0");
						}
					} else if (in.equals("@")) {
						if (st.pop().equals("1")) {
							st.push("0");
						} else {
							st.push("1");
						}
					}
				}

			}

			System.out.print(st.pop());
		}
	}

}
