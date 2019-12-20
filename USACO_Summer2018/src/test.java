import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++){
			System.out.println("This is a test!");
		}
	}

}
