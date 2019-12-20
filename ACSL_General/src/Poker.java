import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Poker {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Poker.txt");
		Scanner scan = new Scanner(file);
		for(int i = 0; i < 9; i++){
			String[] in = scan.nextLine().split(", ");
			int a = Integer.parseInt(in[0]), b = Integer.parseInt(in[1]), c = Integer.parseInt(in[2]), d = Integer.parseInt(in[3]), e = Integer.parseInt(in[4]);
			int tempa = a, tempb = b, tempc = c, tempd = d, tempe = e;
			int[] tempar = {tempa, tempb, tempc, tempd, tempe};
			Arrays.sort(tempar);
			if(a >= 14 && a <= 26){
				a -= 13;
			} else if(a >= 27 && a <= 39){
				a -= 26;
				
			} else if(a >= 40 && a <= 52){
				a -= 39;
			}
			
			if(b >= 14 && b <= 26){
				b -= 13;
			} else if(b >= 27 && b <= 39){
				b -= 26;
			} else if(b >= 40 && b <= 52){
				b -= 39;
			}
			
			if(c >= 14 && c <= 26){
				c -= 13;
			} else if(c >= 27 && c <= 39){
				c -= 26;
			} else if(c >= 40 && c <= 52){
				c -= 39;
			}
			
			if(d >= 14 && d <= 26){
				d -= 13;
			} else if(d >= 27 && d <= 39){
				d -= 26;
			} else if(d >= 40 && d <= 52){
				d -= 39;
			}
			
			if(e >= 14 && e <= 26){
				e -= 13;
			} else if(e >= 27 && e <= 39){
				e -= 26;
			} else if(e >= 40 && e <= 52){
				e -= 39;
			}
			
			int[] ar = {a, b, c, d, e};
			
			Arrays.sort(ar);
			
			if((ar[0]==ar[1] && ar[1]==ar[2] && ar[2]==ar[3] )||(ar[1]==ar[2] && ar[2]==ar[3] && ar[3]==ar[4])){
				System.out.println("FOUR OF A KIND");
			} else if((ar[0]==ar[1] && ar[1]==ar[2] && ar[3]==ar[4])||(ar[0]==ar[1] && ar[2]==ar[3] && ar[3]==ar[4])){
				System.out.println("FULL HOUSE");
			} else if(tempar[4]-tempar[0]<13){
				System.out.println("FLUSH");
			} else if((ar[0]==ar[1] && ar[1]==ar[2])||(ar[1]==ar[2] &&ar[2]==ar[3]) || (ar[2]==ar[3] && ar[3]==ar[4])){
				System.out.println("THREE OF A KIND");
			} else if((ar[0]==ar[1] && ar[2]==ar[3]) || (ar[1]==ar[2] && ar[3]==ar[4])||(ar[0]==ar[1] && ar[3]==ar[4])){
				System.out.println("TWO PAIRS");
			} else if((ar[0]==ar[1])||(ar[1]==ar[2])||(ar[2]==ar[3])||(ar[3]==ar[4])){
				System.out.println("PAIR");
			}
		}
		
		
	}

}
