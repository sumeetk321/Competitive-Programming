import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beads {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String necklace = br.readLine();
		int max = 0;
		for(int i = 0; i < N; i++){
			int numbeads1 = 0, numbeads2 = 0;
			String color1 = "", color2 = "";
			int counter = 0;
			for(int j = 0; j < N; j++){
				if(color1.equals("")&&necklace.charAt(j)!='w'){
					color1 = necklace.charAt(j)+"";
					numbeads1++;
				} else if(color1.equals("")){
					counter++;
					continue;
				} else {
					if((necklace.charAt(j)+"").equals(color1)||necklace.charAt(j)=='w'){
						numbeads1++;
					} else {
						break;
					}
				}
			}
			numbeads1+=counter;
			counter = 0;
			for(int j = N-1; j > -1; j--){
				if(color2.equals("")&&necklace.charAt(j)!='w'){
					color2 = necklace.charAt(j)+"";
					numbeads2++;
				} else if(color2.equals("")){
					counter++;
					continue;
				} else {
					if((necklace.charAt(j)+"").equals(color2)||necklace.charAt(j)=='w'){
						numbeads2++;
					} else {
						break;
					}
				}
			}
			numbeads2+=counter;
			if(numbeads1+numbeads2>=N){
				max = N;
				break;
			} else {
				max = Math.max(numbeads1+numbeads2, max);
			}
			necklace = necklace.substring(N-1)+necklace.substring(0, N-1);
		}
		System.out.println(max);
	}

}
