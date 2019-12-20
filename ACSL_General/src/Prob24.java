import java.util.Scanner;

public class Prob24 {
	public static void main(String[] args){
		Scanner a = new Scanner(System.in);
		double v = a.nextDouble();
		
		Scanner b = new Scanner(System.in);
		double t = b.nextDouble();
		
		if(v<=4){
			System.out.println(t);
		} else if (v>=45){
			System.out.println((1.6*t) - 55);
		} else {
			double wci = 91.4 + (91.4 - t)*((0.0203*v) - (0.304*(Math.sqrt(v))) - 0.474);
			System.out.println(Math.round(wci*100.0)/100.0);
		}
	}
}
