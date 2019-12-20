import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cycles {
	static String alpha = "ABCDE";
	static int cycles = 0;
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Cycles.txt");
		Scanner scan = new Scanner(file);
		for (int i = 0; i < 13; i++) {
			String[] in = scan.nextLine().split(", ");
			int size = Integer.parseInt(in[0]);
			int[][] adjmat = new int[size][size];
			ArrayList<ArrayList<String>> possibles = new ArrayList<ArrayList<String>>();

			for (int j = 0; j < size; j++) {
				possibles.add(new ArrayList<String>());
				String in1 = in[j + 1];
				for (int k = 0; k < size; k++) {
					adjmat[j][k] = Character.getNumericValue(in1.charAt(k));
					if (adjmat[j][k] == 1) {
						possibles.get(j).add(alpha.charAt(k) + "");
					}
				}
			}
			for(int j = 0; j < size; j++){
				recurse(alpha.charAt(j)+"", possibles, new ArrayList<String>());
			}
			System.out.print(cycles);
			System.out.println();
			cycles = 0;
		}
	}

	public static void recurse(String start, ArrayList<ArrayList<String>> possibles, ArrayList<String> visited) {
		boolean added = false;
		if (visited.contains(start)) {
			if ((start.equals(visited.get(0)))) {
				visited.add(start);
				for (String x : visited) {
					System.out.print(x);
				}
				System.out.print(" ");
				cycles++;
				visited.remove(visited.size()-1);
				return;
			} else {
				return;
			}
		}
		if (visited.size() == 0) {
			added = true;
			visited.add(start);
		}
		if (!added) {
			visited.add(start);
		}
		if (alpha.indexOf(visited.get(0)) > alpha.indexOf(start)) {
			visited.remove(visited.size()-1);
			return;
		}
		
		int index = alpha.indexOf(start);
		for (String x : possibles.get(index)) {
			recurse(x, possibles, visited);
		}
		visited.remove(visited.size()-1);
	}

}
