package ACSL_JuniorDivision;

public class BinaryTree {
	public int val;
	public BinaryTree leftTree, rightTree;

	public BinaryTree(int a) {
		this.val = a;
		this.leftTree = null;
		this.rightTree = null;
	}

	public void insert(int node) {
		if (node <= this.val) {
			if (this.leftTree != null) {
				this.leftTree.insert(node);
			} else {

				this.leftTree = new BinaryTree(node);
			}
		} else if (node > this.val) {
			if (this.rightTree != null) {

				this.rightTree.insert(node);
			} else {

				this.rightTree = new BinaryTree(node);

			}
		}
	}
	
	public int leafnodes(BinaryTree t){
		int lleafnodes = 0, rleafnodes = 0;
		if(t.leftTree!=null){
			lleafnodes = leafnodes(t.leftTree);
		}
		if(t.rightTree!=null){
			rleafnodes = leafnodes(t.rightTree);
		}
		if(t.leftTree==null && t.rightTree==null){
			return 1;
		}
		return lleafnodes+rleafnodes;
	}
	
	public int depth(BinaryTree t, int d) {
		int leftd = d, rightd = d;

		if (t.leftTree != null) {
			leftd = depth(t.leftTree, d + 1);
		}
		if (t.rightTree != null) {
			rightd = depth(t.rightTree, d + 1);
		}

		return Math.max(leftd, rightd);
	}

}
