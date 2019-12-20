import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class claust {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] points = new int[N][2];
		String out = "";
		int mindist = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < points.length-1; i++){
			for(int j = i+1; j < points.length; j++){
				int dist = (int) (Math.pow(points[i][0]-points[j][0], 2)+Math.pow(points[i][1]-points[j][1], 2));
				if(dist<mindist){
					mindist = dist;
					out = (i+1)+" "+(j+1);
				}
			}
		}
		System.out.println(out);
	}

}
