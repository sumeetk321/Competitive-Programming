import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Prob94 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Prob94.txt");
		Scanner scan = new Scanner(file);
		double[] data = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int j = 0;
		double avg = 0;
		double sum = 0;
		double farthest;
		while(scan.hasNextLine()){
			data[j] = scan.nextDouble();
			j++;
		}
		farthest = data[0];
		for(int i = 0;i<data.length;i++){
			sum +=data[i];
		}
		
		avg = sum/(data.length);
		
		for(int z = 0;z < data.length;z++){
			if(Math.abs(data[z] -avg) > Math.abs(farthest - data[z])) farthest = data[z];
		}
		System.out.println(farthest);
		
		sum = sum - farthest;
		
		
		for(int b = 0; b <data.length;b++){
			System.out.println("data[" + b+ "] = " + data[b]);
		}
		
		System.out.println("Average: " + avg);
		System.out.println("Most distant value: " + farthest);
		avg = sum/(data.length - 1);
		System.out.println("New Average: " + avg);
		
	}

}
