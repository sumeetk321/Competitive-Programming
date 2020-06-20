import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Contest4_ACEIntermediate_SumeetKulkarni {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("4int_testdata.txt"));

		String[] in = null;
		Board board;
		// 1 opp, 2 player
		// 35, 22, 27, 50, 7
		for (int i = 0; i < 5; i++) {
			/*if(i==4) {
				//System.out.println("in here");
			}*/
			in = br.readLine().split(" ");
			Marker o1, o2, o3, p1, p2, p3;
			o1 = new Marker(Integer.parseInt(in[0]));
			o2 = new Marker(Integer.parseInt(in[1]));
			o3 = new Marker(Integer.parseInt(in[2]));
			p1 = new Marker(Integer.parseInt(in[3]));
			p2 = new Marker(Integer.parseInt(in[4]));
			p3 = new Marker(Integer.parseInt(in[5]));
			board = new Board(o1, o2, o3, p1, p2, p3);
			for (int j = 7; j < in.length; j++) {
				board.roll(Integer.parseInt(in[j]));
			}
			board.printBoard();
		}

	}

}

class Marker implements Comparable<Marker> {
	private int loc = 0;

	public Marker(int pos) {
		loc = pos;
	}

	@Override
	public int compareTo(Marker o) {
		return Integer.compare(loc, o.loc);
	}

	public int getLoc() {
		return loc;
	}

	public void setLoc(int n) {
		loc = n;
	}
}

class Board {
	private Marker[] opp = new Marker[3];
	private Marker[] player = new Marker[3];
	private int[] corners = { 7, 12, 17, 22, 27, 35, 40, 45, 50 };

	public Board(Marker o1, Marker o2, Marker o3, Marker p1, Marker p2, Marker p3) {
		opp[0] = o1;
		opp[1] = o2;
		opp[2] = o3;
		player[0] = p1;
		player[1] = p2;
		player[2] = p3;
		sort();
	}

	public void sort() {
		Arrays.sort(player);
	}

	public boolean existsMarker(int pos) {
		for (Marker o : opp) {
			if (o.getLoc() == pos) {
				return true;
			}
		}
		for (Marker p : player) {
			if (p.getLoc() == pos) {
				return true;
			}
		}
		return false;
	}

	public void roll(int n) {
		if (player[0].getLoc() + n > 52) {
			return;
		} else if (player[0].getLoc() + n == 52) {
			player[0].setLoc(53);
			return;
		} else if (existsMarker(player[0].getLoc() + n)) {
			return;
		} else {
			int prevloc = player[0].getLoc();
			player[0].setLoc(prevloc + n);
			if (isPrime(player[0].getLoc())) {
				for (int i = player[0].getLoc(); i < player[0].getLoc() + 6; i++) {
					if (existsMarker(i + 1)) {
						player[0].setLoc(i);
						break;
					} else if (i == player[0].getLoc() + 5) {
						player[0].setLoc(player[0].getLoc() + 6);
						break;
					}
				}
				if (player[0].getLoc() > 52) {
					player[0].setLoc(prevloc);
				}
				if (player[0].getLoc() == 52) {
					player[0].setLoc(-1);
					return;
				}
			} else if (isSquare(player[0].getLoc()) && player[0].getLoc() > 4) {
				for (int i = player[0].getLoc(); i > player[0].getLoc() - 6; i--) {
					if (existsMarker(i - 1)) {
						player[0].setLoc(i);
						break;
					} else if (i == player[0].getLoc() - 5) {
						player[0].setLoc(player[0].getLoc() - 6);
						break;
					}
				}
				if (player[0].getLoc() < 1) {
					player[0].setLoc(prevloc);
				}
			} else if (!isPrime(player[0].getLoc()) && !isSquare(player[0].getLoc())) {
				loop: for (int x : corners) {
					if (prevloc < x && player[0].getLoc() > x) {
						for (int i = player[0].getLoc(); i >= prevloc; i--) {
							if (i == player[0].getLoc() && i % n == 0) {
								break loop;
							} else if (!existsMarker(i) && i % n == 0) {
								player[0].setLoc(i);
								break loop;
							}
						}
						player[0].setLoc(prevloc);
					}
				}
			}
		}
		sort();
	}

	public void printBoard() {
		if (player[0].getLoc() > 52 && player[1].getLoc() > 52 && player[2].getLoc() > 52) {
			System.out.println("GAME OVER");
		} else {
			for (int i = 0; i < 3; i++) {
				if (player[i].getLoc() != 53) {
					System.out.print(player[i].getLoc() + " ");
				}
			}
			System.out.println();
		}
	}

	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSquare(int n) {
		return (int) (Math.sqrt(n)) == Math.sqrt(n);
	}
}
