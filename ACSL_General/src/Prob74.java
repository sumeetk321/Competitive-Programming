import java.util.Scanner;

public class Prob74 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int cooktime = scan.nextInt();
				
		if(Integer.toString(cooktime).length() <= 2){
			System.out.println("0:" + cooktime);
		} else {
			String cooktimestring = Integer.toString(cooktime);
			String firstPart = cooktimestring.substring(0, (cooktimestring.length() - 2));
			String secondPart = cooktimestring.substring(cooktimestring.length() - 2);
			System.out.println(firstPart + ":" + secondPart);
		}
		
	}

}
