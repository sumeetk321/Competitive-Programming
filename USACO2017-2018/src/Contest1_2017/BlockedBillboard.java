package Contest1_2017;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BlockedBillboard {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int firstx1 = Integer.parseInt(st.nextToken());
		int firsty1 = Integer.parseInt(st.nextToken());
		int firstx2 = Integer.parseInt(st.nextToken());
		int firsty2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int secondx1 = Integer.parseInt(st.nextToken());
		int secondy1 = Integer.parseInt(st.nextToken());
		int secondx2 = Integer.parseInt(st.nextToken());
		int secondy2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int thirdx1 = Integer.parseInt(st.nextToken());
		int thirdy1 = Integer.parseInt(st.nextToken());
		int thirdx2 = Integer.parseInt(st.nextToken());
		int thirdy2 = Integer.parseInt(st.nextToken());
		int length = Math.max(firstx2, Math.max(secondx2, thirdx2));
		int height = Math.max(firsty2, Math.max(secondy2, thirdy2));
		int[][] view = new int[height][length];
		int a1 = (firstx2 - firstx1) * (firsty2 - firsty1);
		int a2 = (secondx2 - secondx1) * (secondy2 - secondy1);
		int minusx1 = 1001;
		int minusy1 = 1001;
		int minusx2 = -1001;
		int minusy2 = -1001;
		for (int i = Math.max(firstx1, thirdx1); i <= Math.min(firstx2, thirdx2); i++) {
			for (int j = Math.max(firsty1, thirdy1); j <= Math.min(firsty2, thirdy2); j++) {
				minusx1 = Math.min(minusx1, i);
				minusy1 = Math.min(minusy1, j);
				minusx2 = Math.max(minusx2, i);
				minusy2 = Math.max(minusy2, j);
			}
		}
		if (a1 >= (minusx2 - minusx1) * (minusy2 - minusy1)) {
			a1 -= (minusx2 - minusx1) * (minusy2 - minusy1);
		}
		minusx1 = 1001;
		minusy1 = 1001;
		minusx2 = -1001;
		minusy2 = -1001;
		for (int i = Math.max(secondx1, thirdx1); i <= Math.min(secondx2, thirdx2); i++) {
			for (int j = Math.max(secondy1, thirdy1); j <= Math.min(secondy2, thirdy2); j++) {
				minusx1 = Math.min(minusx1, i);
				minusy1 = Math.min(minusy1, j);
				minusx2 = Math.max(minusx2, i);
				minusy2 = Math.max(minusy2, j);
			}
		}
		if (a2 >= (minusx2 - minusx1) * (minusy2 - minusy1)) {
			a2 -= (minusx2 - minusx1) * (minusy2 - minusy1);
		}
		out.println(a1 + a2);
		out.close();
		br.close();
	}

}
