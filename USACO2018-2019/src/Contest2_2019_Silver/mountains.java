package Contest2_2019_Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class mountains {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
		int N = Integer.parseInt(br.readLine());
		int[][] mountains = new int[N][2];
		boolean[] visible = new boolean[N];
		Arrays.fill(visible, true);
		StringTokenizer st;
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			mountains[i][0] = Integer.parseInt(st.nextToken());
			mountains[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(mountains, new Comparator<int[]>(){

			@Override
			public int compare(int[] arg0, int[] arg1) {
				return -Integer.compare(arg0[1], arg1[1]);
			}
			
		});
		int numvisible = 0;
		for(int i = 0; i < N; i++){
			if(visible[i]){
				numvisible++;
				int posb = mountains[i][1]-mountains[i][0];
				int negb = mountains[i][1]+mountains[i][0];
				for(int j = i+1; j < N; j++){
					if((mountains[j][0]<=mountains[i][0]&&mountains[j][1]<=(mountains[j][0]+posb))||(mountains[j][0]>mountains[i][0]&&mountains[j][1]<=(negb-mountains[j][0]))){
						visible[j] = false;
					}
				}
			}
		}
		out.println(numvisible);
		out.close();
		br.close();
	}
}
