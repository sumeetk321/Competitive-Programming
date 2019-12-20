import java.util.Scanner;

public class Prob42 {
	public static void main(String[] args)
	{
		Scanner a = new Scanner(System.in);
		double hours = a.nextDouble();
		
		Scanner b = new Scanner(System.in);
		double zones = b.nextDouble();
		
		Scanner c = new Scanner(System.in);
		double depart = c.nextDouble();
		
		Scanner d = new Scanner(System.in);
		double arrive = d.nextDouble();
		
		double DOR = (hours/2 + (zones-3) + depart + arrive)/10;
		
		System.out.println(DOR);
	}
}
