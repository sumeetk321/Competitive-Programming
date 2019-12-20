import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class munch {
	static int len = Integer.MAX_VALUE;
	static String[][] grid1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] start = new int[2];
		int[] end = new int[2];
		String[][] grid = new String[R][C];
		for (int i = 0; i < R; i++) {
			String row = br.readLine();
			for (int j = 0; j < row.length(); j++) {
				grid[i][j] = row.charAt(j) + "";
				if (grid[i][j].equals("C")) {
					start[0] = i;
					start[1] = j;
				}
				if (grid[i][j].equals("B")) {
					end[0] = i;
					end[1] = j;
				}
			}
		}
		floodfill(grid, start, end, 0, new ArrayList<int[]>());
		System.out.println(len);
	}

	public static void floodfill(String[][] grid, int[] start, int[] end, int length, ArrayList<int[]> visited) {
		if (start[0] == end[0] && start[1] == end[1]) {
			if(length<len){
				len = length;
			}
			return;
		}
		if (start[1] + 1 < grid[0].length && (!grid[start[0]][start[1] + 1].equals("*"))
				&& (!checkContains(visited, new int[] { start[0], start[1] + 1 }))) {
			visited.add(new int[] { start[0], start[1] + 1 });
			floodfill(grid, new int[] { start[0], start[1] + 1 }, end, length + 1, visited);
			visited.remove(visited.size() - 1);
		}
		if (start[0] + 1 < grid.length && (!grid[start[0] + 1][start[1]].equals("*"))
				&& (!checkContains(visited, new int[] { start[0] + 1, start[1] }))) {
			visited.add(new int[] { start[0] + 1, start[1] });
			floodfill(grid, new int[] { start[0] + 1, start[1] }, end, length + 1, visited);
			visited.remove(visited.size() - 1);
		}
		
		if (start[0] - 1 >= 0 && (!grid[start[0] - 1][start[1]].equals("*"))
				&& (!checkContains(visited, new int[] { start[0] - 1, start[1] }))) {
			visited.add(new int[] { start[0] - 1, start[1] });
			floodfill(grid, new int[] { start[0] - 1, start[1] }, end, length + 1, visited);
			visited.remove(visited.size() - 1);
		}
		if (start[1] - 1 >= 0 && (!grid[start[0]][start[1] - 1].equals("*"))
				&& (!checkContains(visited, new int[] { start[0], start[1] - 1 }))) {
			visited.add(new int[] { start[0], start[1] - 1 });
			floodfill(grid, new int[] { start[0], start[1] - 1 }, end, length + 1, visited);
			visited.remove(visited.size() - 1);
		}

		return;
	}

	public static boolean checkContains(ArrayList<int[]> test, int[] arr) {
		for (int[] x : test) {
			if (x[0] == arr[0] && x[1] == arr[1]) {
				return true;
			}
		}
		return false;
	}

}
