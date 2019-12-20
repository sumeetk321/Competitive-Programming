import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubsequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(lcs(br.readLine(), br.readLine()));
	}
	
	public static String lcs(String s, String t){
		if(t.length()==0){
			return "";
		}
		String out = "";
		if(s.charAt(0)==t.charAt(0)){
			out+=s.charAt(0);
		} else {
			return lcs(s, t.substring(1, t.length()-1));
		}
		return out+lcs(s.substring(1, s.length()-1), t.substring(1, t.length()-1));
	}
	
}
