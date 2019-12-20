import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stanford_2012_5_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int longest = 0;
		int counter = 1;
		for (int i = 0; i < n; i++) {
			if(i==n-1){
				if(counter>longest) longest = counter;
				break;
			}
			if (s.charAt(i) == s.charAt(i + 1)) {
				counter++;
			} else {
				if (counter > longest) {
					longest = counter;
				}
				counter = 1;
			}
		}
		System.out.println(longest);

	}

}
