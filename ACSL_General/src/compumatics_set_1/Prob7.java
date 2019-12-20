package compumatics_set_1;

public class Prob7 {

	public static void main(String[] args) {
		int counter = 1;
		int num = 1;
		
		while(counter<=10002){
			if(isPrime(num)) counter++;
			if(counter==10001){
				System.out.println(num);
				System.exit(0);
			}
			
			num++;
			continue;
		}
		
		
		
	}
	
	static long input;
	private static boolean isPrime(long a) {
		input = a;
		long i = 2;
		long factors = 2;
		
		while(i <= input){
			if (input==1) return false;
			
			if (input%i == 0){
				factors++;
			}
			
			if (i>(input/2)){
				if (factors==2){
					return true;
				} else {
					return false;
				}
			}
			i++;
			
		}
		return false;
		
		
	}

}
