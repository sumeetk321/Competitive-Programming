import java.util.Scanner;

public class Prob30 {
	public static void main(String[] args){
		Scanner a = new Scanner(System.in);
		int Nitem = a.nextInt();
		
		Scanner b = new Scanner(System.in);
		int Htime = b.nextInt();
		
		if(Nitem > 3){
			System.out.println("Not recommended");
		}
		
		if(Nitem == 3){
			System.out.println("Heating time: " + 2*Htime + " Minutes.");
		}
		
		if(Nitem == 2){
			System.out.println("Heating time: " + 1.5*Htime + " Minutes");
		}
		
		if(Nitem == 1){
			System.out.println("Heating time: " + Htime + " Minutes");
		}
	}
}