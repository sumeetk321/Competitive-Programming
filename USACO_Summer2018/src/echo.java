import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class echo {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int biggestlen = 0;
		for(int i = Math.min(s1.length(), s2.length()); i >=0; i--){
			if(s1.substring(0, i).equals(s2.substring(s2.length()-i, s2.length()))){
				biggestlen = i;
				break;
			}
			if(s2.substring(0, i).equals(s1.substring(s1.length()-i, s1.length()))){
				biggestlen = i;
				break;
			}
		}
		System.out.println(biggestlen);
	}

}
