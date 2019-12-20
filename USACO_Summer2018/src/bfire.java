import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bfire {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Cowchair[] cows = new Cowchair[N];
		for(int i = 0; i < N; i++){
			cows[i] = new Cowchair(i+1);
		}
		Cowchair movedcow = cows[0];
		Cowchair ender;
		int cownum = 1;
		do {
			movedcow.tapped = true;
			Cowchair tmpcow = cows[((cownum*2)-1)%N];
			cows[((cownum*2)-1)%N] = movedcow;
			ender = movedcow;
			movedcow = tmpcow;
			cownum = movedcow.num;
			if(movedcow.tapped||(cownum-1==0)){
				System.out.println(ender.num);
				break;
			}
		} while(!movedcow.equals(cows[0]));
	}

}
class Cowchair{
	public int num;
	public boolean tapped;
	public Cowchair(int num){
		this.num = num;
		tapped = false;
	}
}
