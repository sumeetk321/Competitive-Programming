import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class lookup {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cows = new int[N];
		for (int i = 0; i < N; i++) {
			cows[i] = Integer.parseInt(br.readLine());
		}
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> out = new Stack<Integer>();
		for (int i = N - 1; i >= 0; i--) {
			while (!stack.isEmpty() && cows[i] >= cows[stack.peek()]) {
				stack.pop();
			}
			// System.out.println(stack);
			if (stack.size() == 0) {
				out.push(0);
			} else {
				out.push(stack.peek() + 1);
			}
			stack.push(i);
		}
		while (!out.isEmpty()) {
			System.out.println(out.pop());
		}
	}

}
