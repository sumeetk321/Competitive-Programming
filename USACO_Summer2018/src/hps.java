import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class hps {
	static String[] possiblechanges = new String[]{"HH", "HP", "HS", "PH", "PP", "PS", "SH", "SP", "SS"};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] plays = new String[N+1];
		int[] hoofps = new int[N+1];
		int[] paperps = new int[N+1];
		int[] scissorsps = new int[N+1];
		plays[0] = "";
		for(int i = 1; i <= N; i++){
			plays[i] = br.readLine();
			hoofps[i] = hoofps[i-1];
			paperps[i] = paperps[i-1];
			scissorsps[i] = scissorsps[i-1];
			switch(plays[i]){
			case "H":
				hoofps[i]++;
				break;
			case "P":
				paperps[i]++;
				break;
			case "S":
				scissorsps[i]++;
				break;
			}
		}
		int maxwins = 0;
		for(int i = 1; i <= N; i++){
			for(String x : possiblechanges){
				switch(x){
				case "HH":
					maxwins = Math.max(maxwins, scissorsps[N]);
					break;
				case "HP":
					maxwins = Math.max(maxwins, scissorsps[i]+hoofps[N]-hoofps[i]);
					break;
				case "HS":
					maxwins = Math.max(maxwins, scissorsps[i]+paperps[N]-paperps[i]);
					break;
				case "PH":
					maxwins = Math.max(maxwins, hoofps[i]+scissorsps[N]-scissorsps[i]);
					break;
				case "PP":
					maxwins = Math.max(maxwins, hoofps[N]);
					break;
				case "PS":
					maxwins = Math.max(maxwins, hoofps[i]+paperps[N]-paperps[i]);
					break;
				case "SH":
					maxwins = Math.max(maxwins, paperps[i]+scissorsps[N]-scissorsps[i]);
					break;
				case "SP":
					maxwins = Math.max(maxwins, paperps[i]+hoofps[N]-hoofps[i]);
					break;
				case "SS":
					maxwins = Math.max(maxwins, paperps[N]);
					break;
				}
			}
		}
		/*System.out.println(Arrays.toString(plays));
		System.out.println(Arrays.toString(hoofps));
		System.out.println(Arrays.toString(paperps));
		System.out.println(Arrays.toString(scissorsps));*/
		System.out.println(maxwins);
	}

}
