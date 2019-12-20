import java.util.Scanner;

public class Prob44 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		double in1 = a.nextDouble();
		
		Scanner b = new Scanner(System.in);
		double in2 = b.nextDouble();
		
		double pow = Math.pow(in1, in2);
		
		System.out.println(pow);
	}

}
