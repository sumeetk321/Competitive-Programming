import java.util.ArrayList;

public class Prob90 {

	public static void main(String[] args) {

		int[] data = {3, 1, 5, 7, 4, 12, -3, 8, -2};
		int largest1=0, largest2=0;
		largest1=data[0];
		largest2 = data[0];
		for(int i = 0; i<data.length;i++){
			
			if(data[i]>largest1){
				largest1=data[i];
			}
			if(data[i]>largest2 && data[i]<largest1){
				largest2=data[i];
			}
		}
		
		System.out.println("Largest Numbers: " + largest1 + " and " +largest2);
		
	}

}
