package Contest1_2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class convention {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new FileReader("convention.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int sparebuses = N%C;
		int[] times = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			times[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(times);
		int max = 0;
		for(int i = 0; i < N; i+=C){
			if(i>=N){
				break;
			}
			max = Math.max(max, times[i+C-1]-times[i]);
		}
		out.println(max);
		out.close();
		br.close();
	}

}
