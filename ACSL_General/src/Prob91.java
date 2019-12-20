import java.io.*;
public class Prob91 {

	public static void main(String[] args) {

		int[] data = {3, 1, 5, 7, 4, 12, -3, 8, -2};
		int j = 0;
		int closest = 0;
		while(j<data.length){
			closest = data[j];
			if(Math.abs(data[j]) < Math.abs(closest)) closest = data[j]; 
			j++;
		}
		System.out.println(closest);
	}

}
