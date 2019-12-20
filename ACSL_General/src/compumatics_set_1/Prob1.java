package compumatics_set_1;

public class Prob1 {

	public static void main(String[] args) {
		int sum = 0;
		for(int z = 1; z < 1000; z++){
			
			if(z%3==0){
				sum = sum + z;
			} else if(z%5==0){
				sum = sum + z;
			} else if(z%15 == 0){
				sum = sum - (z);
			}
			
			
		}
		
		System.out.println(sum);
	}
}
