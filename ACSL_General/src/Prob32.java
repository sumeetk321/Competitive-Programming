import java.util.Scanner;

public class Prob32 {
	public static void main(String[] args){
		Scanner a = new Scanner(System.in);
		double balanceS = a.nextInt();
		
		Scanner b = new Scanner(System.in);
		double balanceC = b.nextInt();
		if (balanceS > 1500){
			if(balanceC > 1000){
				System.out.println("Free!");
			} else if (balanceC < 1000){
				System.out.println("Charge: 0.15");
			}
		} else if (balanceC < 1500){
			System.out.println("Charge: 0.15");
		} else if (balanceS < 1000){
			System.out.println("Charge: 0.15");
		}
	}
}