
public class Emirp_Primes {

	public static void main(String[] args) {
		//no. 1
		int emirps = 0;
		int i = 10;
		while(emirps<100){
			if(isEmirp(i)){
				System.out.print(i+" ");
				emirps++;
			}
			i++;
		}
		
		
		//no. 2
		System.out.println("\n");
		int startnum = 7700;
		int endnum = 8000;
		
		for(int i1 = startnum; i1 <= endnum; i1++){
			if(isEmirp(i1)){
				System.out.print(i1+" ");
			}
		}
		//no. 3
		System.out.println("\n");
		int emirps3 = 0;
		int i2 = 10;
		while(emirps3<10000){
			if(isEmirp(i2)){
				System.out.println(i2);
				emirps3++;
			}
			if(emirps==10000){
				System.out.print(i2+" ");
			}
			i2++;
		}

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
	
	
	public static boolean isEmirp(long a){
		char[] temp = Integer.toString((int) a).toCharArray();
		String dog = "";
		if(temp.length<2){
			return false;
		}
		if(!(isPrime(a))){
			return false;
		}
		for(int i = temp.length-1; i>= 0; i--){
			dog+=temp[i];
		}
		if(isPrime(Integer.parseInt(dog)) && Integer.parseInt(dog)!=a){
			return true;
		} else {
			return false;
		}
	}

}
