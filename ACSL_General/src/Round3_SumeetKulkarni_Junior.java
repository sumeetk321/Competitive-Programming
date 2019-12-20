import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Round3_SumeetKulkarni_Junior
public class Round3_SumeetKulkarni_Junior {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[][] board;
		String[] in;
		for (int i = 0; i < 5; i++) {
			System.out.println("Enter input: ");
			board = new int[8][8];
			in = sc.nextLine().split(", ");
			int rows = Integer.parseInt(in[0]);
			String[] lighted = new String[rows];
			String x = (in[in.length - 1]);
			for (int j = 1; j <= rows; j++) {
				lighted[j - 1] = in[j];
			}
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < 8; k++) {
					board[j][k] = 0;
				}
			}
			int row;
			ArrayList<String> tobeswitched = new ArrayList<String>();
			tobeswitched.add(x);
			for (String index : lighted) {
				row = 8 - Character.getNumericValue(index.charAt(0));
				for (int length = 1; length < index.length(); length++) {
					board[row][Character.getNumericValue(index.charAt(length)) - 1] = 1;
				}
			}
			if (Character.getNumericValue(x.charAt(0)) != 8) {
				tobeswitched.add(((Character.getNumericValue(x.charAt(0)) + 1) + "") + x.charAt(1));
			}
			if (Character.getNumericValue(x.charAt(0)) != 1) {
				tobeswitched.add(((Character.getNumericValue(x.charAt(0)) - 1) + "") + x.charAt(1));
			}
			if (Character.getNumericValue(x.charAt(1)) != 8) {
				tobeswitched.add(x.charAt(0) + ((Character.getNumericValue(x.charAt(1)) + 1) + ""));
			}
			if (Character.getNumericValue(x.charAt(1)) != 1) {
				tobeswitched.add(x.charAt(0) + ((Character.getNumericValue(x.charAt(1)) - 1) + ""));
			}
			int tmp = tobeswitched.size();
			for (int j = 1; j < tmp; j++) {
				if (Character.getNumericValue(tobeswitched.get(j).charAt(0)) != 8) {
					tobeswitched.add(((Character.getNumericValue(tobeswitched.get(j).charAt(0)) + 1) + "")
							+ tobeswitched.get(j).charAt(1));
				}
				if (Character.getNumericValue(tobeswitched.get(j).charAt(0)) != 1) {
					tobeswitched.add(((Character.getNumericValue(tobeswitched.get(j).charAt(0)) - 1) + "")
							+ tobeswitched.get(j).charAt(1));
				}
				if (Character.getNumericValue(tobeswitched.get(j).charAt(1)) != 8) {

					tobeswitched.add(tobeswitched.get(j).charAt(0)
							+ ((Character.getNumericValue(tobeswitched.get(j).charAt(1)) + 1) + ""));
				}
				if (Character.getNumericValue(tobeswitched.get(j).charAt(1)) != 1) {
					tobeswitched.add(tobeswitched.get(j).charAt(0)
							+ ((Character.getNumericValue(tobeswitched.get(j).charAt(1)) - 1) + ""));
				}
			}
			Set<String> temp = new HashSet<String>();
			temp.addAll(tobeswitched);
			tobeswitched.clear();
			tobeswitched.addAll(temp);
			for (String changer : tobeswitched) {
				if (board[8 - Character.getNumericValue(changer.charAt(0))][Character.getNumericValue(changer.charAt(1))
						- 1] == 0) {
					board[8 - Character.getNumericValue(changer.charAt(0))][Character.getNumericValue(changer.charAt(1))
							- 1] = 1;
				} else if (board[8 - Character.getNumericValue(changer.charAt(0))][Character
						.getNumericValue(changer.charAt(1)) - 1] == 1) {
					board[8 - Character.getNumericValue(changer.charAt(0))][Character.getNumericValue(changer.charAt(1))
							- 1] = 0;
				}
			}
			int counter = 0;
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < 8; k++) {
					counter+=board[j][k];
				}
			}
			System.out.println(counter);
		}

	}

}
