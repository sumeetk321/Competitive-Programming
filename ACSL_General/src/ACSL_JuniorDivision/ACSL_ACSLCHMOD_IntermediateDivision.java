package ACSL_JuniorDivision;

import java.util.Scanner;

public class ACSL_ACSLCHMOD_IntermediateDivision {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 2; i++) {
			System.out.println("Enter input");
			String octal = scan.nextLine();
			int dig1 = Integer.parseInt(octal.split(", ")[0]);
			int dig2 = Integer.parseInt(octal.split(", ")[1]);
			int dig3 = Integer.parseInt(octal.split(", ")[2]);
			String bin1, bin2, bin3;
			String[] per1 = new String[3];
			String[] per2 = new String[3];
			String[] per3 = new String[3];

			bin1 = Integer.toBinaryString(dig1);
			bin2 = Integer.toBinaryString(dig2);
			bin3 = Integer.toBinaryString(dig3);

			int bin1str = bin1.length();
			if (bin1.length() < 3) {
				for (int j = 0; j < 3 - bin1str; j++) {
					bin1 = "0" + bin1;
				}
			}
			switch (bin1.charAt(0)) {
			case '1':
				per1[0] = "r";
				break;
			case '0':
				per1[0] = "-";
				break;
			}
			switch (bin1.charAt(1)) {
			case '1':
				per1[1] = "w";
				break;
			case '0':
				per1[1] = "-";
				break;
			}
			switch (bin1.charAt(2)) {
			case '1':
				per1[2] = "x";
				break;
			case '0':
				per1[2] = "-";
				break;
			}
			int bin2str = bin2.length();
			if (bin2.length() < 3) {
				for (int j = 0; j < 3 - bin2str; j++) {
					bin2 = "0" + bin2;
				}
			}
			switch (bin2.charAt(0)) {
			case '1':
				per2[0] = "r";
				break;
			case '0':
				per2[0] = "-";
				break;
			}
			switch (bin2.charAt(1)) {
			case '1':
				per2[1] = "w";
				break;
			case '0':
				per2[1] = "-";
				break;
			}
			switch (bin2.charAt(2)) {
			case '1':
				per2[2] = "x";
				break;
			case '0':
				per2[2] = "-";
				break;
			}
			int bin3str = bin3.length();
			if (bin3.length() < 3) {
				for (int j = 0; j < 3 - bin3str; j++) {
					bin3 = "0" + bin3;
				}
			}

			switch (bin3.charAt(0)) {
			case '1':
				per3[0] = "r";
				break;
			case '0':
				per3[0] = "-";
				break;
			}
			switch (bin3.charAt(1)) {
			case '1':
				per3[1] = "w";
				break;
			case '0':
				per3[1] = "-";
				break;
			}
			switch (bin3.charAt(2)) {
			case '1':
				per3[2] = "x";
				break;
			case '0':
				per3[2] = "-";
				break;
			}

			System.out.println(bin1 + " " + bin2 + " " + bin3 + " and " + per1[0] + per1[1] + per1[2] + " " + per2[0]
					+ per2[1] + per2[2] + " " + per3[0] + per3[1] + per3[2]);

		}

		for (int i = 0; i < 2; i++) {
			System.out.println("\nEnter input");
			String bin1, bin2, bin3;
			bin1 = bin2 = bin3 = "";

			String input = scan.nextLine();

			bin1 = input.split(", ")[0];
			bin2 = input.split(", ")[1];
			bin3 = input.split(", ")[2];
			String[] per1, per2, per3;
			per1 = per2 = per3 = new String[3];
			String bin1str = Integer.toString(Integer.parseInt(bin1, 2));
			String bin2str = Integer.toString(Integer.parseInt(bin2, 2));
			String bin3str = Integer.toString(Integer.parseInt(bin3, 2));
			String per10 = null;
			String per11, per12, per20, per21, per22, per30, per31, per32;
			per11 = per12 = per20 = per21 = per22 = per30 = per31 = per32 = null;

			String oct1, oct2, oct3;

			oct1 = Integer.toOctalString(Integer.parseInt(bin1str));
			oct2 = Integer.toOctalString(Integer.parseInt(bin2str));
			oct3 = Integer.toOctalString(Integer.parseInt(bin3str));

			switch (bin1.charAt(0)) {
			case '1':
				per1[0] = "r";
				per10 = per1[0];
				break;
			case '0':
				per1[0] = "-";
				per10 = per1[0];
				break;
			}
			switch (bin1.charAt(1)) {
			case '1':
				per1[1] = "w";
				per11 = per1[1];
				break;
			case '0':
				per1[1] = "-";
				per11 = per1[1];
				break;
			}
			switch (bin1.charAt(2)) {
			case '1':
				per1[2] = "x";
				per12 = per1[2];
				break;
			case '0':
				per1[2] = "-";
				per12 = per1[2];
				break;
			}

			switch (bin2.charAt(0)) {
			case '1':
				per2[0] = "r";
				per20 = per2[0];

				break;
			case '0':
				per2[0] = "-";
				per20 = per2[0];

				break;
			}
			switch (bin2.charAt(1)) {
			case '1':
				per2[1] = "w";
				per21 = per2[1];

				break;
			case '0':
				per2[1] = "-";
				per21 = per2[1];

				break;
			}
			switch (bin2.charAt(2)) {
			case '1':
				per2[2] = "x";
				per22 = per2[2];
				break;
			case '0':
				per2[2] = "-";
				per22 = per2[2];
				break;
			}

			switch (bin3.charAt(0)) {
			case '1':
				per3[0] = "r";
				per30 = per3[0];

				break;
			case '0':
				per3[0] = "-";
				per30 = per3[0];

				break;
			}
			switch (bin3.charAt(1)) {
			case '1':
				per3[1] = "w";
				per31 = per3[1];

				break;
			case '0':
				per3[1] = "-";
				per31 = per3[1];

				break;
			}
			switch (bin3.charAt(2)) {
			case '1':
				per3[2] = "x";
				per32 = per3[2];

				break;
			case '0':
				per3[2] = "-";
				per32 = per3[2];

				break;
			}

			System.out.print(oct1 + "" + oct2 + "" + oct3 + " and " + per10 + per11 + per12 + " " + per20 + per21
					+ per22 + " " + per30 + per31 + per32);

		}
		System.out.println("\nEnter input");

		String[] per = new String[3];

		String[] bin = { "", "", "" };

		String oct = "";

		String input = scan.nextLine();
		per = input.split(", ");

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				switch (per[i].charAt(j)) {
				case 'r':
					bin[i] = bin[i] + "1";
					// System.out.println(bin[i]+"in r");
					break;
				case 'w':
					bin[i] = bin[i] + "1";
					// System.out.println(bin[i]+"in w");

					break;
				case 'x':
					bin[i] = bin[i] + "1";
					break;
				case '-':
					bin[i] = bin[i] + "0";
					// System.out.println(bin[i]+"in def");

				}
			}
		}

		String bin1str = Integer.toString(Integer.parseInt(bin[0], 2));
		String bin2str = Integer.toString(Integer.parseInt(bin[1], 2));
		String bin3str = Integer.toString(Integer.parseInt(bin[2], 2));
		String oct1 = Integer.toOctalString(Integer.parseInt(bin1str));
		String oct2 = Integer.toOctalString(Integer.parseInt(bin1str));
		String oct3 = Integer.toOctalString(Integer.parseInt(bin1str));

		System.out.print(bin1str + "" + bin2str + "" + bin3str + " and ");
		for (String x : bin) {
			System.out.print(x + " ");
		}

	}

}
