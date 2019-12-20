import java.util.Scanner;

public class Prob28 {
	public static void main(String[] args){
		Scanner a = new Scanner(System.in);
		String item = a.nextLine();
		
		Scanner b = new Scanner(System.in);
		double price = b.nextDouble();
		
		Scanner c = new Scanner(System.in);
		boolean over = c.nextBoolean();
		
		if(price < 1000 && over == true){
			System.out.println("Price: " + (price + 7.00));
		} else if (price < 1000 && over == false){
			System.out.println("Price: " + (price+2.00));
		} else if (price > 1000 && over == true){
			System.out.println("Price: " + (price+8.00));
		} else if (price > 1000 && over == false){
			System.out.println("Price: " + (price+3.00));
		}
		
		
	}
}