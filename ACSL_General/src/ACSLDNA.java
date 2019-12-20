import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ACSLDNA {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("ACSLDNA.txt");
		Scanner scan = new Scanner(file);
		for (int i = 0; i < 9; i++) {
			String[] in = scan.nextLine().split(", ");
			switch (in[1]) {
			case "DR":
				for(String x : directRepeat(in[0])){
					System.out.print(x+" ");
				}
				System.out.println();
				break;
			case "MR":
				for(String x : mirrorRepeat(in[0])){
					System.out.print(x+" ");
				}
				System.out.println();
				break;
			case "IR":
				for(String x : invertedRepeat(in[0])){
					System.out.print(x+" ");
				}
				System.out.println();
				break;
			}
		}
	}

	public static Set<String> directRepeat(String in){
		Set<String> strs = new HashSet<String>();
		for(int i = 0; i < in.length(); i++){
			for(int j = i+1; j < in.length(); j++){
				String test = in.substring(i, j)+""+in.substring(i,j);
				if(in.contains(test)){
					strs.add(test);
				}
			}
		}
		return strs;
	}
	public static Set<String> mirrorRepeat(String in){
		Set<String> strs = new HashSet<String>();
		for(int i = 0; i < in.length(); i++){
			for(int j = i+2; j < in.length(); j++){
				String test = in.substring(i, j)+""+(new StringBuilder(in.substring(i, j)).reverse());
				if(in.contains(test)){
					strs.add(test);
				}
			}
		}
		return strs;
	}
	public static Set<String> invertedRepeat(String in){
		Set<String> strs = new HashSet<String>();
		for(int i = 0; i < in.length(); i++){
			for(int j = i+2; j < in.length(); j++){
				String tmp = "";
				for(int k = 0; k < in.substring(i, j).length(); k++){
					switch(in.substring(i, j).charAt(k)){
					case 'A':
						tmp+="L";
						break;
					case 'C':
						tmp+="S";
						break;
					case 'S':
						tmp+="C";
						break;
					case 'L':
						tmp+="A";
						break;
					}
				}
				String test = in.substring(i, j)+ (new StringBuilder(tmp).reverse());
				if(in.contains(test)){
					strs.add(test);
				}
			}
		}
		return strs;
	}
}
