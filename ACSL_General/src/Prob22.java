import java.util.Scanner;

public class Prob22 {
	public static void main(String[] args){
		Scanner a = new Scanner(System.in);
		System.out.println("The price per pound of package 'A'");
		double a1 = a.nextDouble();
		
		Scanner b = new Scanner(System.in);
		System.out.println("The percent lean of'A'");
		double b1 = a.nextDouble();
		
		Scanner c = new Scanner(System.in);
		System.out.println("The price per pound of package 'B'");
		double c1 = a.nextDouble();
		
		Scanner d = new Scanner(System.in);
		System.out.println("The percent lean of 'B'");
		double d1 = a.nextDouble();
		
		double valA = (Math.round(((100.0/b1)*a1)*10)/10.0);
		double valB = (Math.round(((100.0/d1)*c1)*10)/10.0);
		
		if(valA < valB){
		System.out.println("Price per pound of package A:\t" + valA + "\nPrice per pound of package B:\t" + valB + "\nPackage A is the best value");
	} else {
		System.out.println("Price per pound of package A:\t" + valA + "\nPrice per pound of package B:\t" + valB + "\nPackage B is the best value");
	}
	}
}
