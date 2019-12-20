import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
ID: sumeetk1
LANG: JAVA
TASK: milk2
 */
public class milk2 {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

		int N = Integer.parseInt(scan.nextLine());
		
		int[] a = new int[1000001];
		int startTime = 1000000;
		int endTime = 0;
		
		for(int i = 0; i < N; i++){
			String[] input = scan.nextLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			
			startTime = Math.min(startTime, start);
			endTime = Math.max(endTime, end);
			for(int j = start; j < end; j++){
				a[j]++;
			}
		}
		
		int max1 = 0, max2 = 0, temp1 = 0, temp2 = 0;
		for(int k = startTime; k < endTime; k++){
			if(a[k]>0){
				temp1++;
				temp2 = 0;
			} else {
				temp2++;
				temp1 = 0;
			}
			max1 = Math.max(max1,  temp1);
			max2 = Math.max(max2,  temp2);
		}
		
		out.write(""+max1+" "+max2+"\n");
		
		
		
		out.close();
		scan.close();

	}

}
