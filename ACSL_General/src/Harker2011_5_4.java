import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Harker2011_5_4 {

	public static void main(String[] args) throws IOException {
/*
abcdefghij
klmnullrst
uvwxyzabcd
efgoljklmn
opqrsruvwx
ymbiadefgh
ijkltnopqr
stuvwndzab
cdefghijkl
mnopqrstuv
null
programmer
xor
rand
rox
z
perl
ibm
void
int
 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> right = new ArrayList<String>();
		ArrayList<String> left = new ArrayList<String>();
		ArrayList<String> up = new ArrayList<String>();
		ArrayList<String> down = new ArrayList<String>();
		ArrayList<String> ur = new ArrayList<String>();
		ArrayList<String> ul = new ArrayList<String>();
		ArrayList<String> dr = new ArrayList<String>();
		ArrayList<String> dl = new ArrayList<String>();

		
		for (int i = 0; i < 10; i++) {
			String in = br.readLine();
			right.add(in);
			left.add(new StringBuilder(in).reverse().toString());
		}
		
		for(int i = 0; i < 10; i++){
			String test = "";
			for(int j = 0; j < 10; j++){
				test+=right.get(j).charAt(i);
			}
			down.add(test);
			up.add(new StringBuilder(test).reverse().toString());
		}

		String[] words = new String[10];
		for (int i = 0; i < 10; i++) {
			words[i] = br.readLine();
		}
		for (String x : words) {
			
		
	}
}

}



