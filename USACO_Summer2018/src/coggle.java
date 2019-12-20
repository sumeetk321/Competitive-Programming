import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class coggle {
	static boolean[][] visited = new boolean[5][5];
	static ArrayList<String> dict = new ArrayList<String>();
	static ArrayList<String> used = new ArrayList<String>();
	static int numwords = 0;
	static int maxlen = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[][] board = new String[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = st.nextToken();
			}
		}
		String test;
		while ((test = br.readLine()) != null) {
			dict.add(test);
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					createWord(board[i][j], test, board, i, j);
					visited = new boolean[5][5];
				}
			}
			maxlen = Math.max(maxlen, test.length());
		}

		System.out.println(numwords);
	}

	public static void createWord(String x, String test, String[][] board, int i, int j) {
		if (test.equals(x)&&!used.contains(x)) {
			used.add(x);
			numwords++;
			return;
		}
		if(!test.startsWith(x)){
			return;
		}
		visited[i][j] = true;
		if (i > 0 && !visited[i - 1][j]) {
			createWord(x + board[i - 1][j], test, board, i - 1, j);
		}
		if (i < board.length - 1 && !visited[i + 1][j]) {
			createWord(x + board[i + 1][j], test, board, i + 1, j);
		}
		if (j > 0 && !visited[i][j - 1]) {
			createWord(x + board[i][j - 1], test, board, i, j - 1);
		}
		if (j < board[0].length - 1 && !visited[i][j + 1]) {
			createWord(x + board[i][j + 1], test, board, i, j + 1);
		}
		if (i > 0 && j > 0 && !visited[i - 1][j - 1]) {
			createWord(x + board[i - 1][j - 1], test, board, i - 1, j - 1);
		}
		if (i < board.length - 1 && j > 0 && !visited[i + 1][j - 1]) {
			createWord(x + board[i + 1][j - 1], test, board, i + 1, j - 1);
		}
		if (i > 0 && j < board[0].length - 1 && !visited[i - 1][j + 1]) {
			createWord(x + board[i - 1][j + 1], test, board, i - 1, j + 1);
		}
		if (i < board.length - 1 && j < board[0].length - 1 && !visited[i + 1][j + 1]) {
			createWord(x + board[i + 1][j + 1], test, board, i + 1, j + 1);
		}
		visited[i][j] = false;
	}
}
