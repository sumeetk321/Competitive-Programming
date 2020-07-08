package Contest2_2019_Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class perimeter {
	static boolean[][] visited;
	static String[][] arr;
	static int tmparea = 0;
	static int tmpperim = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
		int N = Integer.parseInt(br.readLine());
		arr = new String[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++){
			String in = br.readLine();
			for(int j = 0; j < N; j++){
				arr[i][j] = in.charAt(j)+"";
			}
		}
		int area = 0;
		int perim = 0;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(!visited[i][j]&&arr[i][j].equals("#")){
					recurse(i, j);
					if(tmparea>area){
						area = tmparea;
						perim = tmpperim;
					}
					if(tmparea==area){
						perim = Math.min(perim, tmpperim);
					}
					tmparea = 0;
					tmpperim = 0;
				}
			}
		}
		pw.println(area+" "+perim);
		pw.close();
		br.close();
	}
	public static void recurse(int i, int j){
		if(i<0||i>=visited.length||j<0||j>=visited.length){
			return;
		}
		if(visited[i][j]){
			return;
		}
		if(arr[i][j].equals(".")){
			tmpperim++;
			return;
		}
		visited[i][j]=true;
		tmparea++;
		if(i==0){
			tmpperim++;
		}
		if(i==visited.length-1){
			tmpperim++;
		}
		if(j==0){
			tmpperim++;
		}
		if(j==visited.length-1){
			tmpperim++;
		}
		
		recurse(i+1, j);
		recurse(i-1, j);
		recurse(i, j+1);
		recurse(i, j-1);
	}
}
