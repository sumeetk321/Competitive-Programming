import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ruler {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++){
			System.out.print("*");
		}
		System.out.println();
		draw(N-1);
		for(int i = 0; i < N; i++){
			System.out.print("*");
		}
		System.out.println();
	}
	
	public static void draw(int N){
		if(N==1){
			System.out.print("*");
			System.out.println();
			return;
		}
		draw(N-1);
		for(int i = 0; i < N; i++){
			System.out.print("*");
		}
		System.out.println();
		draw(N-1);
	}

}
