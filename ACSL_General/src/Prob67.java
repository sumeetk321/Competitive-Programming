import java.util.Random;
import java.util.Scanner;

public class Prob67 {

	public static void main(String[] args) {
		double xcoordinate = 0.0;
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int iterations = scan.nextInt();
		int j = 0;
		while(j < iterations){
			if(Math.random() < 0.5)
				xcoordinate = xcoordinate + rand.nextDouble();
			if(Math.random() >= 0.5)
				xcoordinate = xcoordinate + -(rand.nextDouble());
			j++;
		}
		System.out.println("After " + iterations + " moves, X is at " + xcoordinate);
	}

}
