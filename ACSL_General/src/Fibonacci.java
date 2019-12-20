import java.util.ArrayList;
import java.util.Arrays;

public class Fibonacci {

	public static void main(String[] args) {

		 ArrayList<Integer> test = new ArrayList<Integer>(Arrays.asList(1, 1));
		 for(int x : prob(test)){
			 System.out.print(x+" ");
		 }
		 System.out.println("\n");
		 ArrayList<Integer> test1 = new ArrayList<Integer>(Arrays.asList(1, 1, 2));
		 for(int x : prob(test1)){
			 System.out.print(x+" ");
		 }
		 System.out.println("\n");
		 ArrayList<Integer> test2 = new ArrayList<Integer>(Arrays.asList(1, 1, 2, 4));
		 for(int x : prob(test2)){
			 System.out.print(x+" ");
		 }
		 System.out.println("\n");
		 ArrayList<Integer> test3 = new ArrayList<Integer>(Arrays.asList(2, 1));
		 for(int x : prob(test3)){
			 System.out.print(x+" ");
		 }
		
	}

	
	public static ArrayList<Integer> prob(ArrayList<Integer> x){
		int tmp = 0;
		int size = x.size();
		for(int a = 0; a < 8; a++){
			tmp = 0;
			for(int b = x.size()-1; b >= x.size()-size; b--){
			
				tmp+=x.get(b);
			}
			x.add(tmp);
		}
		return x;
		
		
	}
}


