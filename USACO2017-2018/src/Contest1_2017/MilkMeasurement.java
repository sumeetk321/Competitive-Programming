package Contest1_2017;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class MilkMeasurement {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int days = Integer.parseInt(br.readLine());
		String[] measurements = new String[days];
		ArrayList<String> names = new ArrayList<String>();
		StringTokenizer st;
		for (int i = 0; i < days; i++) {
			String in = br.readLine();
			measurements[i] = in;
			st = new StringTokenizer(in);
			st.nextToken();
			String name = st.nextToken();
			if (!names.contains(name)){
				names.add(name);
			}
		}
		ArrayList<String> most = new ArrayList<String>(names);
		Collections.sort(most);
		int mostmilk = 7;
		int[] milk = new int[names.size()];
		for (int i = 0; i < names.size(); i++) {
			milk[i] = 7;
		}
		Arrays.sort(measurements);
		ArrayList<Integer> winning = new ArrayList<Integer>();
		int changes = 0;
		for (int i = 0; i < days; i++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(winning);
			st = new StringTokenizer(measurements[i]);
			st.nextToken();
			String name = st.nextToken();
			int change = Integer.parseInt(st.nextToken());
			milk[names.indexOf(name)] += change;
			mostmilk = maxArr(milk);
			for(int j =0; j < milk.length; j++){
				if(milk[j]==mostmilk&&!tmp.contains(j)){
					tmp.add(j);
				} else if(milk[j]<mostmilk&&tmp.contains(j)){
					tmp.remove(tmp.indexOf(j));
				}
			}
			Collections.sort(tmp);
			if(!winning.equals(tmp)){
				changes++;
				winning = new ArrayList<Integer>(tmp);
			}
		}
		System.out.println(changes);
		br.close();
	}

	public static int maxArr(int[] arr) {
		int out = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > out)
				out = arr[i];
		}
		return out;
	}

}
