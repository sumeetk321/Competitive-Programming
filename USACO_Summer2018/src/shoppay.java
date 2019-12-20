import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class shoppay {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> line = new LinkedList<Integer>();
		@SuppressWarnings("unchecked")
		Queue<Integer>[] registers = new LinkedList[N];
		for (int i = 0; i < N; i++) {
			registers[i] = new LinkedList<Integer>();
		}
		String test;
		StringTokenizer st;
		while ((test = br.readLine())!=null) {
			st = new StringTokenizer(test);
			String command = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			if (command.equals("C")) {
				line.add(num);
			} else {
				registers[num-1].add(line.remove());
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(registers[i].size()+" ");
			while (!registers[i].isEmpty()) {
				System.out.print(registers[i].remove()+" ");
			}
			System.out.println();
		}
	}

}
