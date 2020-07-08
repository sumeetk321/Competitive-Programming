package Contest3_2018;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Teleportation {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		int[] b = new int[N];
		StringTokenizer st;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		int mintotaldistance = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			min = Math.min(min, Math.min(a[i], b[i]));
			max = Math.max(max, Math.max(a[i], b[i]));
		}
		for(int i = min; i <= max; i++){
			int localdistance = 0;
			for(int j = 0; j < N; j++){
				localdistance+=Math.min(Math.abs(a[j]-b[j]), Math.abs(a[j])+Math.abs(i-b[j]));
			}
			mintotaldistance = Math.min(mintotaldistance, localdistance);
		}
		out.println(mintotaldistance);
		out.close();
	}
}
