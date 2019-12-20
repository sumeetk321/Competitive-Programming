import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class snowboots {
	static int[] depths;
	static Boot[] boots;
	static int min = Integer.MAX_VALUE;
	static boolean[][] bootindexpairs = new boolean[251][251];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("snowboots.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		depths = new int[N];
		boots = new Boot[B];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			depths[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < B; i++) {
			st = new StringTokenizer(br.readLine());
			boots[i] = new Boot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		recurse(0, 0);
		pw.println(min);
		br.close();
		pw.close();
	}

	public static void recurse(int bootnum, int index) {
		if (index >= depths.length) {
			min = Math.min(min, bootnum);
			return;
		}
		if (bootnum >= boots.length) {
			return;
		}
		if(bootindexpairs[bootnum][index]){
			return;
		} else {
			bootindexpairs[bootnum][index] = true;
		}
		if(boots[bootnum].maxdepth<depths[index]){
			return;
		}
		for(int i = 1; i < boots.length-bootnum; i++){
			recurse(bootnum+i, index);
		}
		//recurse(bootnum + 1, index);
		for (int i = 1; i <= boots[bootnum].stepsize; i++) {
			recurse(bootnum, index + i);
		}
	}
}

class Boot {
	public int maxdepth;
	public int stepsize;

	public Boot(int md, int ss) {
		maxdepth = md;
		stepsize = ss;
	}
}
