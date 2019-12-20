import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fib {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(fib(N));
	}
	
	public static int fib(int N){
		if(N==1||N==2){
			return 1;
		}
		return fib(N-1)+fib(N-2);
	}

}
