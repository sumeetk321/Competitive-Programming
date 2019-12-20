import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Prob96 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Prob94.txt");
		Scanner scan = new Scanner(file);
		double[] data = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		double d1 = 0, d2 = 0, d3 = 0, d4 = 0, d5 =0, d6=0, d7=0, d8=0, d9=0, d10=0, d11=0, d12=0, d13=0;
		int j = 0;
		double indexoffarthest1, indexoffarthest2, indexoffarthest3, indexoffarthest4, indexoffarthest5 = 0, indexoffarthest6, indexoffarthest7, indexoffarthest8, indexoffarthest9, indexoffarthest10, indexoffarthest11, indexoffarthest12, indexoffarthest13;
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
		indexoffarthest4 = distance[distance.length-4];
		indexoffarthest5 = distance[distance.length-5];
		indexoffarthest6 = distance[distance.length-6];
		indexoffarthest7 = distance[distance.length-7];
		indexoffarthest8 = distance[distance.length-8];
		indexoffarthest9 = distance[distance.length-9];
		indexoffarthest10 = distance[distance.length-10];
		indexoffarthest11 = distance[distance.length-11];
		indexoffarthest12 = distance[distance.length-12];
		indexoffarthest13 = distance[distance.length-13];

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
			
			if(indexoffarthest3==d2) continue;
			
			if(indexoffarthest3==distanceclone[i]){
				System.out.println("Most distant value: " + data[i]);
				d3 = data[i];
				sum = sum - data[i];
				avg = sum/(data.length-3);
				distance = new double[] {Math.abs(avg-data[0]), Math.abs(avg-data[1]), Math.abs(avg-data[2]), Math.abs(avg-data[3]), Math.abs(avg-data[4]), Math.abs(avg-data[5]), Math.abs(avg-data[6]), Math.abs(avg-data[7]), Math.abs(avg-data[8]), Math.abs(avg-data[9]), Math.abs(avg-data[10]), Math.abs(avg-data[11]), Math.abs(avg-data[12])};
				Arrays.sort(distance);
				System.out.println("New Average: " + avg);
				break;
			}
		}
		for(int i = 0; i < distance.length;i++){
			if(indexoffarthest4==d3) continue;
			if(indexoffarthest4==distanceclone[i]){
				System.out.println("Most distant value: " + data[i]);
				d4 = data[i];
				sum = sum - data[i];
				avg = sum/(data.length-4);
				distance = new double[] {Math.abs(avg-data[0]), Math.abs(avg-data[1]), Math.abs(avg-data[2]), Math.abs(avg-data[3]), Math.abs(avg-data[4]), Math.abs(avg-data[5]), Math.abs(avg-data[6]), Math.abs(avg-data[7]), Math.abs(avg-data[8]), Math.abs(avg-data[9]), Math.abs(avg-data[10]), Math.abs(avg-data[11]), Math.abs(avg-data[12])};
				Arrays.sort(distance);
				System.out.println("New Average: " + avg);
				break;
			}
		}
		
		for(int i = 0; i < distance.length;i++){
			if(indexoffarthest5==d4) continue;
			if(indexoffarthest5==distanceclone[i]){
				System.out.println("Most distant value: " + data[i]);
				d5=data[i];
				sum = sum - data[i];
				avg = sum/(data.length-5);
				distance = new double[] {Math.abs(avg-data[0]), Math.abs(avg-data[1]), Math.abs(avg-data[2]), Math.abs(avg-data[3]), Math.abs(avg-data[4]), Math.abs(avg-data[5]), Math.abs(avg-data[6]), Math.abs(avg-data[7]), Math.abs(avg-data[8]), Math.abs(avg-data[9]), Math.abs(avg-data[10]), Math.abs(avg-data[11]), Math.abs(avg-data[12])};
				Arrays.sort(distance);
				System.out.println("New Average: " + avg);
				break;
			}
		}
		for(int i = 0; i < distance.length;i++){
			if(indexoffarthest6==d5) continue;
			if(indexoffarthest6==distanceclone[i]){
				System.out.println("Most distant value: " + data[i]);
				d6 = data[i];
				sum = sum - data[i];
				avg = sum/(data.length-6);
				distance = new double[] {Math.abs(avg-data[0]), Math.abs(avg-data[1]), Math.abs(avg-data[2]), Math.abs(avg-data[3]), Math.abs(avg-data[4]), Math.abs(avg-data[5]), Math.abs(avg-data[6]), Math.abs(avg-data[7]), Math.abs(avg-data[8]), Math.abs(avg-data[9]), Math.abs(avg-data[10]), Math.abs(avg-data[11]), Math.abs(avg-data[12])};
				Arrays.sort(distance);
				System.out.println("New Average: " + avg);
				break;
			}
		}
		
		for(int i = 0; i < distance.length;i++){
			if(indexoffarthest7==d6) continue;
			if(indexoffarthest7==distanceclone[i]){
				System.out.println("Most distant value: " + data[i]);
				d6 = data[i];
				sum = sum - data[i];
				avg = sum/(data.length-7);
				distance = new double[] {Math.abs(avg-data[0]), Math.abs(avg-data[1]), Math.abs(avg-data[2]), Math.abs(avg-data[3]), Math.abs(avg-data[4]), Math.abs(avg-data[5]), Math.abs(avg-data[6]), Math.abs(avg-data[7]), Math.abs(avg-data[8]), Math.abs(avg-data[9]), Math.abs(avg-data[10]), Math.abs(avg-data[11]), Math.abs(avg-data[12])};
				Arrays.sort(distance);
				System.out.println("New Average: " + avg);
				break;
			}
		}
		/*
		 * change indexoffarthestx, dx, assign dx to a value, 
		 * avg = sum/(data.length - x) <-- change this
		 */
		
		for(int i = 0; i < distance.length;i++){
			if(indexoffarthest8==d7) continue;
			if(indexoffarthest8==distanceclone[i]){
				System.out.println("Most distant value: " + data[i]);
				d7 = data[i];
				sum = sum - data[i];
				avg = sum/(data.length-8);
				distance = new double[] {Math.abs(avg-data[0]), Math.abs(avg-data[1]), Math.abs(avg-data[2]), Math.abs(avg-data[3]), Math.abs(avg-data[4]), Math.abs(avg-data[5]), Math.abs(avg-data[6]), Math.abs(avg-data[7]), Math.abs(avg-data[8]), Math.abs(avg-data[9]), Math.abs(avg-data[10]), Math.abs(avg-data[11]), Math.abs(avg-data[12])};
				Arrays.sort(distance);
				System.out.println("New Average: " + avg);
				break;
			}
		}
		/*
		 * change indexoffarthestx, dx, assign dx to a value, 
		 * avg = sum/(data.length - x) <-- change this
		 */
		
		for(int i = 0; i < distance.length;i++){
			if(indexoffarthest9==d8) continue;
			if(indexoffarthest9==distanceclone[i]){
				System.out.println("Most distant value: " + data[i]);
				d8 = data[i];
				sum = sum - data[i];
				avg = sum/(data.length-9);
				distance = new double[] {Math.abs(avg-data[0]), Math.abs(avg-data[1]), Math.abs(avg-data[2]), Math.abs(avg-data[3]), Math.abs(avg-data[4]), Math.abs(avg-data[5]), Math.abs(avg-data[6]), Math.abs(avg-data[7]), Math.abs(avg-data[8]), Math.abs(avg-data[9]), Math.abs(avg-data[10]), Math.abs(avg-data[11]), Math.abs(avg-data[12])};
				Arrays.sort(distance);
				System.out.println("New Average: " + avg);
				break;
			}
		}
		/*
		 * change indexoffarthestx, dx, assign dx to a value, 
		 * avg = sum/(data.length - x) <-- change this
		 */
		
		for(int i = 0; i < distance.length;i++){
			if(indexoffarthest10==d9) continue;
			if(indexoffarthest10==distanceclone[i]){
				System.out.println("Most distant value: " + data[i]);
				d9 = data[i];
				sum = sum - data[i];
				avg = sum/(data.length-10);
				distance = new double[] {Math.abs(avg-data[0]), Math.abs(avg-data[1]), Math.abs(avg-data[2]), Math.abs(avg-data[3]), Math.abs(avg-data[4]), Math.abs(avg-data[5]), Math.abs(avg-data[6]), Math.abs(avg-data[7]), Math.abs(avg-data[8]), Math.abs(avg-data[9]), Math.abs(avg-data[10]), Math.abs(avg-data[11]), Math.abs(avg-data[12])};
				Arrays.sort(distance);
				System.out.println("New Average: " + avg);
				break;
			}
		}
		/*
		 * change indexoffarthestx, dx, assign dx to a value, 
		 * avg = sum/(data.length - x) <-- change this
		 */
		
		for(int i = 0; i < distance.length;i++){
			if(indexoffarthest11==d10) continue;
			if(indexoffarthest11==distanceclone[i]){
				System.out.println("Most distant value: " + data[i]);
				d10 = data[i];
				sum = sum - data[i];
				avg = sum/(data.length-11);
				distance = new double[] {Math.abs(avg-data[0]), Math.abs(avg-data[1]), Math.abs(avg-data[2]), Math.abs(avg-data[3]), Math.abs(avg-data[4]), Math.abs(avg-data[5]), Math.abs(avg-data[6]), Math.abs(avg-data[7]), Math.abs(avg-data[8]), Math.abs(avg-data[9]), Math.abs(avg-data[10]), Math.abs(avg-data[11]), Math.abs(avg-data[12])};
				Arrays.sort(distance);
				System.out.println("New Average: " + avg);
				break;
			}
		}
		/*
		 * change indexoffarthestx, dx, assign dx to a value, 
		 * avg = sum/(data.length - x) <-- change this
		 */
		
		for(int i = 0; i < distance.length;i++){
			if(indexoffarthest12==d11) continue;
			if(indexoffarthest12==distanceclone[i]){
				System.out.println("Most distant value: " + data[i]);
				d11 = data[i];
				sum = sum - data[i];
				avg = sum/(data.length-12);
				distance = new double[] {Math.abs(avg-data[0]), Math.abs(avg-data[1]), Math.abs(avg-data[2]), Math.abs(avg-data[3]), Math.abs(avg-data[4]), Math.abs(avg-data[5]), Math.abs(avg-data[6]), Math.abs(avg-data[7]), Math.abs(avg-data[8]), Math.abs(avg-data[9]), Math.abs(avg-data[10]), Math.abs(avg-data[11]), Math.abs(avg-data[12])};
				Arrays.sort(distance);
				System.out.println("New Average: " + avg);
				break;
			}
		}
		/*
		 * change indexoffarthestx, dx, assign dx to a value, 
		 * avg = sum/(data.length - x) <-- change this
		 */
		
	}
	
	
		
		
}

