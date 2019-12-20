import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MathMessage {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num1 = Integer.parseInt(br.readLine());
		int num2 = Integer.parseInt(br.readLine());
		System.out.println(num1+num2);
		br.close();
	}

}
