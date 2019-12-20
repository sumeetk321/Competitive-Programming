
public class Extensible_Prime_Generator {

	public static void main(String[] args) {
		System.out.println("1. ");
		prob1();
		System.out.println("\n");
		System.out.println("2. ");
		prob2();
		System.out.println("\n");
		System.out.println("3. ");
		prob3();
		System.out.println("\n");
		System.out.println("4. ");
		prob4();
	}

	public static boolean isPrime(long a) {
		for (int i = 2; i <= Math.sqrt(a); i++) {
			if (a == 1) {
				return false;
			}
			if (a == 2) {
				return true;
			}
			if (a % i == 0) {
				return false;
			} else {
				continue;
			}

		}
		return true;
	}

	public static void prob1() {
		// no. 1
		int primes = 0;
		int i = 2;
		while (primes < 20) {
			if (isPrime(i)) {
				System.out.print(i + " ");
				primes++;

			}
			i++;
		}
	}

	public static void prob2() {
		// no. 2
		int startnum = 100;
		int endnum = 150;
		for(int i = startnum; i <= endnum; i++){
			if(isPrime(i)){
				System.out.print(i+" ");
			}
		}
	}
	
	public static void prob3(){
		//no. 3
		int startnum = 7700;
		int endnum = 8000;
		int primes = 0;
		for(int i = startnum; i <= endnum; i++){
			if(isPrime(i)){
				primes++;
			}
		}
		
		System.out.print(primes);
		
	}
	
	public static void prob4(){
		//no. 4
		int primes = 0;
		int i = 2;
		while(primes<10000){
			
			if(isPrime(i)){
				primes++;
			}
			if(primes==10000){
				System.out.print(i);
			}
			i++;
			
		}
	}

}
