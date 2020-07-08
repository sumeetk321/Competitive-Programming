import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class measurement_silver {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[][] measure = new int[N][3];
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			measure[i][0] = Integer.parseInt(st.nextToken());
			measure[i][1] = Integer.parseInt(st.nextToken());
			map.put(measure[i][1], G);
			measure[i][2] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(measure, new Comparator<int[]>(){

			@Override
			public int compare(int[] arg0, int[] arg1) {
				return Integer.compare(arg0[0], arg1[0]);
			}
			
		});
		int max = G;
		int count = 0;
		ArrayList<Integer> board = new ArrayList<Integer>();
		ArrayList<Integer> tmpboard =  new ArrayList<Integer>();
		loop:for(int i = 0; i < N; i++){
			int id = measure[i][1];
			int change = measure[i][2];
			map.put(id, map.get(id)+change);
			max = Math.max(map.get(id), max);
			for(int id1 : map.keySet()){
				if(map.get(id1)==max){
					tmpboard.add(id1);
				}
			}
			if(max==G){
				board = (ArrayList<Integer>) tmpboard.clone();
				tmpboard.clear();
				count++;
				continue loop;
			}
			if(board.size()!=tmpboard.size()){
				board = (ArrayList<Integer>) tmpboard.clone();
				tmpboard.clear();
				count++;
				continue loop;
			}
			for(int x : board){
				if(!tmpboard.contains(x)){
					board = (ArrayList<Integer>) tmpboard.clone();
					tmpboard.clear();
					count++;
					continue loop;
				}
			}
			tmpboard.clear();
		}
		pw.println(count);
		pw.close();
		br.close();
	}

}

