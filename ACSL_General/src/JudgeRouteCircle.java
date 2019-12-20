import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JudgeRouteCircle {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = br.readLine();
		int vertsum = 0;
		int horizsum = 0;
		for(int i = 0; i < in.length(); i++){
			if(in.charAt(i)=='U'){
				vertsum++;
			} else if(in.charAt(i)=='D'){
				vertsum--;
			} else if(in.charAt(i)=='L'){
				horizsum--;
			} else if(in.charAt(i)=='R'){
				horizsum++;
			}
		}
		System.out.println(vertsum==0&&horizsum==0);
	}

}
