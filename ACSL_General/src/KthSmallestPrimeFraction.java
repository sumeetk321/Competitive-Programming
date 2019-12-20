import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class KthSmallestPrimeFraction {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] A = br.readLine().split(", ");
		ArrayList<Double> list = new ArrayList<Double>();
		int k = Integer.parseInt(br.readLine());
		for(int i = 0; i < A.length-1; i++){
			for(int j = i+1; j < A.length; j++){
				list.add((double)((double)Integer.parseInt(A[i])/(double)Integer.parseInt(A[j])));
			}
		}
		System.out.println(list.toString());
		Collections.sort(list);
		System.out.println(list.toString());
		double kthsmallest = list.get(k-1);
		for(int i = 0; i < A.length-1; i++){
			for(int j = i+1; j < A.length; j++){
				if((double)((double)Integer.parseInt(A[i])/(double)Integer.parseInt(A[j]))==kthsmallest){
					System.out.println("["+A[i]+", "+A[j]+"]");
				}
			}
		}
	}
}
