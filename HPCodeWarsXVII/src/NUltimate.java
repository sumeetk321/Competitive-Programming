import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NUltimate {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while(!(line = br.readLine()).equals("0 $")){
			String[] arr = line.split(" ");
			int N = Integer.parseInt(arr[0]);
			System.out.println(arr[arr.length-1-N]);
		}
	}

}
