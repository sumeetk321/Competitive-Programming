/*
ID: sumeetk1
LANG: JAVA
TASK: wormhole
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class wormhole {

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new FileReader("wormhole.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Coordinate[] points = new Coordinate[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			points[i] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(points, new Comparator<Coordinate>(){
			@Override
			public int compare(Coordinate arg0, Coordinate arg1) {
				return arg0.getX()-arg1.getX();
			}
		});
		int[] x = new int[n];
		int[] y = new int[n];
		for(int i = 0; i < points.length; i++){
			x[i] = points[i].getX();
			y[i] = points[i].getY();
		}
		int[] destination = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (x[j] > x[i] && y[i] == y[j]) {
					if (destination[i] == 0 || x[j] - x[i] < x[destination[i]] - x[i]) {
						destination[i] = j + 1;
					}
				}
			}
		}
		out.println(solve(x, y, new int[n], destination));
		out.close();
	}

	private static int solve(int[] x, int[] y, int[] pairing, int[] destination) {
		int i, output = 0;
		for (i = 0; i < x.length; i++) {
			if (pairing[i] == 0) {
				break;
			}
		}
		if (i >= x.length - 1) {
			return (isCycle(x, y, pairing, destination) ? 1 : 0);
		}
		for (int j = i + 1; j < x.length; j++) {
			if (pairing[j] == 0) {
				pairing[i] = j + 1;
				pairing[j] = i + 1;
				output += solve(x, y, pairing, destination);
				pairing[i] = 0;
				pairing[j] = 0;
			}
		}
		return output;
	}

	private static boolean isCycle(int[] x, int[] y, int[] pairing, int[] destination) {
		loop: for (int i = 1; i <= x.length; i++) {
			int pointer = i;
			for (int j = 0; j < x.length; j++) {
				int toright = destination[pointer - 1];
				if (toright == 0) {
					continue loop;
				}
				pointer = pairing[toright - 1];
				if (pointer == i) {
					return true;
				}
			}
		}
		return false;
	}
}

class Coordinate {
	private int x;
	private int y;

	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}