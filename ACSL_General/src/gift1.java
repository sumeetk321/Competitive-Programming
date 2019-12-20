import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

/*
ID: sumeetk1
LANG: JAVA
TASK: gift1
*/

public class gift1 {

	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		StringTokenizer st;
		ArrayList<String> names = new ArrayList<String>();
		String recipient;
		int mon, rec;
		int NP = Integer.parseInt(scan.nextLine());

		for (int i = 0; i < NP; i++) {
			names.add(scan.nextLine());
		}

		int[] receive = new int[names.size()], give = new int[names.size()];
		
		for(int j = 0; j < NP; j++){
			String giver = scan.nextLine();
			String monrec = scan.nextLine();
			st = new StringTokenizer(monrec);
			mon = Integer.parseInt(st.nextToken());
			rec = Integer.parseInt(st.nextToken());
			if(rec == 0){
				receive[names.indexOf(giver)] = receive[names.indexOf(giver)] + mon;
				continue;
			}else{
				give[names.indexOf(giver)] = give[names.indexOf(giver)] + (int) (mon - (mon%rec));
			}
			for(int k = 0; k < rec; k++){
				recipient = scan.nextLine();
				receive[names.indexOf(recipient)] = receive[names.indexOf(recipient)] + (int) (mon/rec);
			}
		}
		
		for(int l = 0; l < names.size(); l++){
			out.println(names.get(l) + " " + (receive[l] - give[l]));
		}
		
		out.close();
		scan.close();
		

	}

}
