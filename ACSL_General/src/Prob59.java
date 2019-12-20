import java.util.Scanner;

public class Prob59 {

	public static void main(String[] args) {
		
		Scanner a = new Scanner(System.in);
		System.out.println("Enter 'B' (1 divided by B), first guess and no. of iterations");
		double  b = a.nextDouble();
		double fguess = a.nextDouble();
		double iterations = a.nextDouble();
		
		
		for(int i = 0;i<iterations;i++){
			fguess = fguess*(2-(b*fguess));
		}
		
		System.out.println("Estimation: " + fguess);
	}

}
