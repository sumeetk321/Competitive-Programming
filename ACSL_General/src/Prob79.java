
public class Prob79 {

	public static void main(String[] args) {
		double n = 0;
		int t = 0;
		int j= 0;
		
		for(;t<25;t++){
			double power = Math.pow(0.83, t);
			n = 220 / ((10*power) + 1);
			if(n>80) System.out.println("Years: " + t);
			System.out.println(n);
		}
	}

}
