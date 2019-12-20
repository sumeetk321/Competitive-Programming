package compumatics_set_1;

public class Prob6 {

	public static void main(String[] args) {

		long sqsum = 0, sum = 0;
		double number = 0;
		
		sqsum = ((100)*(100+1)*(200+1))/6;
		//System.out.println(sqsum);
		
		
		for(int i = 1; i <= 100; i++){
			sum+=i;
		}
		//System.out.println(sum);
		
		sum = (long) Math.pow(sum, 2);
		//System.out.println(sum);
		System.out.println(sum - sqsum);
		
	}

}
