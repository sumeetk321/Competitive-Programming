import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i, j;
		int num1 = Integer.parseInt(br.readLine()), num2;
		long[] planets = new long[num1], queues;
		
		for(i=0; i<num1; i++){
			planets[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(planets);
		
		num2 = Integer.parseInt(br.readLine());
		queues = new long[num2];
		int[] outputs = new int[num2];
		
		for(i=0; i<num2; i++){
			queues[i] = Integer.parseInt(br.readLine());
		}
		
		for(i=0; i<num2; i++){
			int sum = 0;
			for(j=planets.length-1; j>=0; j--){
				if(planets[j]<queues[i]){
					sum = j+1;
					break;
				}
			}
			System.out.println(sum);
		}
		
		br.close();
		
	}

}
