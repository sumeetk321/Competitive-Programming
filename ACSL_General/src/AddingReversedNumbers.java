import java.util.Scanner;

public class AddingReversedNumbers {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for (int i = 0; i < N; i++) {
			int num1 = scan.nextInt();
			int num2 = scan.nextInt();
			String rev1 = new StringBuffer(num1 + "").reverse().toString();
			String rev2 = new StringBuffer(num2 + "").reverse().toString();
			num1 = Integer.parseInt(rev1);
			num2 = Integer.parseInt(rev2);
			int out = num1 + num2;
			String outstr = new StringBuffer(out + "").reverse().toString();
			System.out.println(Integer.parseInt(outstr));
		}

	}

}
