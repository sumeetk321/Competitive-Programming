import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LISPExpressions {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("LISPExpressions.txt");
		Scanner scan = new Scanner(file);
		for (int i = 0; i < 10; i++) {

			if (i == 0 || i == 5) {
				String in = scan.nextLine();
				String test = in.substring(2, in.length() - 1);
				System.out.println("'(" + new StringBuilder(test).reverse().toString() + ")");
			} else if (i == 1 || i == 6) {
				String in = scan.nextLine();
				String test = in.substring(2, in.length() - 1);
				System.out.print("'(");
				int count = 1;
				String[] arr = test.split(" ");
				String teststr = arr[0];
				for (int j = 0; j < arr.length - 1; j++) {

					if (arr[j].equals(arr[j + 1]) && arr[j].equals(teststr)) {
						count++;
						if (j == arr.length - 2) {
							System.out.print("(" + count + " " + arr[j] + ")");
						}
						continue;
					} else {
						System.out.print("(" + count + " " + arr[j] + ") ");
						count = 1;
						teststr = arr[j + 1];
					}
				}
				System.out.print(")");
				System.out.println();
			} else if (i == 2 || i == 7) {
				String in = scan.nextLine();
				String test = in.substring(2, in.length() - 1);
				System.out.print("'(");
				int count = 1;
				String[] arr = test.split(" ");
				String teststr = arr[0];
				for (int j = 0; j < arr.length - 1; j++) {

					if (arr[j].equals(arr[j + 1]) && arr[j].equals(teststr)) {
						count++;
						if (j == arr.length - 2) {
							if (count > 1) {
								System.out.print("(" + count + " " + arr[j] + ")");
							} else {
								System.out.print(arr[j]);
							}
						}
						continue;
					} else {
						if (count > 1) {
							System.out.print("(" + count + " " + arr[j] + ") ");
						} else {
							System.out.print(arr[j] + " ");
						}
						count = 1;
						teststr = arr[j + 1];
					}
				}
				System.out.print(")");
				System.out.println();
			} else if (i == 3 || i == 8) {
				String in = scan.nextLine();
				String test = in.substring(2, in.length() - 1);
				int index = 0;
				int N = Character.getNumericValue(test.charAt(test.length() - 1)) - 1;
				int tmp = N + 1;
				ArrayList<String> cells = new ArrayList<String>();
				while (index < test.length() - 6) {
					cells.add(test.substring(index, index + 5));
					index += 6;
				}
				for (; N < cells.size(); N += tmp) {
					cells.set(N, "");
				}
				System.out.print("'(");
				for (String x : cells) {
					if (x.length() > 0) {
						System.out.print(x + " ");
					}
				}
				System.out.print(tmp + ")");
				System.out.println();
			} else if (i == 4 || i == 9) {
				String in = scan.nextLine();
				String test = in.substring(2, in.length() - 1);
				int index = 0;
				int N = Character.getNumericValue(test.charAt(test.length() - 1));
				ArrayList<String> cells = new ArrayList<String>();
				while (index < test.length() - 6) {
					cells.add(test.substring(index, index + 5));
					index += 6;
				}
				System.out.print("'(");
				int k;
				for (k = 0; k < N; k++) {
					if (k < N - 1) {
						System.out.print(cells.get(k) + " ");
					} else {
						System.out.print(cells.get(k));
					}
				}
				System.out.print(") '(");

				for (k = N; k < cells.size(); k++) {
					System.out.print(cells.get(k) + " ");
				}
				System.out.println(N+")");
				System.out.println();
			}
		}
	}

}
