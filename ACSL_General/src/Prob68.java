import java.util.Random;
import java.util.Scanner;

public class Prob68 {

	public static void main(String[] args) {
		
		double xcoord, ycoord;
		xcoord = 0.0;
		ycoord = 0.0;
		
		Scanner scan = new Scanner(System.in);
		long iterations = scan.nextLong();
		Random rand = new Random();
		
		double distance = 0;
		int j = 0;
		while(j<iterations){
			xcoord = xcoord + (-1) + (2) * rand.nextDouble();
			ycoord = ycoord + (-1) + (2) * rand.nextDouble();
			j++;
		}
		distance = Math.sqrt((Math.pow(xcoord, 2) + Math.pow(ycoord, 2)));
		System.out.println("X coordinate: " + xcoord + "\tY coordinate: " + ycoord + "\tTotal distance: " + distance);
		
	}

}
