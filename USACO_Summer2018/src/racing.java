import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class racing {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int F = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[] unum = new int[T+1];
		int[] fnum = new int[T+1];
		int[] dnum = new int[T+1];
		for(int i = 1; i <= T; i++){
			String test = br.readLine();
			unum[i] = unum[i-1];
			if(test.equals("u")){
				unum[i]++;
			}
			fnum[i] = fnum[i-1];
			if(test.equals("f")){
				fnum[i]++;
			}
			dnum[i] = dnum[i-1];
			if(test.equals("d")){
				dnum[i]++;
			}
		}
		for(int i = 1; i < T; i++){
			int uphill = unum[i];
			int downhill = dnum[i];
			int flat = fnum[i];
			int going = (U*uphill)+(D*downhill)+(F*flat);
			int back = (U*downhill)+(D*uphill)+(F*flat);
			if(going+back>M){
				System.out.println(i-1);
				break;
			}
		}
	}

}
