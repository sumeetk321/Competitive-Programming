import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bcount {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int[] ids = new int[N+1];
		int[] pre1 = new int[N+1];
		int[] pre2 = new int[N+1];
		int[] pre3 = new int[N+1];
		for(int i = 1; i <= N; i++){
			ids[i] = Integer.parseInt(br.readLine());
			pre1[i] = pre1[i-1];
			if(ids[i]==1){
				pre1[i]++;
			}
			pre2[i] = pre2[i-1];
			if(ids[i]==2){
				pre2[i]++;
			}
			pre3[i] = pre3[i-1];
			if(ids[i]==3){
				pre3[i]++;
			}
		}
		for(int i = 0; i < Q; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.print(pre1[b]-pre1[a-1]+" ");
			System.out.print(pre2[b]-pre2[a-1]+" ");
			System.out.print(pre3[b]-pre3[a-1]);
			System.out.println();
		}
	}

}
