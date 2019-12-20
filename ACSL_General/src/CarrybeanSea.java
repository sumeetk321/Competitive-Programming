import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CarrybeanSea {

	public static void main(String[] args) throws IOException {
		print("hello");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//don't understand problem this is not good
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] islands = new int[N][4];
		
	}
	public static void print(String in){
		System.out.print(in.charAt(0));
		if(in.length()==1){
			return;
		}
		print(in.substring(1,in.length()));
	}
}
