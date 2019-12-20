import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class moosick {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] song = new int[N];
		for (int i = 0; i < N; i++) {
			song[i] = Integer.parseInt(br.readLine());
		}
		int C = Integer.parseInt(br.readLine());
		int[] rum = new int[C];
		for (int i = 0; i < C; i++) {
			rum[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(rum);
		int rumcount = 0;
		ArrayList<Integer> rumindices = new ArrayList<Integer>();
		int[] tmp;
		loop: for (int i = 0; i < N - C + 1; i++) {
			tmp = new int[C];
			int count = 0;
			for (int j = i; j < i + C; j++) {
				tmp[count] = song[j];
				count++;
			}
			Arrays.sort(tmp);
			for (int j = 0; j < C; j++) {
				tmp[j] = rum[j] - tmp[j];
			}
			int test = tmp[0];
			for (int j = 1; j < C; j++) {
				if(tmp[j]!=test){
					continue loop;
				}
			}
			rumcount++;
			rumindices.add(i+1);
		}
		System.out.println(rumcount);
		for(int x : rumindices){
			System.out.println(x);
		}
	}

}
