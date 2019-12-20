import java.util.Scanner;
import java.util.Stack;

public class InfixToPrefix {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter an expression");
		String nums = "0123456789";
		String order = "-+*/^";
		String A = scan.nextLine();
		String A1 = A;
		String B = "";
		Stack<String> stack = new Stack<String>();
		stack.push(")");
		A += "(";
		int i = A.length() - 1;
		while (i > -1) {
			String in = A.charAt(i) + "";

			if (nums.contains(in)) {
				B += in;
			} else if (in.equals(")")) {
				stack.push(")");
			} else if (in.equals("+") || in.equals("-") || in.equals("*") || in.equals("/")) {
				if (stack.isEmpty()) {
					stack.push(in);
				} else {
					while (!stack.isEmpty() && !stack.peek().equals(")")
							&& (order.indexOf(stack.peek()) >= order.indexOf(in))) {

						B += stack.pop();

					}
					stack.push(in);
				}
			} else if (in.equals("(")) {
				while (!stack.isEmpty() && stack.peek() != ")") {
					B += stack.pop();
				}
				if (!stack.isEmpty()) {
					stack.pop();
				}
			}

			i--;
		}

		while (!stack.isEmpty()) {
			if (stack.peek().equals("(") || stack.peek().equals(")")) {
				stack.pop();
			} else {
				B += stack.pop();
			}
		}
		B = new StringBuffer(B).reverse().toString();
		System.out.println(B);

		Stack<String> num = new Stack<String>();
		Stack<String> operators = new Stack<String>();
		for (int j = A1.length() - 1; j > -1; j--) {
			if (nums.contains(A1.charAt(j) + "")) {
				num.push(A1.charAt(j) + "");
			} else {
				operators.push(A1.charAt(j) + "");
				if (operators.peek().equals("(")) {
					while (!operators.peek().equals(")")) {
						if (operators.peek().equals("(")) {
							operators.pop();
						} else {
							if (operators.peek().equals("-")) {
								num.push(Integer.toString(Integer.parseInt(num.pop()) - Integer.parseInt(num.pop())));
							} else if (operators.peek().equals("+")) {
								num.push(Integer.toString(Integer.parseInt(num.pop()) + Integer.parseInt(num.pop())));

							} else if (operators.peek().equals("*")) {
								num.push(Integer.toString(Integer.parseInt(num.pop()) * Integer.parseInt(num.pop())));

							} else if (operators.peek().equals("/")) {
								num.push(Integer.toString(Integer.parseInt(num.pop()) / Integer.parseInt(num.pop())));

							}
							operators.pop();
						}
					}
					operators.pop();
				}
			}
		
		}
		System.out.println("ANSWER: " +num.pop());
	}

}
