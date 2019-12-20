import java.util.Scanner;
import java.util.Stack;

//*)+(
//CBA+*
public class Pip {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter an expression");
			String in = scan.nextLine();
			String out = "";
			String operators = "+-*";
			String order = "()-+*/";
			Stack<String> stack = new Stack<String>();

			for (int j = in.length() - 1; j > -1; j--) {
				String test = in.charAt(j) + "";
				if (!order.contains(test)) {
					out += test;
				} else if (test.equals(")")) {
					stack.push(test);
				} else if (operators.contains(test)) {
					while (stack.size() > 0 && order.indexOf(stack.peek()) >= order.indexOf(test)) {
						out += stack.pop();
					}
					stack.push(test);
				} else if (test.equals("(")) {
					while (stack.size() > 0 && !(stack.peek().equals(")"))) {
						out+=stack.pop();
					}
					stack.pop();
				}

			}
			while (!stack.isEmpty()) {
				
				out += stack.pop();
			}

			System.out.println(new StringBuilder(out).reverse().toString());

		}
	}

}
