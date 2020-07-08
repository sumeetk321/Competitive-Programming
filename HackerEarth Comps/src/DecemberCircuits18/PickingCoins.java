package DecemberCircuits18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.math.*;


public class PickingCoins {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        int T = Integer.parseInt(in);
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger N = new BigInteger(st.nextToken());
            BigInteger K = new BigInteger(st.nextToken());
            BigInteger sum = BigInteger.ZERO;
            BigInteger ind = BigInteger.ONE;
            while(sum.compareTo(N)<1){
            	sum = sum.add(K.pow(ind.intValue()));
            	if(sum.compareTo(N)==1){
            		System.out.println("Bob");
            		break;
            	}
            	sum = sum.add(K.pow(ind.intValue()));
            	if(sum.compareTo(N)==1){
            		System.out.println("Alice");
            		break;
            	}
            	ind = ind.add(BigInteger.ONE);
            }
            
        }
        
    }
}
