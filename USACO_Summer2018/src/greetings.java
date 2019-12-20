import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class greetings {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		MoveInstruction[] bessie = new MoveInstruction[B];
		int timesum1 = 0;
		int bcounter = 0;
		for (int i = 0; i < B; i++) {
			st = new StringTokenizer(br.readLine());
			bessie[i] = new MoveInstruction(Integer.parseInt(st.nextToken()), st.nextToken());
			// System.out.println(bessie[i].time+", "+bessie[i].direction);
			timesum1 += bessie[i].time;
		}
		//System.out.println();
		MoveInstruction[] elsie = new MoveInstruction[E];
		int timesum2 = 0;
		int ecounter = 0;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			elsie[i] = new MoveInstruction(Integer.parseInt(st.nextToken()), st.nextToken());
			// System.out.println(elsie[i].time+", "+elsie[i].direction);
			timesum2 += elsie[i].time;
		}
		int bpos = 0;
		int epos = 0;
		int moo = 0;
		boolean moopossible = false;
		for (int i = 0; i < Math.max(timesum1, timesum2); i++) {
			String bdirection = "";
			if (bcounter < bessie.length) {
				if (bessie[bcounter].time <= 0) {
					bcounter++;
				}
				if (bcounter < bessie.length) {
					switch (bessie[bcounter].direction) {
					case "L":
						bpos--;
						bdirection = "L";
						break;
					case "R":
						bpos++;
						bdirection = "R";
						break;
					}
					bessie[bcounter].time--;
				}
			}
			String edirection = "";
			if (ecounter < elsie.length) {

				if (elsie[ecounter].time <= 0) {
					ecounter++;
				}
				if (ecounter < elsie.length) {
					switch (elsie[ecounter].direction) {
					case "L":
						epos--;
						edirection = "L";
						break;
					case "R":
						epos++;
						edirection = "R";
						break;
					}
					elsie[ecounter].time--;
				}
			}

			if ((!moopossible && !bdirection.equals(edirection)) || (bpos != epos)) {
				moopossible = true;
			}
			if ((bpos == epos) && moopossible) {
				moo++;
				moopossible = false;
				//System.out.println(bpos);
			}
			// System.out.println(bpos+", "+epos);
		}
		System.out.println(moo);
	}

}

class MoveInstruction {
	public int time;
	public String direction;

	public MoveInstruction(int time, String direction) {
		this.time = time;
		this.direction = direction;
	}
}