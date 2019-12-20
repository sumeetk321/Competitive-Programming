import java.util.Scanner;

public class Prob25 {
	
	public static void main(String[] args){
		Scanner a = new Scanner(System.in);
		int a1 = a.nextInt();
		
		Scanner b = new Scanner(System.in);
		int b1 = b.nextInt();
		
		Scanner c = new Scanner(System.in);
		int c1 = c.nextInt();
		
		a1 = a1*31536000;
		b1 = b1*2592000;
		c1 = c1*86400;
		
		System.out.println("Age in seconds: " + (a1+b1+c1));
	}
	
}
