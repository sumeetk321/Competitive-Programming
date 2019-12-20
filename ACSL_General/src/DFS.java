import java.util.Stack;

class Node {
	private String Rchild, Lchild;
	String val;
	Node(String s, String l, String r) {
		val = s;
		Rchild = r;
		Lchild = l;
	}

	Node(String l, String r) {
		Rchild = r;
		Lchild = l;
	}

	public String getRchild() {
		return Rchild;
	}

	public String getLchild() {
		return Lchild;
	}

}

public class DFS {
	public static void main(String[] args) {
		// DFS
		Stack<Node> stack = new Stack<Node>();
		stack.add(new Node("6", "7"));
		stack.add(new Node("4", "5"));
		Node one = new Node("1", "2", "3");
		stack.add(one);
		for (int i = 0; i < stack.size(); i++) {
			if(stack.peek().val!=null){
				System.out.println(stack.peek().val);
			}
			System.out.println(stack.peek().getLchild());
			
			
			System.out.println(stack.pop().getRchild());
		}
		// choice is 4
		
	}
}