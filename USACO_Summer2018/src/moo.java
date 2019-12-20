import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class moo {
	static int currindex = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int index = 0;
		int mindex = 0;
		while(mindex<N-1){
			mindex = (4*index)-Integer.bitCount(index);
			//System.out.println(curr);
			index++;
		}
		if(mindex==N-1){
			System.out.println("m");
		} else {
			System.out.println("o");
		}
	}

}
