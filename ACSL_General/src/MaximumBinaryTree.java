import java.util.ArrayList;
import java.util.Arrays;

public class MaximumBinaryTree {

	public static void main(String[] args) {
		//int[] arr = {3, 2, 1, 6, 0, 5};
		int[] arr = {4, 6, 2, 9, 7, 1};
		MaxTree tree = createTree(arr);
		tree.printAscending(tree);
	}

	public static MaxTree createTree(int[] arr) {
		if (arr.length == 1) {
			return new MaxTree(arr[0]);
		}
		if (arr.length == 0) {
			return null;
		}
		int maxindex = 0;
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				maxindex = i;
			}
		}
		MaxTree tree = new MaxTree(max);
		tree.setLChild(createTree(subarray(arr, 0, maxindex)));
		tree.setRChild(createTree(subarray(arr, maxindex + 1, arr.length)));
		return tree;
	}
	
	public static int[] subarray(int[] arr, int start, int end){
		int[] out = new int[end-start];
		for(int i = start; i < end; i++){
			out[i-start] = arr[i];
		}
		return out;
	}
	
	public static void recursePrint(String str, int depth){
		System.out.print(str.charAt(depth));
		depth--;
		if(depth==0){
			return;
		}
		recursePrint(str, depth);
	}
}

class MaxTree {
	MaxTree lchild;
	MaxTree rchild;
	int val;

	public MaxTree(int val) {
		this.val = val;
	}

	public void setLChild(MaxTree in) {
		this.lchild = in;
	}

	public void setRChild(MaxTree in) {
		this.rchild = in;
	}

	// print this node and all of its descendants
	public void printAscending(MaxTree mt) {
	    // is there actually a node here
	    // or was this called from a node with no children
	    if(mt != null) {
	        // print everything that's earlier than this node
	        printAscending(mt.lchild);   

	        // print this node's value
	        System.out.println(mt.val);

	        // print everything that's afterthan this node
	        printAscending(mt.rchild);  
	    }
	}
}