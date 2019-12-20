import java.util.Scanner;
class Prob19 {
	public static void main(String[] args){
		final int boltPrice, nutPrice, wasPrice;
		boltPrice = 5;
		nutPrice = 3;
		wasPrice = 1;
		
		Scanner s = new Scanner(System.in);
		int b = s.nextInt();
		
		Scanner s1 = new Scanner(System.in);
		int n = s1.nextInt();
		
		Scanner s2 = new Scanner(System.in);
		int w = s2.nextInt();
		
		if (n>=b) {
			if (2*w>=b) {
				System.out.println((b*boltPrice)+(n*nutPrice)+(w*wasPrice));
			} else if (n<b){
				System.out.println("Too few nuts!");
				System.out.println((b*boltPrice)+(n*nutPrice)+(w*wasPrice));
			} else if (2*w<b) {
				System.out.println("Too few washers!");
				System.out.println((b*boltPrice)+(n*nutPrice)+(w*wasPrice));
			}
		} else if (n < b){
			System.out.println("Too few nuts!");
			System.out.println((b*boltPrice)+(n*nutPrice)+(w*wasPrice));
		} else if (2*w<b){
			System.out.println("Too few washers!");
			System.out.println((b*boltPrice)+(n*nutPrice)+(w*wasPrice));
		}
	}
}
