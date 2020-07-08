import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ariprog {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		int proglen = Integer.parseInt(br.readLine());
		int maxsize = Integer.parseInt(br.readLine());
		
	}
	public static void solve(int proglen, int maxsize){
		int maxbi = (int) (Math.pow(maxsize, 2)*2);
		for(int i = 0; i < Math.pow(maxsize, 2); i++){
			
		}
	}
	public static boolean isBisquare(int test){
		for(int i = 0; i < Math.sqrt(test); i++){
			for(int j= i; j < Math.sqrt(test); j++){
				if(Math.pow(i, 2)+Math.pow(j, 2)==test){
					return true;
				}
			}
		}
		return false;
	}
}
