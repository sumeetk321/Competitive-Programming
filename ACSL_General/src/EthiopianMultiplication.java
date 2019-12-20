import java.util.ArrayList;
import java.util.Scanner;

public class EthiopianMultiplication {

	public static void main(String[] args) {

		ArrayList<Long> column1 = new ArrayList<Long>(), column2 = new ArrayList<Long>();
		//long num1 = 777799998888l, num2 = 999988887777l;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter both numbers to be multipled one after the other: ");
		long num1 = scan.nextLong(), num2 = scan.nextLong();
		System.out.println("REAL ANSWER: " + (num1*num2));
		column1.add(num1);
		column2.add(num2);
		long answer = 0;
		while (halve(num1) >= 1) {
			column1.add(halve(num1));
			num1 = halve(num1);
		}
		for (long i = 0; i < column1.size() - 1; i++) {
			column2.add(dog(num2));
			num2 = dog(num2);
		}

		for (long x = 0; x < column1.size(); x++) {
			if (isEven(column1.get((int) x))) {
				column2.set((int) x, (long) 0);
			}
		}
		for (long x : column2) {
			answer += x;
		}

		System.out.println(answer);
	}

	public static long halve(long a) {
		a = (long) Math.floor(a / 2);
		return a;
	}

	public static long dog(long a) {
		a *= 2;
		return a;
	}

	public static boolean isEven(long a) {
		if (a % 2 == 0) {
			return true;
		} else
			return false;
	}

}
