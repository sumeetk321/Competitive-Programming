package compumatics_set_1;

public class Prob5 {

	public static void main(String[] args) {
		
		int counter = 1;
		boolean found = false;
		
		loop1: while(found==false){
			loop: for(int i = 1; i <= 20; i++){
				if(i==20) {
					found = true;
					break loop1;
				}
				if(counter%i==0){
					continue loop;
				} else {
					break loop;
				}
				
			}
			counter++;
		}
		
		System.out.println(counter);
		
	}

}
