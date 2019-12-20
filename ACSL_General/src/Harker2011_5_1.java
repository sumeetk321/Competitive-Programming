import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Harker2011_5_1 {

	public static void main(String[] args) throws IOException {
		/*
4 6
0 5
4 1
0 4
4 1
0 4
4 1
0 4
4 1
0 3
		 */
/*
8 8
0 8
1 4
2 4
3 4
4 8
5 8
6 4
7 4
8 4
7 5
8 4
7 3
8 4
 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean notdone = true;
		StringTokenizer test = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(test.nextToken());
		int b = Integer.parseInt(test.nextToken());
		ArrayList<String> image = new ArrayList<String>();
		String str = "", tmp = "";
		String line = "";
		while ((line = br.readLine()).length()>0) {
			StringTokenizer st = new StringTokenizer(line);
			String c = (st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			for(int i = 0; i < d; i++){
				tmp+=c;
			}
			str+=tmp;
			tmp = "";
			
		}
		for(int j = 0; j < str.length(); j+=b){
			image.add(str.substring(j, j+b));
		}
		for(String x : image){
			System.out.println(x);
		}

	}

}
