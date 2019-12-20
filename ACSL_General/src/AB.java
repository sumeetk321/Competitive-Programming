import java.util.*;

public class AB {
	public static void main(String[] args) {
		createString(3, 2);
	}

	public static String createString(int N, int K) {
		ArrayList<String> strings = new ArrayList<String>(Arrays.asList("A", "B"));
		ArrayList<String> tmp = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			for (String x : strings) {
				tmp.add(x+"A");
				tmp.add(x+"B");
				System.out.println(x+"A");
				System.out.println(x+"B");
			}
			strings = tmp;
			tmp.clear();
		}
		
		for(String x : strings){
			System.out.println(x);
		}
		
		return "";

	}
}