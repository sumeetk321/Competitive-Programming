package ACSL_SeniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ACSL_ACSLPinochle_SeniorDivision {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("PinochleS1.txt");
		Scanner scan = new Scanner(file);
		int points;
		for (int i = 0; i < 4; i++) {
			points = 0;
			String trump = null, nont1 = null, nont2 = null, nont3 = null;
			String[] in = scan.nextLine().split(", ");
			switch (in[0]) {
			case "D":
				trump = in[1];
				nont1 = in[2];
				nont2 = in[3];
				nont3 = in[4];
				break;
			case "C":
				trump = in[2];
				nont1 = in[1];
				nont2 = in[3];
				nont3 = in[4];
				break;
			case "S":
				trump = in[3];
				nont1 = in[1];
				nont2 = in[2];
				nont3 = in[4];
				break;
			case "H":
				trump = in[4];
				nont1 = in[1];
				nont2 = in[2];
				nont3 = in[3];
				break;
			}
			int aces = 0, kings = 0, queens = 0, jacks = 0, tens = 0;
			for (int j = 0; j < trump.length(); j++) {
				switch (trump.charAt(j) + "") {
				case "A":
					aces++;
					break;
				case "K":
					kings++;
					break;
				case "Q":
					queens++;
					break;
				case "J":
					jacks++;
					break;
				case "T":
					tens++;
					break;
				}
			}
			boolean singlebook = false, doublebook = false;
			if (aces >= 1 && kings >= 1 && queens >= 1 && jacks >= 1 && tens >= 1) {
				singlebook = true;
				points += 15;
			}
			if (aces == 2 && kings == 2 && queens == 2 && jacks == 2 && tens == 2) {
				doublebook = true;
				points += 165;
			}

			if ((singlebook && (!doublebook))) {
				if (kings == 2 && queens == 2) {
					points += 4;
				}
			}
			if (((!singlebook) && (!doublebook))) {
				if (kings >= 1 && queens >= 1) {
					points += 4;
				}
			}
			aces = 0;
			kings = 0;
			queens = 0;
			jacks = 0;
			tens = 0;
			if (in[1].contains("A") && in[2].contains("A") && in[3].contains("A") && in[4].contains("A")) {
				aces = (in[1].length() - in[1].replace("A", "").length())
						+ (in[2].length() - in[2].replace("A", "").length())
						+ (in[3].length() - in[3].replace("A", "").length())
						+ (in[4].length() - in[4].replace("A", "").length());
			}
			if (aces >= 4)
				points += 10;
			if (aces == 8)
				points += 110;
			aces = 0;
			if (in[1].contains("K") && in[2].contains("K") && in[3].contains("K") && in[4].contains("K")) {
				kings = (in[1].length() - in[1].replace("K", "").length())
						+ (in[2].length() - in[2].replace("K", "").length())
						+ (in[3].length() - in[3].replace("K", "").length())
						+ (in[4].length() - in[4].replace("K", "").length());
			}
			if (kings >= 4)
				points += 8;
			if (kings == 8)
				points += 88;
			kings = 0;
			if (in[1].contains("Q") && in[2].contains("Q") && in[3].contains("Q") && in[4].contains("Q")) {
				queens = (in[1].length() - in[1].replace("Q", "").length())
						+ (in[2].length() - in[2].replace("Q", "").length())
						+ (in[3].length() - in[3].replace("Q", "").length())
						+ (in[4].length() - in[4].replace("Q", "").length());
			}
			if (queens >= 4)
				points += 6;
			if (queens == 8)
				points += 66;
			queens = 0;
			if (in[1].contains("J") && in[2].contains("J") && in[3].contains("J") && in[4].contains("J")) {
				jacks = (in[1].length() - in[1].replace("J", "").length())
						+ (in[2].length() - in[2].replace("J", "").length())
						+ (in[3].length() - in[3].replace("J", "").length())
						+ (in[4].length() - in[4].replace("J", "").length());
			}
			if (jacks >= 4)
				points += 4;
			if (jacks == 8)
				points += 44;
			jacks = 0;
			for (int j = 0; j < nont1.length(); j++) {
				if (nont1.charAt(j) == 'K') {
					kings++;
				}
				if (nont1.charAt(j) == 'Q') {
					queens++;
				}
			}
			if (kings >= 1 && queens >= 1) {
				points += 2;
			}
			kings = 0;
			queens = 0;
			for (int j = 0; j < nont2.length(); j++) {
				if (nont2.charAt(j) == 'K') {
					kings++;
				}
				if (nont2.charAt(j) == 'Q') {
					queens++;
				}
			}
			if (kings >= 1 && queens >= 1) {
				points += 2;
			}
			kings = 0;
			queens = 0;
			for (int j = 0; j < nont3.length(); j++) {
				if (nont3.charAt(j) == 'K') {
					kings++;
				}
				if (nont3.charAt(j) == 'Q') {
					queens++;
				}
			}
			if (kings >= 1 && queens >= 1) {
				points += 2;
			}
			kings = 0;
			queens = 0;
			for (int j = 0; j < in[1].length(); j++) {
				if (in[1].charAt(j) == 'J') {
					jacks++;
				}
			}
			for (int j = 0; j < in[3].length(); j++) {
				if (in[3].charAt(j) == 'Q') {
					queens++;
				}
			}
			if (jacks >= 1 && queens >= 1) {
				if (jacks == 2 && queens == 2) {
					points += 34;
				}
				points += 4;
			}

			System.out.println(points);

		}
	}

}
