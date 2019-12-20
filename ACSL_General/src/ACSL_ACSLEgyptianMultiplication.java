import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ACSL_ACSLEgyptianMultiplication {
	//
	public static void main(String[] args) {
		Scanner scan;
		for (int i = 0; i < 10; i++) {
			scan = new Scanner(System.in);
			boolean bool = false;
			String[] in = scan.nextLine().split(", ");
			int larger = Math.max(Integer.parseInt(in[0]), Integer.parseInt(in[1]));
			ArrayList<Integer> actualnums = new ArrayList<Integer>();
			boolean notdone = true;
			while (notdone) {
				for (int j = 1; j <= larger; j *= 2) {
					if (j * 2 > larger) {
						
						actualnums.add(j);
						larger -= j;
						if (j == 1 || larger == 0) {
							notdone = false;
						}
					}

				}
			}
			ArrayList<Integer> binary = new ArrayList<Integer>();
			for (int j = 1; j <= actualnums.get(0); j *= 2) {
				binary.add(j);
			}
			
			ArrayList<Integer> multiplicand = new ArrayList<Integer>();
			
			for (int j = Math.min(Integer.parseInt(in[0]), Integer.parseInt(in[1])); j <= Math
					.max(Integer.parseInt(in[0]), Integer.parseInt(in[1])) * (Math.pow(2, actualnums.size())); j *= 2) {
				multiplicand.add(j);
			}
			//System.out.println(multiplicand.size());
			//System.out.println(binary.size());
			if(multiplicand.size()<binary.size()){
				for(int x = 0; x <= binary.size()-multiplicand.size(); x++){
					multiplicand.add(multiplicand.get(multiplicand.size()-1)*2);
				}
			}
			if(multiplicand.size()<binary.size()){
				for(int x = 0; x <= binary.size()-multiplicand.size(); x++){
					multiplicand.add(multiplicand.get(multiplicand.size()-1)*2);
				}
			}
			ArrayList<Integer> tmp1 = new ArrayList<Integer>();
			for (int j = 0; j < binary.size(); j++) {
				if (actualnums.contains(binary.get(j))) {
					tmp1.add(multiplicand.get(j));
				}
			}

			multiplicand = tmp1;
			tmp1 = new ArrayList<Integer>();
			for (int j = actualnums.size() - 1; j > -1; j--) {
				tmp1.add(multiplicand.get(j));
			}
			multiplicand = tmp1;
			for (int x : multiplicand) {
				System.out.println(x);
			}
		}
	}

}
