package Contest1_2017;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BovineShuffle {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		int numofcows = Integer.parseInt(br.readLine());
		int[] a = new int[numofcows];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numofcows; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		String[] cows = new String[numofcows];
		for (int i = 0; i < numofcows; i++) {
			cows[i] = st.nextToken();
		}
		for(int i = 0; i < 3; i++){
			String[] tmpcows = new String[numofcows];
			for(int j = 0; j < numofcows; j++){
				tmpcows[indexOf(j+1, a)] = cows[j];
			}
			cows = tmpcows.clone();
		}
		for(String x : cows){
			out.println(x);
		}
		out.close();
		br.close();
	}
	public static int indexOf(int item, int[]arr){
		for(int i = 0; i < arr.length; i++){
			if(arr[i]==item){
				return i;
			}
		}
		return -1;
	}
}
