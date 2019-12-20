import java.util.Scanner;

class Prob21 {
	
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		
		if(x>=220){
			if(x<=280) {
				
				System.out.println("Allowed!");
				
			} else if (x>280) {
				
				System.out.println("Not allowed");
				
			}
		} else if (x<220) {
			
			System.out.println("Not allowed!");
			
		}
		
	}
	
}
