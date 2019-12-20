import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Soundex {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Soundex.txt");
		Scanner scan = new Scanner(file);
		for(int i = 0; i < 10; i++){
			String one = "BFPV";
			String two = "CGJKQSXZ";
			String three = "DT";
			String four = "L";
			String five = "MN";
			String six = "R";
			String disregard = "AEIOUHWY";
			String name = scan.nextLine();
			String code ="";
			code+=name.charAt(0);
			int prevnum = 0;
			for(int j = 1; j < name.length(); j++){
				if(code.length()==4) break;
				String letter = name.charAt(j)+"";
				if(disregard.contains(letter)){
					prevnum = 0;
					continue;
				} else if(one.contains(letter) && prevnum!=1){
					code+="1";
					prevnum = 1;
				} else if(two.contains(letter) && prevnum!=2){
					code+="2";
					prevnum = 2;
				}else if(three.contains(letter) && prevnum!=3){
					code+="3";
					prevnum = 3;
				}else if(four.contains(letter) && prevnum!=4){
					code+="4";
					prevnum = 4;
				}else if(five.contains(letter) && prevnum!=5){
					code+="5";
					prevnum = 5;
				}else if(six.contains(letter) && prevnum!=6){
					code+="6";
					prevnum = 6;
				}
			}
			for(int j = 0; j < 4 - code.length(); j++){
				code+="0";
			}
			for(int j = 0; j < 4 - code.length(); j++){
				code+="0";
			}
			System.out.println(code);
			
		}
	}

}
