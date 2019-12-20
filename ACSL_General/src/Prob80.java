import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Prob80 {

	public static void main(String [] args) throws FileNotFoundException {
		File file = new File("Prob80.txt");
		Scanner scan = new Scanner(file);
		int  a = scan.nextInt();
		int b;
		
		/*int a = Integer.parseInt(v);
		int b = Integer.parseInt(w);
		int c = Integer.parseInt(x);
		int d = Integer.parseInt(y);
		int e = Integer.parseInt(z);*/
		int max = a;
		
		while(scan.hasNext())
		{
			b = scan.nextInt();
			if(b>max) max = b;
		}
		System.out.println(max);
	}
}
