package compumatics_set_3;

import java.math.BigInteger;
import java.util.ArrayList;

public class Prob5 {

	public static void main(String[] args) {

		BigInteger beforenum1  = BigInteger.ONE;
		BigInteger beforenum2 = BigInteger.valueOf(2);
		boolean notdone = true;
		int i = 2;
		while (notdone) {
			BigInteger fib = beforenum1.add(beforenum2);
			beforenum2 = beforenum1;
			beforenum1 = fib;
		//	System.out.println(fib);
			i++;
			if(fib.toString().length()==1000){
				System.out.println("ANSWER: "+i);
				notdone = false;
			}
		}
	}

}
