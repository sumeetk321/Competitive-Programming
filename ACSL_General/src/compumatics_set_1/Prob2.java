package compumatics_set_1;

public class Prob2 {

	public static void main(String[] args) {
		
		long first = 1;
		long second = 2;
		long thirdsum = 0;
		long evensum = 2;
		evensum+=second;
		while(thirdsum < 4000000){
			thirdsum = first + second;
			if(thirdsum%2==0){
				evensum+=thirdsum;
			}
			first = second;
			second = thirdsum;
			
			
		}
		
		System.out.println(evensum);
		
	}

}
