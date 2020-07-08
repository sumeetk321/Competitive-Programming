
/*
ID: sumeetk1
LANG: JAVA
TASK: test
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class test {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("test.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int i1 = Integer.parseInt(st.nextToken());
		int i2 = Integer.parseInt(st.nextToken());
		out.println(i1 + i2);
		out.close();
		br.close();
	}

}
