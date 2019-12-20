import java.util.Scanner;
import java.util.Stack;

public class InfixToPostifx {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter an expression");
		String exp = scan.nextLine();
		exp = exp.replace(" ", "");
		String nums = "1234567890";
		String out = "";
		String order = "()+-*/";
		Stack<String> st = new Stack<String>();
		for (int i = 0; i < exp.length(); i++) {
			String in = exp.charAt(i) + "";
			if (nums.contains(in)) {
				out += in;
			} else if (in.equals("(")) {
				st.push("(");
			} else if (in.equals(")")) {
				while (!st.isEmpty() && st.peek() != "(") {
					out += st.pop();
				}
				st.pop();
				//st.push(")");
			} else if (st.isEmpty()) {
				st.push(in);
			} else {
				while (!st.isEmpty() && order.indexOf(st.peek()) >= order.indexOf(in)) {
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
		System.out.println(out);
		st.clear();
		for (int i = 0; i < out.length(); i++) {
			String in = out.charAt(i) + "";
			if (nums.contains(in)) {
				st.push(in);
			} else {
				if (in.equals("+")) {
					st.push(Integer.toString(Integer.parseInt(st.pop()) + Integer.parseInt(st.pop())));
				} else if (in.equals("-")) {
					st.push(Integer.toString(-1 * (Integer.parseInt(st.pop()) - Integer.parseInt(st.pop()))));
				} else if (in.equals("*")) {
					st.push(Integer.toString(Integer.parseInt(st.pop()) * Integer.parseInt(st.pop())));
				} else if (in.equals("/")) {
					String denominator = st.pop();
					String numerator = st.pop();
					st.push(Integer.toString(Integer.parseInt(numerator) / Integer.parseInt(denominator)));
				}
			}
		}

		System.out.println("ANSWER: " + st.pop());
	}

}