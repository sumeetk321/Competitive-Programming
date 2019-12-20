import java.util.Scanner;

public class Prob56 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		double mpay = a.nextDouble();
		
		double balance = 1000;
				
		int month = 1;
		
		while(true){
			
			double topay = month*mpay;
			balance = balance + (balance*0.015) - mpay;
			System.out.println("Month: " + month + "\tbalance:" + balance + "\ttotal payments: " + topay);
			month++;
			if(balance<=0)
				System.exit(0);
		}
	}

}
