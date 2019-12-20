import java.util.Scanner;

public class Prob48 {

	   public static void main(String[] args) {
	       Scanner a = new Scanner(System.in);
	       int n = a.nextInt();
	       int result = factorial(n);
	       System.out.println("The factorial of " + n + " is " + result);
	   }

	   public static int factorial(int n) {
	       if (n == 0) {
	           return 1;
	       } else {
	           return n * factorial(n - 1);
	       }
	   }
	}
