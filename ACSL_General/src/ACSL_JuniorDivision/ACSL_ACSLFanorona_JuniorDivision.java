package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ACSL_ACSLFanorona_JuniorDivision {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("Fanorona1.txt");
		Scanner scan = new Scanner(file);
		ArrayList<Integer> NumW = new ArrayList<Integer>();
		ArrayList<Integer> NumB = new ArrayList<Integer>();
		ArrayList<Integer> captured = new ArrayList<Integer>();

		mainloop: for (int i = 0; i < 5; i++) {
			System.out.println("\n");
			String input = scan.nextLine();
			String[] inputsplit = input.split(", ");
			NumW = new ArrayList<Integer>();
			NumB = new ArrayList<Integer>();

			for (int j = 0; j < Integer.parseInt(inputsplit[0]); j++) {
				NumW.add(Integer.parseInt(inputsplit[j + 1]));
			}

			for (int j = 0; j < Integer.parseInt(inputsplit[Integer.parseInt(inputsplit[0]) + 1]); j++) {
				NumB.add(Integer.parseInt(inputsplit[Integer.parseInt(inputsplit[0]) + 2 + j]));
			}

			captured = new ArrayList<Integer>();

			secondloop: for (int o = 0; o < Integer.parseInt(inputsplit[0]); o++) {
				
				
				if (NumB.contains(NumW.get(o) + 2)) {
					if(NumW.contains(NumW.get(o)+1)){
						continue;
					}
					if (NumW.get(o) % 5 == 0) {
						continue secondloop;
					}
					if (NumW.get(o) % 5 == 4) {
						continue secondloop;
					} else {
						
						if(NumB.contains(NumW.get(o)+1)){
							if(!(NumB.contains(NumW.get(o)-1)) && !(NumW.contains(NumW.get(o)-1))){
								captured.add(NumW.get(o)+2);
								
								captured.add(NumW.get(o)+1);
								if(NumB.contains(NumW.get(o)+3)){
									captured.add(NumW.get(o)+3);
									if(NumB.contains(NumW.get(o)+4)){
										captured.add(NumW.get(o)+4);
									}
								}
								continue secondloop;
							}
						}
						if (NumB.contains(NumW.get(o) + 3)) {
							captured.add(NumW.get(o) + 3);
							if (NumB.contains(NumW.get(o) + 4)) {
								captured.add(NumW.get(o) + 4);
							}
						}

						if (NumB.contains(NumW.get(o) - 1)) {
							captured.add(NumW.get(o) - 1);
						}

						captured.add(NumW.get(o) + 2);
						// START HERE !!!!!!!!!!!!!!!!!!1
					}
				}
				if (NumB.contains(NumW.get(o) - 2)) {
					if(NumB.contains(NumW.get(o)+1)){
						if(!(NumB.contains(NumW.get(o)-1)) && !(NumW.contains(NumW.get(o)-1))){
							captured.add(NumW.get(o)+2);
							
							captured.add(NumW.get(o)+1);
							if(NumB.contains(NumW.get(o)+3)){
								captured.add(NumW.get(o)+3);
								if(NumB.contains(NumW.get(o)+4)){
									captured.add(NumW.get(o)+4);
								}
							}
							continue secondloop;
						}
					}
					if(NumB.contains(NumW.get(o)-1) || NumW.contains(NumW.get(o)-1)){
						continue;
					}
					if (NumW.get(o) % 5 == 1) {
						continue secondloop;
					}
					if (NumW.get(o) % 5 == 2) {
						continue secondloop;
					}
					if (NumB.contains(NumW.get(o) + 1)) {
						captured.add(NumW.get(o) + 1);
					}
					if (NumB.contains(NumW.get(o) - 3)) {
						captured.add(NumW.get(o) - 3);
						if (NumB.contains(NumW.get(o) - 4)) {
							captured.add(NumW.get(o) - 4);
						}
					}
					captured.add(NumW.get(o) - 2);
				}
				if (NumB.contains(NumW.get(o) - 10)) {
					if(NumB.contains(NumW.get(o)-5) || NumW.contains(NumW.get(o)-5)){
						continue;
					}
					if (NumB.contains(NumW.get(o) - 15)) {
						captured.add(NumW.get(o) - 15);
						if (NumB.contains(NumW.get(o) - 20)) {
							captured.add(NumW.get(o) - 20);
						}
					}
					if (NumB.contains(NumW.get(o) + 5)) {
						captured.add(NumW.get(o) + 5);
					}
					captured.add(NumW.get(o) - 10);
				}
				if (NumB.contains(NumW.get(o) + 10)) {
					if(NumB.contains(NumW.get(o)+5) || NumW.contains(NumW.get(o)+5)){
						continue;
					}
					if (NumB.contains(NumW.get(o) + 15)) {
						captured.add(NumW.get(o) + 15);
						if (NumB.contains(NumW.get(o) + 20)) {
							captured.add(NumW.get(o) + 20);
						}
					}
					if (NumB.contains(NumW.get(o) - 5)) {
						captured.add(NumW.get(o) - 5);
					}

					captured.add(NumW.get(o) + 10);

				}
				if (NumB.contains(NumW.get(o) + 1)) {
					if (NumB.contains(NumW.get(o) - 1) || NumW.contains(NumW.get(o) - 1)) {
						continue secondloop;
					} else {
						if (NumW.get(o) % 5 == 0) {
							continue secondloop;
						}
						if (NumB.contains(NumW.get(o) + 2)) {
							captured.add(NumW.get(o) + 2);
							if (NumB.contains(NumW.get(o) + 3)) {
								captured.add(NumW.get(o) + 3);
								if (NumB.contains(NumW.get(o) + 4)) {
									captured.add(NumW.get(o) + 4);
								}
							}
						}

						if (NumB.contains(NumW.get(o) - 1)) {
							captured.add(NumW.get(o) - 1);
						}

						captured.add(NumW.get(o) + 1);
						// START HERE
					}
				}
				if (NumB.contains(NumW.get(o) - 1)) {
					if (NumB.contains(NumW.get(o) + 1) || NumW.contains(NumW.get(o) + 1)) {
						continue secondloop;
					} else {
						if (NumW.get(o) % 5 == 1) {
							continue secondloop;
						}
						if (NumB.contains(NumW.get(o) - 2)) {
							captured.add(NumW.get(o) - 2);
							if (NumB.contains(NumW.get(o) - 3)) {
								captured.add(NumW.get(o) - 3);
								if (NumB.contains(NumW.get(o) - 4)) {
									captured.add(NumW.get(o) - 4);
								}
							}
						}
						captured.add(NumW.get(o) - 1);
					}
				}
				if (NumB.contains(NumW.get(o) - 5)) {
					if (NumB.contains(NumW.get(o) + 5) || NumW.contains(NumW.get(o) + 5)) {
						continue secondloop;
					} else {

						if (NumB.contains(NumW.get(o) - 10)) {
							captured.add(NumW.get(o) - 10);
							if (NumB.contains(NumW.get(o) - 15)) {
								captured.add(NumW.get(o) - 15);
								if (NumB.contains(NumW.get(o) - 20)) {
									captured.add(NumW.get(o) - 20);
								}
							}
						}

						if (NumB.contains(NumW.get(o) + 5)) {
							captured.add(NumW.get(o) + 5);
						}

						captured.add(NumW.get(o) - 5);
					}
				}
				if (NumB.contains(NumW.get(o) + 5)) {
					if (NumW.contains(NumW.get(o) - 5) || NumB.contains(NumW.get(o) - 5)) {
						continue secondloop;
					} else {
						if (NumB.contains(NumW.get(o) + 10)) {
							captured.add(NumW.get(o) + 10);
							if (NumB.contains(NumW.get(o) + 15)) {
								captured.add(NumW.get(o) + 15);
								if (NumB.contains(NumW.get(o) + 20)) {
									captured.add(NumW.get(o) + 20);
								}
							}
						}

						if (NumB.contains(NumW.get(o) - 5)) {
							captured.add(NumW.get(o) - 5);
						}
						captured.add(NumW.get(o) + 5);
					}
				}

			}

			int capsize = captured.size();

			for (int x = 0; x < captured.size(); x++) {
				for (int y = 0; y < captured.size(); y++) {
					if (captured.get(x) == captured.get(y) && x != y) {
						captured.remove(x);
					}
				}
			}
			
			if (capsize > 0) {
				for (int j = 0; j < captured.size(); j++) {
					System.out.print(captured.get(j) + " ");
				}
			} else {
				System.out.print("NONE");
			}

		}

	}

	public static boolean contains(String a, char b) {
		for (int a1 = 0; a1 < a.length(); a1++) {
			if (a.charAt(a1) == b)
				return true;
		}
		return false;
	}
}
