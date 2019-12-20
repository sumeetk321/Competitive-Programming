import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GrayCode {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(Arrays.toString(graycode(Integer.parseInt(br.readLine()))));
	}

	public static String[] graycode(int n) {
		if (n == 1) {
			return new String[]{"0", "1"};
		} else {
			String[] add = graycode(n-1);
			String[] out = new String[(int)Math.pow(2, n)];
			for(int i = 0; i < Math.pow(2, n-1); i++){
				out[i] = "0";
			}
			for(int i = (int)Math.pow(2, n-1); i < Math.pow(2, n); i++){
				out[i] = "1";
			}
			for(int i = 0; i < Math.pow(2, n-1); i++){
				out[i]+=add[i];
			}
			int ind =(int) Math.pow(2, n-1)-1;
			for(int i = (int)Math.pow(2, n-1); i < Math.pow(2, n); i++){
				out[i]+=add[ind];
				ind--;
			}
			return out;
		}
	}

}
