import java.util.*;

public class a {

	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();
		int o = 0;
		for (int i = 1; i < 501; i++) {
			for (int j = i + 1; j < 501; j++) {
				if (j * j == i * i + N) {
					o++;
				}
			}
		}
		System.out.println(o);
	}

}
