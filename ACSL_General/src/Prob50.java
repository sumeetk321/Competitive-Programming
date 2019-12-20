import java.util.Scanner;

public class Prob50 {
	public static void main(String[] args){
		Scanner a = new Scanner(System.in);
		int input1 = a.nextInt();
		
		for(int i = 0; i < 99999; i++){
		if (input1==0){
			System.out.println("No integers were entered.");
		} else {
			Scanner b = new Scanner(System.in);
			int input2 = b.nextInt();
			System.out.println(input1);
		}
		}
	}
}
