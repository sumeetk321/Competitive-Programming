/*
ID: sumeetk1
LANG: JAVA
TASK: milk
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class milk {
	private static class Farmer{
		private int price;
		private int quantity;
		Farmer(int price, int quantity){
			this.price = price;
			this.quantity = quantity;
		}
		public String toString(){
			return price+" "+quantity;
		}
		public int getPrice(){
			return price;
		}
		public int getQuantity(){
			return quantity;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Farmer[] farmers = new Farmer[m];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			farmers[i] = new Farmer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(farmers, new Comparator<Farmer>() {
			public int compare(Farmer f1, Farmer f2){
				return f1.getPrice()-f2.getPrice();
			}
		});
		int minprice = 0;
		for(Farmer f : farmers){
			if(n<f.getQuantity()){
				minprice+=n*f.getPrice();
				break;
			} else {
				minprice+=f.getPrice()*f.getQuantity();
				n-=f.getQuantity();
			}
		}
		out.println(minprice);
		out.close();
		br.close();
	}
}