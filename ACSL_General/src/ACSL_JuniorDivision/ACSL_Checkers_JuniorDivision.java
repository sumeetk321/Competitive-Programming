package ACSL_JuniorDivision;

import java.util.ArrayList;
import java.util.Scanner;

public class ACSL_Checkers_JuniorDivision {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter input");
		ArrayList<String> opponentPairs = new ArrayList<String>();
		int numofopponentpairs = 0;
		int[] myPair = new int[2];

		String number = scan.nextLine();
		boolean isInHomeRow = false;
		String letters[] = number.split(", ");

		myPair[0] = Integer.parseInt(letters[0]);
		myPair[1] = Integer.parseInt(letters[1]);
		numofopponentpairs = Integer.parseInt(letters[2]);
		ArrayList<String> opPairs = new ArrayList<String>();

		for (int i = 0; i < numofopponentpairs; i++) {
			opponentPairs.add(letters[i + 3]);
		}
		int legalmoves = 0;;

		for (int j = 0; j < numofopponentpairs-1; j++) {
			opPairs.add(toPair(Integer.parseInt(opponentPairs.get(j)), Integer.parseInt(opponentPairs.get(j + 1))));
		}

		boolean notDone = true;

		while (myPair[1] < 8) {
			if (opPairs.contains(toPair(myPair[0] + 1, myPair[1] + 1)) && (myPair[0] < 7)
					&& (!opPairs.contains(toPair(myPair[0] + 2, myPair[1] + 2)))) {
				
				myPair[0]+=2;
				if(myPair[1]+2>8){
					break;
				}
				myPair[1]+=2;
				legalmoves++;
				System.out.println("x" + toPair(myPair[0], myPair[1]));
				
			} else if (opPairs.contains(toPair(myPair[0] + 1, myPair[1] + 1)) && (myPair[0] < 7)
					&& (!opPairs.contains(toPair(myPair[0] - 2, myPair[1] + 2)))) {
				
				if(myPair[1]+2>8){
					break;
				}
				myPair[1]+=2;
				legalmoves++;
				System.out.println("y" + toPair(myPair[0], myPair[1]));
			} else if (opPairs.contains(toPair(myPair[0] - 1, myPair[1] + 1)) && (myPair[0] > 2)
					&& (!opPairs.contains(toPair(myPair[0] , myPair[1] + 2)))) {
				if(myPair[1]+2>8){
					break;
				}
				myPair[1]+=2;
				legalmoves++;
				System.out.println("z" + toPair(myPair[0], myPair[1]));
			} else if (opPairs.contains(toPair(myPair[0] + 1, myPair[1] + 1)) && (myPair[0] > 2)
					&& (!opPairs.contains(toPair(myPair[0] - 2, myPair[1] + 2)))) {
				
				myPair[0]-=2;
				if(myPair[1]+2>8){
					break;
				}
				myPair[1]+=2;
				legalmoves++;
				System.out.println("1" + toPair(myPair[0], myPair[1]));
			}else if (!(opPairs.contains(toPair(myPair[0] + 1, myPair[1] + 1))) && (myPair[0] + 1 <= 8)
					&& (myPair[1] + 1 <= 8) && (myPair[0] < 8)) {
				myPair[0]++;
				if(myPair[1]+1>8){
					break;
				}
				myPair[1]++;
				legalmoves++;
				System.out.println("3" + toPair(myPair[0], myPair[1]));
			} else if (!(opPairs.contains(toPair(myPair[0] - 1, myPair[1] + 1))) && (myPair[0] - 1 <= 8)
					&& (myPair[1] + 1 <= 8)) {
				myPair[0]--;
				if(myPair[1]+1>8){
					break;
				}
				myPair[1]++;
				legalmoves++;
				System.out.println("2" + toPair(myPair[0], myPair[1]));
			} else {
				break;
			}

		}

		System.out.println(toPair(myPair[0], myPair[1]));
		System.out.print(legalmoves);
		if (myPair[1] == 8) {
			System.out.print(", KING");
		}
	}

	public static String toPair(int a, int b) {
		return (a + "," + b);
	}
}
