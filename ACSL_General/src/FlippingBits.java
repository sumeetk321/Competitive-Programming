
public class FlippingBits {

	public static void main(String[] args) {

		int[][] start = {
				{ (int) Math.round(Math.random()), (int) Math.round(Math.random()), (int) Math.round(Math.random()) },
				{ (int) Math.round(Math.random()), (int) Math.round(Math.random()), (int) Math.round(Math.random()) },
				{ (int) Math.round(Math.random()), (int) Math.round(Math.random()), (int) Math.round(Math.random()) } };

		int[][] end = { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } };
		int moves = 0;
		for (int i = 0; i < 100; i++) {
			if (Math.round(Math.random()) == 0) {
				int rownum = 0;
				rownum = (int) Math.round(Math.random() * 2);
				for (int j = 0; j < 3; j++) {
					if (start[rownum][j] == 0) {
						start[rownum][j] = 1;
					} else {
						start[rownum][j] = 0;
					}
				}
			} else {
				int columnnum = 0;
				columnnum = (int) Math.round(Math.random() * 2);
				for (int j = 0; j < 3; j++) {
					if (start[j][columnnum] == 0) {
						start[j][columnnum] = 1;
					} else {
						start[j][columnnum] = 0;
					}
				}
			}

			moves++;
			boolean checker = true;
			main: for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					System.out.print(start[j][k] + " ");

					if (start[j][k] == end[j][k]) {
						continue;
					} else {
						checker = false;
					}
				}
				System.out.println("\n");

			}
			System.out.println("Moves: " + moves);

			if (checker) {
				System.out.println("Done! Moves: " + moves);
				break;
			} else if (i == 99) {
				System.out.println("Unsolvable!");
			}
		}
	}

}
