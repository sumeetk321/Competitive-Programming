import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cowpals {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());
		boolean found = false;
		while(!found){
			if(S==divisorSum(divisorSum(S))&&S!=divisorSum(S)){
				System.out.println(S+" "+divisorSum(S));
				break;
			}
			S++;
		}
	}
	
	public static int divisorSum(int N){
		int out = 0;
		for(int i = 1; i < N; i++){
			if(N%i==0){
				out+=i;
			}
		}
		return out;
	}

}
