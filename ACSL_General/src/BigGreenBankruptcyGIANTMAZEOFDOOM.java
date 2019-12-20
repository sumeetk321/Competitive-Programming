import java.util.ArrayList;
import java.util.Scanner;

public class BigGreenBankruptcyGIANTMAZEOFDOOM {
	static int n = 0;
	static int m = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		int[][] grid = new int[n][m];
		for (int i = 0; i < n; i++) {

			scan = new Scanner(System.in);
			String in = scan.nextLine();
			for (int j = 0; j < m; j++) {
				grid[i][j] = Character.getNumericValue(in.charAt(j));
			}
			
		}

		int x1 = scan.nextInt();
		int y1 = scan.nextInt();
		int x2 = scan.nextInt();
		int y2 = scan.nextInt();

		ArrayList<Integer> lengths = new ArrayList<Integer>();

	}
	
	

	public static void recursion(int x, int y) {
		if(x-1>=0){
			
		}
		if(x+1<n){
			
		}
		if(y-1>=0){
			
		}
		if(y+1<m){
			
		}
		
	}

}
