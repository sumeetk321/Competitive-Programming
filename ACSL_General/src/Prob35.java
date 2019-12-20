import java.util.Scanner;

	public class Prob35 {
		public static void main(String[] args){
			
			Scanner a = new Scanner(System.in);
			double rfpres = a.nextDouble();
			if(rfpres<35 || rfpres>45){
				System.out.println("Warning: pressure is out of range");
			}
			Scanner b = new Scanner(System.in);
			double lfpres = a.nextDouble();
			if(lfpres<35 || lfpres>45){
				System.out.println("Warning: pressure is out of range");
			}
			Scanner c = new Scanner(System.in);
			double rbpres = a.nextDouble();
			if(rbpres<35 || rbpres>45){
				System.out.println("Warning: pressure is out of range");
			}
			Scanner d = new Scanner(System.in);
			double lbpres = a.nextDouble();
			if(lbpres<35 || lbpres>45){
				System.out.println("Warning: pressure is out of range");
			}
			if(rfpres == lfpres && rbpres == lbpres){
				System.out.println("Inflation is OK.");
			} else if (rfpres <= lfpres - 4 || rbpres <= lbpres - 4 || rfpres <= lfpres + 4 || rbpres <= lbpres - 4){
				System.out.println("Inflation is unsafe; repressurize the tires.");
			} else if (rfpres >= lfpres - 3 || rbpres >= lbpres - 3 || rfpres >= lfpres + 3 || rbpres >= lbpres - 3){
				System.out.println("Inflation is OK");
			}
		}
}