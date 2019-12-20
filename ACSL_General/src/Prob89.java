import java.io.*;
public class Prob89 {

	public static void main(String[] args) {
		
		int[] data = {3, 2, 5, 7, 9, 12, 97, 24, 54};
		
		int allsum = 0;
		int evensum = 0;
		int oddsum = 0;
		
		for(int i = 0;i<data.length;i++){
			allsum+=data[i];
			if(i%2==0){
				evensum+=data[i];
			} else {
				oddsum+=data[i];
			}
		}
		System.out.println("Even: " + evensum + "\nOdd: " + oddsum + "\nAll: " + allsum);
	}

}
