import java.util.Scanner;

public class Prob29 {
	public static void main(String[] args){
		Scanner a = new Scanner(System.in);
		int Tair = a.nextInt();
		
		Scanner b = new Scanner(System.in);
		int Tsteam = b.nextInt();
		
		if(Tair >= 373){
			System.out.println("Efficiency:\t" + ((1-Tair)/Tsteam));
		} else {
			System.out.println("No steam.");
		}
	}
}