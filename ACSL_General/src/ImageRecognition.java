import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ImageRecognition {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			String[] in = br.readLine().split(", ");
			int m = Integer.parseInt(in[0]);
			int n = Integer.parseInt(in[1]);
			int[][] grid = new int[m][n];
			String hex = Integer.toBinaryString(Integer.parseInt(in[2], 16));
			int len = hex.length();
			for(int j = 0; j < (4*in[2].length())-len; j++){
				hex = "0"+hex;
			}
			int posofhex = 0;
			for(int j = m-1; j > -1; j--){
				for(int k = 0; k < n; k++){
					grid[j][k] = Character.getNumericValue(hex.charAt(posofhex));
					posofhex++;
				}
			}
			String largest1 = "";
			String largest0 = "";
			int largestdim1 = 0;
			int largestdim0 = 0;
			int checkm = 1;
			int checkn = 1;
			for(; checkm <= m; checkm++){
				for(; checkn <= n; checkn++){
					int sum = 0;
					for(int j = 0; j < checkm; j++){
						for(int k = 0; k < checkn; k++){
							sum+=grid[j][k];
						}
					}
					if(sum==checkm*checkn){
						if(checkm*checkn>largestdim1){
							largestdim1 = checkm*checkn;
							largest1 = checkm+" x "+checkn;
						}
					} else if(sum==0){
						if(checkm*checkn>largestdim0){
							largestdim0 = checkm*checkn;
							largest0 = checkm+" x "+checkn;
						}
					}
				}
			}
			System.out.println(largest1);
			System.out.println(largest0);
			
		}

	}

}
