import java.util.Scanner;

public class Prob43 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		double n = a.nextDouble();
		
		double sumS = (n*(n+1)*(2*n + 1))/6;
		double SumC = (Math.pow(n, 2)*(Math.pow((n+1), 2)))/4;
		
		System.out.println(sumS + "\n" + SumC);
	}

}
