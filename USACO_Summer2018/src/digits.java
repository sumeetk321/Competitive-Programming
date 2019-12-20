import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class digits {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bin = br.readLine();
		ArrayList<Integer> binvalues = new ArrayList<Integer>();
		String trin = br.readLine();
		ArrayList<Integer> trinvalues = new ArrayList<Integer>();
		StringBuilder sb;
		for(int i = 0; i < bin.length(); i++){
			sb = new StringBuilder(bin);
			if(i==0&&sb.charAt(0)=='1'){
				continue;
			}
			sb.setCharAt(i, (sb.charAt(i)=='0'?'1':'0'));
			binvalues.add(Integer.parseInt(sb.toString(), 2));
		}
		for(int i = 0; i < trin.length(); i++){
			sb = new StringBuilder(trin);
			for(int j = 0; j < 3; j++){
				if(i==0&&j==0){
					continue;
				}
				sb.setCharAt(i, (j+"").charAt(0));
				if(sb.equals(trin)){
					break;
				}
				trinvalues.add(Integer.parseInt(sb.toString(), 3));
			}
		}
		for(int x : binvalues){
			if(trinvalues.contains(x)){
				System.out.println(x);
				break;
			}
		}
	}

}
