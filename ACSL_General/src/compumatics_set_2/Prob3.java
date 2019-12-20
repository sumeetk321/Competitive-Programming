package compumatics_set_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Prob3In.txt");
		Scanner scan = new Scanner(file);
		String num = "";
		for(int i = 0; i < 100; i++){
			String tmp = scan.nextLine();
			num = num + tmp;
		}
		BigInteger sum = BigInteger.ZERO;
		for(int i = 0; i < 5000; i+=50){
			BigInteger dignum = new BigInteger(num.substring(i, i+49));
			sum = sum.add(dignum);
		}
		System.out.println(sum.toString().substring(0, 10));
	}

}
