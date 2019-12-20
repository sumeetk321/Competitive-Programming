import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class gates {
	static boolean[][] farm;

	// V - E + F = 2
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// farm = new boolean[2001][2001];
		String in = br.readLine();
		int startr = 0;
		int startc = 0;
		ArrayList<FencePoint> V = new ArrayList<FencePoint>();
		ArrayList<FenceEdge> E = new ArrayList<FenceEdge>();
		V.add(new FencePoint(0, 0));
		// farm[startr][startc] = true;
		for (int i = 0; i < N; i++) {
			int befr = startr;
			int befc = startc;
			switch (in.charAt(i)) {
			case 'N':
				startr--;
				break;
			case 'S':
				startr++;
				break;
			case 'E':
				startc++;
				break;
			case 'W':
				startc--;
				break;
			}
			boolean add = true;
			for (FencePoint x : V) {
				if (x.x == startr && x.y == startc) {
					//System.out.println("darn");
					add = false;
					break;
				}
			}
			if (add) {
				V.add(new FencePoint(startr, startc));
			}
			add = true;
			for (FenceEdge x : E) {
				if (x.start.x == startr && x.start.y == startc && x.end.x == befr && x.end.y == befc) {
					//System.out.println("darn1");
					add = false;
					break;
				} else if(x.start.x==befr&&x.start.y==befc&&x.end.x==startr&&x.end.y==startc){
					//System.out.println("darn2");
					add = false;
					break;
				}
			}
			if (add) {
				E.add(new FenceEdge(new FencePoint(startr, startc), new FencePoint(befr, befc)));
			}

		}
		/*for(FencePoint x : V){
			System.out.println(x.x+", "+x.y);
		}
		System.out.println();
		for(FenceEdge x : E){
			System.out.println(x.start.x+", "+x.start.y+" : "+x.end.x+", "+x.end.y);
		}*/
		//System.out.println(E.size());
		System.out.println((2 - V.size() + E.size()) - 1);
	}
}

class FencePoint {
	public int x;
	public int y;

	public FencePoint(int x1, int y1) {
		x = x1;
		y = y1;
	}
}

class FenceEdge {
	public FencePoint start;
	public FencePoint end;

	public FenceEdge(FencePoint s, FencePoint e) {
		start = s;
		end = e;
	}
}
