import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class highcard {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] elsie = new int[N];
		int[] bessie = new int[N];
		for (int i = 0; i < N; i++) {
			elsie[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(elsie);
		int counter = 0;
		int wins = 0;
		for (int i = 1; i <= 2 * N; i++) {
			if (Arrays.binarySearch(elsie, i) < 0) {
				bessie[counter] = i;
				counter++;
			}
		}
		for(int i = 0; i < N; i++){
			int test = elsie[i];
			for(int j = 0; j < N; j++){
				if(bessie[j]>test){
					bessie[j] = 0;
					wins++;
					break;
				}
			}
		}
		System.out.println(wins);
	}

}
