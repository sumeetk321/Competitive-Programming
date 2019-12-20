import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InvertBinaryTree {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("InvertBinaryTree.txt"));
		String[] vals = br.readLine().split(" ");
		BinaryTree correct = new BinaryTree(Integer.parseInt(vals[0]));
		BinaryTree wrong = new BinaryTree(Integer.parseInt(vals[0]));
		ArrayList<BinaryTree> collection = new ArrayList<BinaryTree>();
		for(int i = 1; i < vals.length; i++){
			correct.insertCorrect(new BinaryTree(Integer.parseInt(vals[i])));
		}
		correct.collectNodes(collection);
		int index = 0;
		int poweroftwo = 2;
		int powerindex = 0;
		System.out.println(vals[0]);
		while(index<collection.size()){
			if(powerindex==poweroftwo){
				poweroftwo*=2;
				powerindex = 0;
				System.out.println();
			}
			System.out.print(collection.get(index).val+" ");
			index++;
			powerindex++;
		}
		System.out.println("\n");
		System.out.println(vals[0]);
		collection = new ArrayList<BinaryTree>();
		for(int i = 1; i < vals.length; i++){
			wrong.insertWrong(new BinaryTree(Integer.parseInt(vals[i])));
		}
		wrong.collectNodes(collection);
		index = 0;
		poweroftwo = 2;
		powerindex = 0;
		while(index<collection.size()){
			if(powerindex==poweroftwo){
				poweroftwo*=2;
				powerindex = 0;
				System.out.println();
			}
			System.out.print(collection.get(index).val+" ");
			index++;
			powerindex++;
		}
	}

}

class BinaryTree {
	int val;
	private BinaryTree Lchild;
	private BinaryTree Rchild;

	public BinaryTree(int val) {
		this.val = val;
	}

	public void insertCorrect(BinaryTree in) {
		if (in.val <= this.val) {
			if (this.Lchild == null) {
				this.Lchild = in;
			} else {
				this.Lchild.insertCorrect(in);
			}
		} else if (in.val > this.val) {
			if (this.Rchild == null) {
				this.Rchild = in;
			} else {
				this.Rchild.insertCorrect(in);
			}
		}
	}
	public void insertWrong(BinaryTree in) {
		if (in.val > this.val) {
			if (this.Lchild == null) {
				this.Lchild = in;
			} else {
				this.Lchild.insertWrong(in);
			}
		} else if (in.val <= this.val) {
			if (this.Rchild == null) {
				this.Rchild = in;
			} else {
				this.Rchild.insertWrong(in);
			}
		}
	}
	public void collectNodes(ArrayList<BinaryTree> trees) {
		if (this.Lchild != null) {
			trees.add(this.Lchild);
		}
		if (this.Rchild != null) {
			trees.add(this.Rchild);
		}
		if (this.Lchild != null) {
			this.Lchild.collectNodes(trees);
		}
		if (this.Rchild != null) {
			this.Rchild.collectNodes(trees);
		}
	}
}
