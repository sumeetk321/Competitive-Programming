import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H {
	static String alphabet = "abcdefghijklmnopqrstuvwxyz";
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		BigInteger[] nums = new BigInteger[26];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 26; i++){
			nums[i] = new BigInteger(st.nextToken());
		}
		Arrays.sort(nums);
		for(int i = 0; i < S.length()-1; i++){
			System.out.print(nums[alphabet.indexOf(S.charAt(i))]+" ");
		}
		System.out.print(nums[alphabet.indexOf(S.charAt(S.length()-1))]);
		System.out.println();
		br.close();
	}

}
