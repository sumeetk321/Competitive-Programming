package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class ACSL_Trees_JuniorDivision {

	static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Trees2.txt");
		Scanner scan = new Scanner(file);
		for (int i = 0; i < 5; i++) {
			String in = scan.nextLine();
			int[] tempstr = new int[in.length()];
			for (int j = 0; j < tempstr.length; j++) {
				tempstr[j] = alphabet.indexOf(in.charAt(j));
			}
			
			BinaryTree tree = new BinaryTree(tempstr[0]);
			
			for(int j = 1; j < tempstr.length; j++){
				tree.insert(tempstr[j]);
			}
			System.out.println(tree.depth(tree, 0));
			
			
		}

	}

}
