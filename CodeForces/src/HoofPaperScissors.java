import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HoofPaperScissors {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("hps.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		int N = Integer.parseInt(br.readLine());
		String fjplays = "";
		for (int i = 0; i < N; i++) {
			fjplays += br.readLine();
		}
		String[] bessieplays = {"HP", "HS", "PH", "SH", "PS", "SP"};
		int maxwins = Integer.MIN_VALUE;
		for(String x : bessieplays){
			int charchange = fjplays.length()-1;
			String play = "";
			for(int i = 0; i < N; i++){
				play+=x.charAt(1);
			}
			maxwins = Math.max(maxwins, winSum(fjplays, play));
			for(int i = 0; i < N; i++){
				StringBuilder sb = new StringBuilder(play);
				sb.replace(i, i+1, x.charAt(0)+"");
				play = sb.toString();
				maxwins = Math.max(maxwins, winSum(fjplays, sb.toString()));
			}
		}
		out.println(maxwins);
		out.close();
		br.close();
	}
	
	public static int winSum(String fjplay, String bessieplay){
		int out = 0;
		for(int i = 0; i < fjplay.length(); i++){
			switch(fjplay.charAt(i)){
			case 'H':
				if(bessieplay.charAt(i)=='P') out++;
				break;
			case 'P':
				if(bessieplay.charAt(i)=='S') out++;
				break;
			case 'S':
				if(bessieplay.charAt(i)=='H') out++;
				break;
			}
		}
		return out;
	}

}
