import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CandyCount {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		int smallestdifference = Integer.MAX_VALUE;
		ArrayList<String> names = new ArrayList<String>();
		
		for(int i = 0; i < P; i++){
			String[] guess = br.readLine().split(" ");
			if(Math.abs(C-Integer.parseInt(guess[0]))<smallestdifference){
				smallestdifference = Math.abs(C-Integer.parseInt(guess[0]));
				names.clear();
				names.add(guess[1]);
			} else if(Math.abs(C-Integer.parseInt(guess[0]))==smallestdifference){
				names.add(guess[1]);
			}
		}
		for(String x : names){
			System.out.print(x+" ");
		}
		System.out.println();
	}

}
