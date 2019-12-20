import java.util.Scanner;

	public class Prob33 {
		public static void main(String[] args){
			
			Scanner a = new Scanner(System.in);
			double rfpres = a.nextDouble();
			
			Scanner b = new Scanner(System.in);
			double lfpres = a.nextDouble();
			
			Scanner c = new Scanner(System.in);
			double rbpres = a.nextDouble();
			
			Scanner d = new Scanner(System.in);
			double lbpres = a.nextDouble();
			
			if(rfpres == lfpres && rbpres == lbpres){
				System.out.println("Inflation is OK.");
			} else {
				System.out.println("Inflation is unsafe; repressurize the tires.");
			}
		}
}