import java.util.Scanner;

public class Prob51 {
	public static void main(String[] args){
		Scanner a = new Scanner(System.in);
		int initmiles = a.nextInt();
		
		Scanner b = new Scanner(System.in);
		int finalmiles = b.nextInt();
		
		Scanner c = new Scanner(System.in);
		int gallons = c.nextInt();
		
		int difference = (finalmiles - initmiles);
		
		int mpg = difference/gallons;
		
		System.out.println("MPG: " + mpg);
		
	}
}
