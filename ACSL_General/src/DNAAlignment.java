import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DNAAlignment {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("DNAAlignment.txt"));
		for(int i = 0; i < 5; i++){
			String[] in = br.readLine().split(", ");
			String str1 = in[0];
			String str2 = in[1];
			//why does this problem exist
			
			
		}
	}
}
