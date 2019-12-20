import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClockPower {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] mamps = new int[]{6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++){
			int milliamps = 20;
			String time = br.readLine();
			String[] vals = time.split(":");
			int tmpsum = 0;
			for(int j = 0; j < vals[0].length(); j++){
				tmpsum+=mamps[Character.getNumericValue(vals[0].charAt(j))];
			}
			milliamps+=(tmpsum*15);
			tmpsum = 0;
			for(int j = 0; j < vals[1].length(); j++){
				tmpsum+=mamps[Character.getNumericValue(vals[1].charAt(j))];
			}
			milliamps+=(tmpsum*15);
			System.out.println(milliamps+" milliamps");
		}
	}

}
