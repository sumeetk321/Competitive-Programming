import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fact {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(fact(N));
	}
	public static int fact(int N){
		if(N==1){
			return 1;
		}
		return fact(N-1)*N;
	}
}
