//Author: Sumeet Kulkarni
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Contest1_ACEIntermediate_SumeetKulkarni {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter input:");
		mainloop: for (int i = 0; i < 5; i++) {
			String[] in = scan.nextLine().split(", ");
			for (int j = 0; j < 11; j++) {
				if (in[j].equals("T")) {
					in[j] = "10";
				} else if (in[j].equals("J")) {
					in[j] = "11";
				} else if (in[j].equals("Q")) {
					in[j] = "12";
				} else if (in[j].equals("K")) {
					in[j] = "13";
				} else if (in[j].equals("A")) {
					in[j] = "14";
				}
			}
			int pointsum = Integer.parseInt(in[0]);
			ArrayList<Integer> playerhand = new ArrayList<Integer>();
			playerhand.add(Integer.parseInt(in[1]));
			playerhand.add(Integer.parseInt(in[2]));
			playerhand.add(Integer.parseInt(in[3]));
			for (int j = 4; j < 11; j++) {
				if (j % 2 == 0) {
					Collections.sort(playerhand);
					Collections.reverse(playerhand);
					int add = playerhand.get(0);
					playerhand.add(Integer.parseInt(in[j]));
					playerhand.remove(playerhand.indexOf(add));
					pointsum += getValue(add, pointsum);
					if (pointsum > 99) {
						System.out.println(pointsum + ", dealer");
						continue mainloop;
					}
				} else {
					int add = Integer.parseInt(in[j]);
					pointsum += getValue(add, pointsum);
					if (pointsum > 99) {
						System.out.println(pointsum + ", player");
						continue mainloop;
					}
				}
			}
		}
	}

	public static int getValue(int add, int pointsum) {
		if (add == 9) {
			return 0;
		} else if (add == 10) {
			return -10;
		} else if (add == 14) {
			if (pointsum < 86) {
				return 14;
			} else {
				return 1;
			}
		} else {
			return add;
		}
	}
}
