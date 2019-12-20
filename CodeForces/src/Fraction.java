import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class Fraction {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		int n = Integer.parseInt(br.readLine());
		for(int i = n/2; i>0; i--){
			BigInteger num = BigInteger.valueOf(i);
			BigInteger denom = BigInteger.valueOf(n-i);
			if(num.gcd(denom).equals(BigInteger.ONE)){
				out.println(num.toString()+" "+denom.toString());
				break;
			}
		}
		br.close();
		out.close();
	}

}
