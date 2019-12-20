import java.util.Scanner;
class Prob20 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double c = s.nextDouble();
		
		Scanner s1 = new Scanner(System.in);
		double r = s1.nextDouble();
		
		Scanner s2 = new Scanner(System.in);
		double m = s2.nextDouble();
		
		if (((c*r)/100)*m >= 200) {
			System.out.println("Safe to Proceed");
		} else {
			System.out.println("Get Gas!");
		}
	}
}
