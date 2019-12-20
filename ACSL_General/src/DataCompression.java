import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataCompression {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("DataCompression.txt");
		Scanner scan = new Scanner(file);
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < 8; i++) {
			ArrayList<String> counted = new ArrayList<String>();
			String next = scan.nextLine();
			String[] in = next.split(" ");
			String puncts = "";
			for (int j = 0; j < in.length; j++) {
				String test = in[j];
				String tmp = "";
				for(int k = 0; k < test.length(); k++){
					if(alphabet.contains(test.charAt(k)+"")){
						tmp+=test.charAt(k);
					} else {
						if(!puncts.contains(test.charAt(k)+"")){
							puncts+=test.charAt(k);
						}
					}
				}
				if(counted.contains(tmp)){
					continue;
				}
				counted.add(tmp);
				int times = 1;
				for (int k = j + 1; k < in.length; k++) {
					if (in[k].contains(tmp)) {
						times++;
					}
				}
				System.out.print(times + "" + tmp);
			}
			for(int k = 0; k < puncts.length(); k++){
				int testnum = 0;
				String tester = puncts.charAt(k)+"";
				for(int l = 0; l < next.length(); l++){
					if((next.charAt(l)+"").equals(tester)){
						testnum++;
					}
				}
				System.out.print(testnum+""+tester);
			}
			System.out.println();
		}
	}

}
