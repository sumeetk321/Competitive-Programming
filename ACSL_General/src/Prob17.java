import java.util.Scanner;
class Prob17 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		float x = scanner.nextFloat();
		
		Scanner scanner1 = new Scanner (System.in);
		float y = scanner1.nextFloat();
		
		float arithmn = (x+y)/2;
		
		double harmean = 2/((1/x)+(1/y));
		
		System.out.println("Arithmetic mean:\t" + arithmn + "\nHarmonic Mean: \t" + harmean);
	}
}
