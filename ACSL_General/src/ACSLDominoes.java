import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ACSLDominoes {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("ACSLDominoes.txt");
		Scanner scan = new Scanner(file);
		String[] bin5 = { "00000", "00001", "00010", "00011", "00100", "00101", "00110", "00111", "01000", "01001",
				"01010", "01011", "01100", "01101", "01110", "01111", "10000", "10001", "10010", "10011", "10100",
				"10101", "10110", "10111", "11000", "11001", "11010", "11011", "11100", "11101", "11110", "11111" };

		for (int i = 0; i < 12; i++) {
			String[] in = scan.nextLine().split(", ");
			String[] domino = new String[10];
			String[] compare = domino;
			ArrayList<String> tiles = new ArrayList<String>();
			int a = 0;
			for (int j = 5; j < 15; j += 2) {
				domino[Integer.parseInt(in[a]) - 1] = (in[j] + "" + in[j + 1]);
				a++;
			}
			for (int j = 15; j < in.length; j += 2) {
				String x = in[j] + "" + in[j + 1];
				tiles.add(x);
			}
			int index = 0;
			boolean done = false;
			for (List<String> x : listPermutations(tiles)) {

				String[] tmp = new String[10];
				ArrayList<Integer> indices = new ArrayList<Integer>();
				for (int j = 0; j < 10; j++) {
					tmp[j] = compare[j];
				}
				for (int j = 0; j < compare.length; j++) {
					if (compare[j] == null) {
						compare[j] = x.get(index);
						indices.add(j);
						index++;
					}
				}

				String[] tmp1 = new String[10];
				for (int j = 0; j < 10; j++) {
					tmp1[j] = compare[j];
				}
				for (String y : bin5) {
					for (int j = 0; j < 5; j++) {
						if (y.charAt(j) == '0') {
							continue;
						} else {
							compare[indices.get(j)] = compare[indices.get(j)].charAt(1) + ""
									+ compare[indices.get(j)].charAt(0);
						}
					}

					boolean fits = true;
					if (fits(compare)) {
						fits = true;
					} else {
						compare[compare.length - 1] = compare[compare.length - 1].charAt(1) + ""
								+ compare[compare.length - 1].charAt(0);
						if (fits(compare)) {
							fits = true;
						} else {
							fits = false;
						}
						if (!fits) {
							compare = tmp1;
							compare[compare.length - 7] = compare[compare.length - 7].charAt(1) + ""
									+ compare[compare.length - 7].charAt(0);
							compare[compare.length - 3] = compare[compare.length - 3].charAt(1) + ""
									+ compare[compare.length - 3].charAt(0);
							if (fits(compare)) {
								fits = true;
							} else {
								fits = false;
							}
						}

					}
					if (fits) {
						done = true;
						for (int k = 0; k < 5; k++) {
							System.out.println(compare[indices.get(k)].charAt(0) + ", "
									+ compare[indices.get(k)].charAt(1) + ", " + (indices.get(k) + 1));
						}
						break;
					} else {

						compare = tmp1;
						continue;
					}
				}
				compare = tmp;
				index = 0;
			}
			if (!done) {
				System.out.println("CAN'T BE DONE");
			}
			System.out.println();
		}

	}

	public static List<List<String>> listPermutations(List<String> list) {

		if (list.size() == 0) {
			List<List<String>> result = new ArrayList<List<String>>();
			result.add(new ArrayList<String>());
			return result;
		}

		List<List<String>> returnMe = new ArrayList<List<String>>();

		String firstElement = list.remove(0);

		List<List<String>> recursiveReturn = listPermutations(list);
		for (List<String> li : recursiveReturn) {

			for (int index = 0; index <= li.size(); index++) {
				List<String> temp = new ArrayList<String>(li);
				temp.add(index, firstElement);
				returnMe.add(temp);
			}

		}
		return returnMe;
	}

	public static boolean fits(String[] in) {
		if (in[0].charAt(1) == in[1].charAt(0) && in[1].charAt(1) == in[2].charAt(0)
				&& in[2].charAt(1) == in[3].charAt(0) && in[3].charAt(1) == in[4].charAt(0)
				&& in[4].charAt(1) == in[5].charAt(0) && in[5].charAt(1) == in[6].charAt(0)
				&& in[6].charAt(1) == in[7].charAt(0) && in[7].charAt(1) == in[8].charAt(0)
				&& in[8].charAt(1) == in[9].charAt(0)) {
			return true;
		} else {
			return false;
		}
	}

}
