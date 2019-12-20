import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Fire {
	class Item{
		private int t;
		private int d;
		private int p;
		Item(int t, int d, int p){
			this.t = t;
			this.d = d;
			this.p = p;
		}
		public int getT(){
			return t;
		}
		public int getD(){
			return d;
		}
		public int getP(){
			return p;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		Fire fire = new Fire();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		int numofitems = Integer.parseInt(br.readLine());
		Item[] items = new Item[numofitems];
		StringTokenizer st;
		for(int i = 0; i < numofitems; i++){
			st = new StringTokenizer(br.readLine());
			items[i] = fire.new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
	}
	

}
