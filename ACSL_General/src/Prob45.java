import java.util.Scanner;

public class Prob45 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int init = a.nextInt();
		
		String star = "*";
		
		for (int i = 0; i < init; i++)
		{
			for (int j = i; j < init; j++)
			{
				System.out.print(star);
			}
			
			System.out.print("\n");
			
			}
		}
	}


