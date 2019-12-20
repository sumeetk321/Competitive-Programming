import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SufFIX {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String place = br.readLine();
			if (place.length()<4||place.charAt(place.length() - 4) != '1') {
				place = place.replace("1th", "1st");
				place = place.replace("2th", "2nd");
				place = place.replace("3th", "3rd");
			}
			System.out.println(place);
		}

	}

}
