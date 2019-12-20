import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BoxesPacking {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		int boxnum = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> boxes = new ArrayList<Integer>();
		for(int i = 0; i < boxnum; i++){
			boxes.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(boxes);
		int visibles = 0;
		while(boxes.size()>0){
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			for(int i = 1; i < boxes.size(); i++){
				if(boxes.get(i).equals(boxes.get(i-1))){
					tmp.add(boxes.get(i));
				}
			}
			boxes = new ArrayList<Integer>(tmp);
			Collections.sort(boxes);
			visibles++;
		}
		out.println(visibles);
		out.close();
		br.close();
	}

}
