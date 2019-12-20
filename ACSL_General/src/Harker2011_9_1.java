import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Harker2011_9_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
/*
9
When in the Course of human events, it becomes
necessary for one people to dissolve the political
bands which have connected them with another,
and to assume among the powers of the earth, the
separate and equal station to which the Laws of
Nature and of Nature's God entitle them, a decent
respect to the opinions of mankind requires that
they should declare the causes which impel them to
the separation.
12
5 33
7 35
5 41
1 20
1 30
8 46
6 41
1 13
4 8
7 31
3 43
9 15
 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int lines = Integer.parseInt(br.readLine());
		String[] message = new String[lines];
		for(int i = 0; i < lines; i++){
			message[i] = br.readLine();
		}
	
		int length = Integer.parseInt(br.readLine());
		String hidden = "";
		for(int i = 0; i < length; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			hidden+=message[Integer.parseInt(st.nextToken())-1].charAt(Integer.parseInt(st.nextToken())-1);
		}
		System.out.println(hidden);
		
	}

}
