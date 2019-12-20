import java.util.Scanner;

class Prob16 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number: ");
		double x = scanner.nextDouble();
		double logx = Math.log(x)/Math.log(2);
		
		System.out.println("The log of " + x + " base 2 is " + logx);
	}
}
