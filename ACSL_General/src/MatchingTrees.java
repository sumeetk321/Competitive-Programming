import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MatchingTrees {
	static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("MatchingTrees.txt");
		Scanner scan = new Scanner(file);
		for (int i = 0; i < 13; i++) {
			String[] in = scan.nextLine().split(", ");
			Node1 small = new Node1(in[0].charAt(0) + "");
			Node1 big = new Node1(in[1].charAt(0) + "");
			for (int j = 1; j < in[0].length(); j++) {
				small.insert(new Node1(in[0].charAt(j) + ""));
			}
			for (int j = 1; j < in[1].length(); j++) {
				big.insert(new Node1(in[1].charAt(j) + ""));
			}
			boolean visited = false;
			for (Node1 x : big.preOrder) {
				if (small.check(small, x)) {
					visited = true;
					System.out.print(x.val + " ");
				}
			}
			if(!visited){
				System.out.print("NONE");
			}
			System.out.println();
		}
	}

}

class Node1 {
	static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private int size;
	public ArrayList<Node1> preOrder = new ArrayList<Node1>();
	public String val;
	private Node1 Lchild;
	private Node1 Rchild;

	public Node1(String val) {
		this.val = val;
		preOrder.add(this);
	}

	public void insert(Node1 i) {
		if (alpha.indexOf(i.val) <= alpha.indexOf(this.val)) {
			if (this.Lchild != null) {
				this.Lchild.insert(i);
			} else {
				this.Lchild = i;
			}
		} else {
			if (this.Rchild != null) {
				this.Rchild.insert(i);
			} else {
				this.Rchild = i;
			}
		}
		preOrder = new ArrayList<Node1>();
		preOrder(this);
	}
	public void preOrder(Node1 n) {
		if (n == null) {
			return;
		}
		preOrder.add(n);
		preOrder(n.Lchild);
		preOrder(n.Rchild);
	}

	public boolean check(Node1 n1, Node1 n2){
		if(n1==null&n2==null){
			return true;
		}
		if(n1==null&&n2!=null){
			return true;
		}
		if(n1!=null&&n2==null){
			return false;
		}
		return check(n1.Lchild, n2.Lchild)&&check(n1.Rchild, n2.Rchild);
	}
}
