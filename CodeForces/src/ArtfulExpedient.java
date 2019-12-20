import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class ArtfulExpedient {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		int n = Integer.parseInt(br.readLine());
		String xstr = br.readLine();
		String ystr = br.readLine();
		int[] x = new int[n];
		int[] y = new int[n];
		for(int i = 0; i < n; i++){
			x[i] = Integer.parseInt(xstr.split(" ")[i]);
			y[i] = Integer.parseInt(ystr.split(" ")[i]);
		}
		Arrays.sort(x);
		Arrays.sort(y);
		int pairs = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				int xor = x[i]^y[j];
				if(Arrays.binarySearch(x, xor)>=0 || Arrays.binarySearch(y, xor)>=0){
					pairs++;
				}
			}
		}
		if(pairs%2==0){
			out.println("Karen");
		} else {
			out.print("Koyomi");
		}
		br.close();
		out.close();
	}
	
	public static void arrayContains(int[] in, int s){
		Arrays.sort(in);
		
	}

}
