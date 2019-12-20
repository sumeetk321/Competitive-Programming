import java.util.Scanner;

public class Prob27 {
	public static void main(String[] args){
		Scanner a = new Scanner(System.in);
		int age = a.nextInt();
		
		Scanner b = new Scanner(System.in);
		int time = b.nextInt();
		
		if (age > 13){
			if (time <= 1700){
				System.out.println("Price: $5");
			} else {
				System.out.println("Price: %8");
			}
		} else if (age <= 13) {
			if (time <=1700){
				System.out.println("Price: $2");
			} else if (time >= 2200){
				System.out.println("Not allowed!");
			} else {
				System.out.println("Price: $5");
			}
		}
	}
}
