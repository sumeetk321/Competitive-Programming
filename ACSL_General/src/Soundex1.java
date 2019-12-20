import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Soundex1 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Soundex1.txt");
		Scanner scan = new Scanner(file);
		ArrayList<String> vowels = new ArrayList<String>(Arrays.asList("A", "E", "I", "O", "U"));
		ArrayList<String> repeat = new ArrayList<String>(
				Arrays.asList("AA", "BB", "CC", "DD", "EE", "FF", "GG", "HH", "II", "JJ", "KK", "LL", "MM", "NN", "OO",
						"PP", "QQ", "RR", "SS", "TT", "UU", "VV", "WW", "UU", "XX", "YY", "ZZ"));
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		ArrayList<ArrayList<String>> chart = new ArrayList<ArrayList<String>>(Arrays.asList(
				new ArrayList<String>(Arrays.asList("AI", "AJ", "AY", "EI", "EY", "IE", "IO", "IU", "OI", "OJ", "OY")),
				new ArrayList<String>(Arrays.asList("AU")),
				new ArrayList<String>(Arrays.asList("A", "E", "I", "O", "U")),
				new ArrayList<String>(Arrays.asList("J")), new ArrayList<String>(Arrays.asList("Y")),
				new ArrayList<String>(Arrays.asList("C", "S", "Z", "TCH", "CS", "CSZ", "CZS", "DS", "DZ", "CZ", "TS",
						"SH", "SCH", "SZ", "TZ")),
				new ArrayList<String>(Arrays.asList("X", "CHS", "KS")),
				new ArrayList<String>(Arrays.asList("SD", "SHD", "ST", "SZD", "SCHT", "SHT", "SCHD")),
				new ArrayList<String>(Arrays.asList("B", "F", "P", "V", "W", "FB", "PF", "PH")),
				new ArrayList<String>(Arrays.asList("G", "K", "Q", "KH", "CK")),
				new ArrayList<String>(Arrays.asList("D", "T", "DT", "TH")),
				new ArrayList<String>(Arrays.asList("R", "RZ", "RS")), new ArrayList<String>(Arrays.asList("EU")),
				new ArrayList<String>(Arrays.asList("MN", "NM")), new ArrayList<String>(Arrays.asList("H")),
				new ArrayList<String>(Arrays.asList("L")), new ArrayList<String>(Arrays.asList("M", "N"))));
		ArrayList<ArrayList<Integer>> vals = new ArrayList<ArrayList<Integer>>(Arrays.asList(
				new ArrayList<Integer>(Arrays.asList(0, 1, -1)), new ArrayList<Integer>(Arrays.asList(0, 7, -1)),
				new ArrayList<Integer>(Arrays.asList(0, -1, -1)), new ArrayList<Integer>(Arrays.asList(2, 2, 2)),
				new ArrayList<Integer>(Arrays.asList(1, -1, -1)), new ArrayList<Integer>(Arrays.asList(4, 4, 4)),
				new ArrayList<Integer>(Arrays.asList(5, 54, 54)), new ArrayList<Integer>(Arrays.asList(2, 43, 43)),
				new ArrayList<Integer>(Arrays.asList(7, 7, 7)), new ArrayList<Integer>(Arrays.asList(5, 5, 5)),
				new ArrayList<Integer>(Arrays.asList(3, 3, 3)), new ArrayList<Integer>(Arrays.asList(9, 9, 9)),
				new ArrayList<Integer>(Arrays.asList(1, 1, -1)), new ArrayList<Integer>(Arrays.asList(66, 66, 66)),
				new ArrayList<Integer>(Arrays.asList(5, 5, -1)), new ArrayList<Integer>(Arrays.asList(8, 8, 8)),
				new ArrayList<Integer>(Arrays.asList(6, 6, 6))));
		for (int i = 0; i < 16; i++) {
			String name = scan.nextLine();
			String out = "";
			boolean startdone = false;
			for (int j = 0; j < chart.size(); j++) {
				for(int k = 0; k < chart.get(j).size(); k++){
					if(!startdone){
						if(name.startsWith(chart.get(j).get(k))){
							out+=vals.get(j).get(0)+"";
							name = name.substring(chart.get(j).get(k).length(), name.length());
							startdone = true;
						}
					} else {
						String in = chart.get(j).get(k);
						if(name.contains(in)){
							if(name.length()>name.indexOf(in)+in.length() && vowels.contains(name.charAt(name.indexOf(in)+in.length()))){
								if(vals.get(j).get(1)==-1){
									continue;
								} else {
									out+=vals.get(j).get(1)+"";
									name = name.substring(chart.get(j).get(k).length(),name.length());
								}
							} else {
								if(vals.get(j).get(2)==-1){
									continue;
								} else {
									out+=vals.get(j).get(2)+"";
									name = name.substring(chart.get(j).get(k).length(), name.length());
								}
							}
						}
					}
				}
			}
			int size = out.length();
			for(int j = 0; j < 6 - size; j++){
				out+="0";
			}
			System.out.println(out);
		}

	}
}
