import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class cowtag {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] x = new int[N];
		int[] y = new int[N];
		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		boolean solved = false;
		int turn = 0;
		int numleft = N;
		while(!solved){
			if(numleft==1){
				for(int i = 0; i < N; i++){
					if(x[i]!=Integer.MAX_VALUE){
						System.out.println(i+1);
						System.exit(0);
					}
				}
			}
			if(turn>=N){
				turn = 0;
			}
			if(x[turn]==Integer.MAX_VALUE){
				turn++;
				continue;
			}
			int mindist = Integer.MAX_VALUE;
			int eliminate = -1;
			for(int i = 0; i < N; i++){
				if(i==turn){
					continue;
				}
				int tmpdist =(int) (Math.pow(x[i]-x[turn], 2)+Math.pow(y[i]-y[turn], 2));
				if(tmpdist<mindist){
					mindist = tmpdist;
					eliminate = i;
				}
			}
			x[eliminate] = Integer.MAX_VALUE;
			y[eliminate] = Integer.MAX_VALUE;
			numleft--;
			turn++;
		}
	}

}