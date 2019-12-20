import java.util.Scanner;

public class Prob41 {
	public static void main(String[] args)
	{
		Scanner a = new Scanner(System.in);
		double x = a.nextFloat();
		
		Scanner b = new Scanner(System.in);
		double y = b.nextFloat();
		
		double avg = (x + y)/2;
		
		double avgSquare = (Math.pow(x, 2) + Math.pow(y, 2))/2;
		
		double SD = Math.sqrt(avgSquare - (Math.pow(avg, 2)));
		
		System.out.println(SD);
		
	}
}
