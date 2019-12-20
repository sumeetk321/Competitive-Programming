import java.util.Scanner;

public class Prob60 {

	public static void main(String[] args) {
		
		Scanner a = new Scanner(System.in);
		int in1 = a.nextInt();
		
		while(true){
			
			if(in1==1){
				System.exit(0);
			} else if(in1%2==0){
				in1 = in1/2;
				System.out.println(in1);
			} else {
				in1 = (3*in1) + 1;
				System.out.println(in1);
			}
				
		}
	}

}
