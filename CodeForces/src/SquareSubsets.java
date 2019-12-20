import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SquareSubsets {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long counter = 0;
		for(long i = 1; i < Math.pow(2, size); i++){
			String bitmask = Long.toBinaryString(i);
			while(bitmask.length()<size){
				bitmask = "0"+bitmask;
			}
			out.println(bitmask);
			long test = 1;
			for(int j = 0; j < bitmask.length(); j++){
				if(bitmask.charAt(j)=='1'){
					test*=arr[j];
				}
			}
			out.println(test);
			if(Math.sqrt(test)==(long)Math.sqrt(test)){
				counter++;
			}
		}
		out.print(counter);
		out.close();
		br.close();
	}
}
