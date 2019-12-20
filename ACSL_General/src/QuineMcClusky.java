import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuineMcClusky {

	public static void main(String[] args) throws FileNotFoundException {
		String bool = "ABCD";
		File file = new File("QuineMcClusky.txt");
		Scanner scan = new Scanner(file);
		for (int i = 0; i < 2; i++) {
			scan.nextLine();
			for (int j = 0; j < 5; j++) {
				String[] in = scan.nextLine().split(", ");
				String[] bins = new String[in.length];
				for (int k = 0; k < bins.length; k++) {
					bins[k] = Integer.toBinaryString(Integer.parseInt(in[k]));
					if (bins[k].length() < 4) {
						int len = bins[k].length();
						for (int l = 0; l < 4 - len; l++) {
							bins[k] = "0" + bins[k];
						}
					}
				}
				String out = "";
				if(bins.length==2){
					for(int k = 0; k < 4; k++){
						if(bins[0].charAt(k)==bins[1].charAt(k)){
							out+=bins[0].charAt(k);
						} else {
							out+="x";
						}
					}
				} else {
					String out1 = "";
					String out2 = "";
					for(int k = 0; k < 4; k++){
						if(bins[0].charAt(k)==bins[1].charAt(k)){
							out+=bins[0].charAt(k);
						} else {
							out+="x";
						}
					}
					for(int k = 0; k < 4; k++){
						if(bins[2].charAt(k)==bins[3].charAt(k)){
							out1+=bins[2].charAt(k);
						} else {
							out1+="x";
						}
					}
					for(int k = 0; k < 4; k++){
						if(out.charAt(k)==out1.charAt(k)){
							out2+=out.charAt(k);
						} else {
							out2+="x";
						}
					}
					out = out2;
				}
				String outbool = "";
				for(int k = 0; k< out.length(); k++){
					if(out.charAt(k)=='1'){
						outbool+=bool.charAt(k);
					} else if(out.charAt(k)=='0'){
						outbool+=(bool.charAt(k)+"").toLowerCase();
					}
				}
				System.out.println(out+", "+outbool);
			}
		}

	}

}
