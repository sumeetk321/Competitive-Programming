import java.util.Scanner;

public class SearchExpressions {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String[] words = scan.nextLine().split(", ");
		for(int i = 0; i < 10; i++){
			String in = scan.nextLine();
			String tmp = in;
			tmp = in.substring(1); 
			if(in.contains("[")){
				if(in.contains("?")){
					for(int j = 0; j < 26; j++){
						
					}
				}
			}
		}
		
		
	}

}
