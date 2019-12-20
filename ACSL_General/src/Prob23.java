import java.util.Scanner;

public class Prob23 {

	public static void main(String[] args){
		
		Scanner a = new Scanner(System.in);
		int a1 = a.nextInt();
		
		Scanner b = new Scanner(System.in);
		int b1 = a.nextInt();
		
		if(b1-a1 < 0){
			b1 = b1 + 99;
			System.out.println("Your age: " + (b1-a1));
		} else {
			System.out.println("Your age: " + (b1-a1));
		}
		
	}
	
}
