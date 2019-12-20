import java.util.Scanner;

public class Prob38 {
	public static void main(String[] args){
		
		Scanner a = new Scanner(System.in);
		String in1 = a.nextLine();
		
		Scanner b = new Scanner(System.in);
		String in2 = b.nextLine();
		
		int lenbetween = in1.length() + in2.length();
		int dots = 30 - lenbetween;
		
		String dot = ".";
		System.out.print(in1);
		
		for (int i = 0; i <= dots; i++)
		{
			System.out.print(dot);
		
		}
		System.out.println(in2);
	}
}

