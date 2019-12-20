import java.util.Scanner;

public class Prob54 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		
		while(true){
			int x1 = a.nextInt();
			int y1 = a.nextInt();
			int x2 = a.nextInt();
			int y2 = a.nextInt();
			
			int width = Math.abs(x2 - x1);
			int height = Math.abs(y2 - y1);
			
			if(width==0 || height==0){
				System.out.println("Width: " + width + " Height: " + height + " Area: " + (width*height));
				System.out.println("Finished.");
			} else {
				System.out.println("Width: " + width + " Height: " + height + " Area: " + (width*height));
			}
			
		}
	}

}
