import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Stanford_2012_5_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int[] num = new int[n];
		int zeroes = 0;
		for(int i = 0; i < n; i++){
			num[i] = Character.getNumericValue(s.charAt(i));
			if(s.charAt(i)=='0'){
				zeroes++;
			}
		}
		int start;
		Arrays.sort(num);
		if(zeroes>0){
		int[] temp = num;
		for(int i = 0; i < zeroes; i++){
			num[i] = temp[i+zeroes];
		}
		for(int i = zeroes; i < 2*zeroes; i++){
			num[i] = 0;
		}
		}
		
		for(int x : num){
			System.out.print(x);
		}
		
	}

}
