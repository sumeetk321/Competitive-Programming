import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Prob95_1 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Prob94.txt");
		Scanner scan = new Scanner(file);
		double[] data = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		double d1 = 0, d2 = 0, d3 = 0;
		int j = 0;
		double indexoffarthest1 = 0, indexoffarthest2 = 0, indexoffarthest3 = 0;
		double avg = 0;
		double sum = 0;
		while(scan.hasNextLine()){
			data[j] = scan.nextDouble();
			j++;
		}
		for(int i = 0;i<data.length;i++){
			sum +=data[i];
		}
		avg = sum/(data.length);
		double[] distance = {Math.abs(avg-data[0]), Math.abs(avg-data[1]), Math.abs(avg-data[2]), Math.abs(avg-data[3]), Math.abs(avg-data[4]), Math.abs(avg-data[5]), Math.abs(avg-data[6]), Math.abs(avg-data[7]), Math.abs(avg-data[8]), Math.abs(avg-data[9]), Math.abs(avg-data[10]), Math.abs(avg-data[11]), Math.abs(avg-data[12])};
		
		double[] distanceclone = distance.clone();
		Arrays.sort(distance);
		
		indexoffarthest1 = distance[distance.length-1];
		indexoffarthest2 = distance[distance.length-2];
		indexoffarthest3 = distance[distance.length-3];
		for(int b = 0; b <data.length;b++){
			System.out.println("data[" + b+ "] = " + data[b]);
		}
		System.out.println("Average: " + avg);
		
		for(int i = 0; i < distance.length;i++){
			if(indexoffarthest1==distanceclone[i]){
				System.out.println("Most distant value: " + data[i]);
				d1 = distanceclone[i];
				sum = sum - data[i];
				avg = sum/(data.length-1);
				distance = new double[] {Math.abs(avg-data[0]), Math.abs(avg-data[1]), Math.abs(avg-data[2]), Math.abs(avg-data[3]), Math.abs(avg-data[4]), Math.abs(avg-data[5]), Math.abs(avg-data[6]), Math.abs(avg-data[7]), Math.abs(avg-data[8]), Math.abs(avg-data[9]), Math.abs(avg-data[10]), Math.abs(avg-data[11]), Math.abs(avg-data[12])};
				Arrays.sort(distance);
				System.out.println("New Average: " + avg);
				break;
			}
		}
		for(int i = 0; i < distance.length;i++){
			if(indexoffarthest2==d1) continue;
			if(indexoffarthest2==distanceclone[i]){
				System.out.println("Most distant value: " + data[i]);
				d2 = distanceclone[i];
				sum = sum - data[i];
				avg = sum/(data.length-2);
				distance = new double[] {Math.abs(avg-data[0]), Math.abs(avg-data[1]), Math.abs(avg-data[2]), Math.abs(avg-data[3]), Math.abs(avg-data[4]), Math.abs(avg-data[5]), Math.abs(avg-data[6]), Math.abs(avg-data[7]), Math.abs(avg-data[8]), Math.abs(avg-data[9]), Math.abs(avg-data[10]), Math.abs(avg-data[11]), Math.abs(avg-data[12])};
				Arrays.sort(distance);
				System.out.println("New Average: " + avg);
				break;
			}
		}
		for(int i = 0; i < distance.length;i++){
			if(indexoffarthest2==d1) continue;
			if(indexoffarthest3==distanceclone[i]){
				System.out.println("Most distant value: " + data[i]);
				sum = sum - data[i];
				avg = sum/(data.length-3);
				distance = new double[] {Math.abs(avg-data[0]), Math.abs(avg-data[1]), Math.abs(avg-data[2]), Math.abs(avg-data[3]), Math.abs(avg-data[4]), Math.abs(avg-data[5]), Math.abs(avg-data[6]), Math.abs(avg-data[7]), Math.abs(avg-data[8]), Math.abs(avg-data[9]), Math.abs(avg-data[10]), Math.abs(avg-data[11]), Math.abs(avg-data[12])};
				Arrays.sort(distance);
				System.out.println("New Average: " + avg);
				break;
			}
		}
		
		
		
	}
	
	
		
		
}

