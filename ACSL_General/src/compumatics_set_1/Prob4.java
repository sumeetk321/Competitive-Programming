package compumatics_set_1;

public class Prob4 {

	public static void main(String[] args) {

		int a, b, largest = 0, product;

		for(a = 100;a < 999; a++){
			for(b = 100; b < 999; b++){
				product = a*b;
				String tester = Integer.toString(product);


				if(tester.length()==5) {
					if(tester.charAt(0)==tester.charAt(4) && tester.charAt(1)==tester.charAt(2) && product > largest){
						largest = product;
					}
				} else if(tester.length()==6){
					if(tester.charAt(0)==tester.charAt(5) && tester.charAt(1) == tester.charAt(4) && tester.charAt(2) == tester.charAt(3) && product > largest){
						largest = product;
					}
				}
			}
		}
		
		System.out.println(largest);
		
	}
}


