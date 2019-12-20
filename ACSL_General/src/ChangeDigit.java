import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ChangeDigit {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("ChDig.txt");
		Scanner scan = new Scanner(file);
		for(int i = 0; i < 10; i++){
			int in = scan.nextInt();
			String str = Integer.toString(in);
			char[] strchar = str.toCharArray();
			Arrays.sort(strchar);
			int smallestdig = Character.getNumericValue(strchar[0]);
			int largestdig = Character.getNumericValue(strchar[strchar.length-1]);
			int digsum = 0;
			int mean = 0;
			for(int j = 0; j < str.length(); j++){
				mean+=Character.getNumericValue(str.charAt(j));
				
			}
			digsum = mean;
			mean/=str.length();
			if(digsum>9){
				digsum = Character.getNumericValue(Integer.toString(digsum).charAt(Integer.toString(digsum).length()-1));
			}
			boolean notdone = true;
			int character = 0;
			while(notdone){
				
				if(str.contains(mean+"")){
					character = str.indexOf(mean+"");
					notdone = false;
				} else {
					mean--;
					continue;
				}
			}
			if(str.charAt(character)=='0' || str.charAt(character)=='1' || str.charAt(character)=='2'){
				String nuevo = "";
				for(int j = 0; j < str.length(); j++){
					if(j!=character){
						nuevo+=str.charAt(j);
					} else {
						nuevo+=largestdig+"";
					}
				}
				str = nuevo;
			} else if(str.charAt(character)=='3' || str.charAt(character)=='4' || str.charAt(character)=='5'){
				String nuevo = "";
				for(int j = 0; j < str.length(); j++){
					if(j!=character){
						nuevo+=str.charAt(j);
					} else {
						nuevo+=smallestdig+"";
					}
				}
				str = nuevo;
			} else if(str.charAt(character)=='6' || str.charAt(character)=='7' || str.charAt(character)=='8'){
				String nuevo = "";
				for(int j = 0; j < str.length(); j++){
					if(j!=character){
						nuevo+=str.charAt(j);
					} else {
						nuevo+=digsum+"";
					}
				}
				str = nuevo;
			} else if(str.charAt(character)=='9'){
				String nuevo = "";
				for(int j = 0; j < str.length(); j++){
					if(j!=character){
						nuevo+=str.charAt(j);
					} else {
						nuevo+="0";
					}
				}
				str = nuevo;
			}
			System.out.println(Integer.parseInt(str));
		}
	}

}
