import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ACSLland {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("ACSLland.txt");
		Scanner scan = new Scanner(file);
		String alphabet = "ABCDEFG";
		String cars = "CMFV";
		String roads = "IHMS";
		for(int i = 0; i < 10; i++){
			String[] in = scan.nextLine().split(", ");
			String start = in[0];
			String end = in[1];
			int[] distance = {450, 140, 120, 320, 250, 80};
			int[] mpg = {28, 25, 22, 20};
			int[] speed = {65, 60, 55, 45};
			String car = in[2];
			String road = in[3];
			double gas = Double.parseDouble(in[4]);
			double time = 0;
			int totaldistance = 0;
			for(int j = 0; j < alphabet.indexOf(end)-alphabet.indexOf(start); j++){
				totaldistance+=distance[alphabet.indexOf(start)+j];
			}
			System.out.print(totaldistance+", ");
			time = (double) totaldistance / (speed[roads.indexOf(road)]);
			String timeout = ((int) time)+":";
			String tmp = Math.round((time - ((int) time))*60)+"";
			if(tmp.length()==1){
				tmp = "0"+tmp;
			}
			timeout+=tmp;
			if(timeout.length()==4) timeout = "0"+timeout;
			System.out.print(timeout+", ");
			double price = ((double) totaldistance/(mpg[cars.indexOf(car)]))*gas;
			price*=100;
			price = Math.round(price);
			price/=100;
			System.out.println("$"+price);
			System.out.println();
		}
		
	}

}
