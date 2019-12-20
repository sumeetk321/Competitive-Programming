import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pangram {
	static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sentence;
		int[] count;
		while(!(sentence = br.readLine()).equals(".")){
			count = new int[26];
			String sentence2 = sentence.replaceAll("[^A-Z]", "");
			for(int i = 0; i < sentence2.length(); i++){
				count[alphabet.indexOf(sentence2.charAt(i))]++;
			}
			boolean neither, pangram, perfect;
			int ones = 0;
			int gones = 0;
			for(int x : count){
				if(x==1){
					ones++;
					gones++;
				}
				if(x>1){
					gones++;
				}
			}
			if(ones==26){
				System.out.println("PERFECT: "+sentence);
			} else if(gones==26){
				System.out.println("PANGRAM: "+sentence);
			} else {
				System.out.println("NEITHER: "+sentence);
			}
		}
	}

}
