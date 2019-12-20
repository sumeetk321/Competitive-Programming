import java.util.Random;
import java.util.Scanner;

public class Guessthenumber {

	public static void main(String[] args) {
		int lower = 0, higher = 100;
		Scanner scan = new Scanner(System.in);
		boolean solved = false;
		int out = 50;
		while(!solved){
			
			System.out.println(out);
			String in = scan.nextLine();
			if(in.equals("H")){
				lower = out+1;
				out = Math.round((out+higher)/2);
			} else if(in.equals("L")){
				higher = out-1;
				out = Math.round((out+lower)/2);
			} else if(in.endsWith("E")){
				System.out.println(out+ " is your number");
				solved = true;
			}
			
			if(lower==higher) out = lower;
		}
	}

}
