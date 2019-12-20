package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_ACSLSenet_JuniorDivision {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Senet1.txt");
		Scanner scan = new Scanner(file);
		for (int abc = 0; abc < 5; abc++) {
			ArrayList<Integer> blackPawns = new ArrayList<Integer>();
			ArrayList<Integer> whitePawns = new ArrayList<Integer>();
			String[] in = scan.nextLine().split(", ");
			int i = 0, j = 0;
			for (i = 1; i <= Integer.parseInt(in[0]); i++) {
				blackPawns.add(Integer.parseInt(in[i]));
			}
			for (i = Integer.parseInt(in[0]) + 2; i < Integer.parseInt(in[0]) + 2
					+ Integer.parseInt(in[Integer.parseInt(in[0]) + 1]); i++) {
				whitePawns.add(Integer.parseInt(in[i]));
			}
			int endingnum = 0;
			boolean done = false, cannotmove = false;
			int count = Integer.parseInt(in[in.length - 1]);
			int temp;
			loop: for (j = 1; j <= 30; j += count) {
				if (count % 3 == 0 && blackPawns.get(0) % 3 == 0) {
					endingnum = 15;
					break;
				} else if ((blackPawns.get(0) + count >= 26 && blackPawns.get(0) < 26)) {
					endingnum = 26;
					break;
				} else if (blackPawns.get(0) + count == 27 || blackPawns.get(0) == 27) {
					if (blackPawns.get(0) == 27) {
						if (count == 4) {
							done = true;
						} else {
							cannotmove = true;
						}
						break;
					}
					if (whitePawns.contains(15)) {
						whitePawns.set(whitePawns.indexOf(15), 27);
						blackPawns.set(0, 15);
						if (count % 3 == 0) {
							endingnum = 15;
						}

					} else if ((!blackPawns.contains(15)) && (!(whitePawns.contains(15)))) {
						blackPawns.set(0, 15);
						endingnum = 15;
						break;
					} else {
						if (count == 4) {
							done = true;
						} else {
							endingnum = 27;
							break;
						}
					}
				} else if (whitePawns.contains(blackPawns.get(0) + count)
						&& (blackPawns.get(0) + count != 27 || blackPawns.get(0) + count != 26)) {
					whitePawns.set(whitePawns.indexOf(blackPawns.get(0) + count), blackPawns.get(0));
					blackPawns.set(0, blackPawns.get(0) + count);
				} else if (blackPawns.contains(blackPawns.get(0) + count)) {
					if (j == 1) {
						cannotmove = true;
						break;
					}
					endingnum = blackPawns.get(0);
					break;
				} else if (blackPawns.get(0) + count == 28 || blackPawns.get(0) == 28) {
					if (count == 3) {
						done = true;
					} else {
						if (blackPawns.get(0) == 28) {
							cannotmove = true;
							break;
						} else {
							endingnum = 28;
							break;
						}
					}
				} else if (blackPawns.get(0) + count == 29 || blackPawns.get(0) == 29) {
					if (count == 2) {
						done = true;
					} else {
						if (blackPawns.get(0) == 29) {
							cannotmove = true;
							break;
						} else {
							endingnum = 29;
							break;
						}
					}
				} else if (blackPawns.get(0) + count == 31) {
					done = true;
				} else {
					endingnum = blackPawns.get(0);
				}
				blackPawns.set(0, blackPawns.get(0) + count);

				for (int x : whitePawns) {
					if (blackPawns.get(0) + count > x && x > blackPawns.get(0)) {
						whitePawns.set(whitePawns.indexOf(x), blackPawns.get(0));
						blackPawns.set(0, x);
						endingnum = x;
					}
				}
				for (int x : blackPawns) {
					if (blackPawns.get(0) + count > x && x > blackPawns.get(0)) {
						endingnum = blackPawns.get(0);
						break loop;
					}
				}

			}

			if (done) {
				System.out.println("DONE");
			} else if (cannotmove) {
				System.out.println("CANNOT MOVE");
			} else {
				System.out.println(endingnum);
			}

		}
	}

}
