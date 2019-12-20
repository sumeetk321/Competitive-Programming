import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessTheNumber {

	public static void main(String[] args) throws IOException {

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int[] range = new int[]{0, 1000001};
		boolean found = false;
		while(!found){
			System.out.println((Math.round((range[0]+range[1])/2)));
			System.out.flush();
			switch(br.readLine()){
			case "<":
				range[1] = Math.round((range[0]+range[1])/2);
				break;
			case ">=":
				range[0] = Math.round((range[0]+range[1])/2);
				break;
			}
			if(range[0]==range[1]-1){
				System.out.println("! "+range[0]);
				System.out.flush();
				System.exit(0);
			}
		}
	}

}
