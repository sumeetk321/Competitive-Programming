import java.util.Scanner;

public class Prob53 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		
		while(true){
			int weight = a.nextInt();
			if(weight==0){
				System.out.println("bye");
			} else if (weight <= 10){
				System.out.println("Shipping cost: $3.00");
			} else if (weight > 10){
				int poundover = weight - 10;
				double price = 3 + (0.25*poundover);
				
				System.out.println("Shipping cost: $" + price);
				
			}
		}
	}

}
