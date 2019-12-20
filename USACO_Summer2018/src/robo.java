import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class robo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		int numcount = 1;
		for(int i = 0; i < N; i++){
			String test = br.readLine();
			if(test.equals("ADD")){
				stack.add(numcount);
				numcount++;
			} else {
				stack.pop();
			}
		}
		System.out.println(stack.size());
		for(int x : stack){
			System.out.println(x);
		}
	}

}
