package compumatics_set_2;

import java.util.ArrayList;

public class Prob2 {

	public static void main(String[] args) {
		boolean solved = false;
		int index = 1;
		while (!solved) {
			int tri = 0;
			for (int j = 0; j <= index; j++) {
				tri += j;
			}
			ArrayList<Long> factors = new ArrayList<Long>();
			long i = 2;
			long input = tri;

			while (i < (input / 2) + 2) {

				if (input % i == 0) {
					factors.add(i);
				}

				if (i > (input / 2)) {
					factors.add(input);
				}
				i++;

			}
			System.out.print(index+" "+tri+" factors: ");
			for(long x : factors){
				System.out.print(x+" ");
			}
			System.out.println("\n");
			if (factors.size() >= 500) {
				System.out.println(tri);
				solved = true;
			}
			index++;
		}
	}

}
