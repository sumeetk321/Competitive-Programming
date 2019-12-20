import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {

	public static void main(String[] args) {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println(factorial(Integer.parseInt(br.readLine())));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int factorial(int n){
		if(n==1){
			return 1;
		}
		return n*factorial(n-1);
	}
}
