import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TwistedCircuit {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		/*
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int d = Integer.parseInt(br.readLine());
		*/
		for(int a = 0; a < 2; a++){
			for(int b = 0; b < 2; b++){
				for(int c = 0; c < 2; c++){
					for(int d = 0; d < 2; d++){
						int circuit = ((a|b)&(c^d))|((b&c)^(a|d));
						out.println(circuit+", "+a+""+b+""+c+""+d);
					}
				}
			}
		}
		
		out.close();
		br.close();
	}

}
