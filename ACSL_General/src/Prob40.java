import java.util.Scanner;

public class Prob40 {
	public static void main(String[] args)
	{
		Scanner a = new Scanner(System.in);
		int input = a.nextInt();
		
		int counter = 1;
		
		double sum = (1.0/counter);
		
		for (int i = 0; i <= input; i++)
		{
			sum = sum + 1.0/(counter + 1);
			counter++;
		}
		System.out.println(sum);
	}
}
