import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class krypto {

	static ArrayList<Character> operations = new ArrayList<Character>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(", ");
		int[] numbers = new int[input.length - 1];
		int desiredsum = Integer.parseInt(input[input.length - 1]);
		int i, j;

		for (i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(input[i]);
			System.out.println(numbers[i]);
		}

		recurse(numbers, 0, numbers[i], desiredsum, new ArrayList<Character>());

		for (i = 0; i < operations.size(); i++) {
			System.out.println(operations.get(i));
		}

	}

	public static void recurse(int[] numbers, int index, int tempsum, int desiredsum, ArrayList<Character> operation) {
		
		if (index == numbers.length - 1) {

			if (tempsum == desiredsum) {
				for (int i = 0; i < operation.size(); i++) {
					operations.add(operation.get(i));
				}
			}

			return;
		}

		System.out.println(numbers[index+1]);
		System.out.println(tempsum);
		System.out.println();
		
		operation.add('+');
		recurse(numbers, index + 1, tempsum + numbers[index + 1], desiredsum, operation);
		operation.remove(operation.size()-1);

		operation.add('-');
		recurse(numbers, index + 1, tempsum - numbers[index + 1], desiredsum, operation);
		operation.remove(operation.size()-1);
		
		operation.add('*');
		recurse(numbers, index + 1, tempsum * numbers[index + 1], desiredsum, operation);
		operation.remove(operation.size()-1);

		operation.add('/');
		recurse(numbers, index + 1, tempsum / numbers[index + 1], desiredsum, operation);
		operation.remove(operation.size()-1);

	}

}
