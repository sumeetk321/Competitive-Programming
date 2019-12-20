package compumatics_set_2;

public class Prob4 {

	public static void main(String[] args) {
		long biggestchain = 0;
		long biggestnum = 0;
		for(int i = 1; i < 1000000; i++){
			if(Collatz(i)>biggestchain){
				biggestchain = Collatz(i);
				biggestnum = i;
			}
		}
		System.out.println(biggestnum);
	}
	
	public static long Collatz(long a){
		long steps = 0;
		long result = a;

		while (result != 1) {
			if (result % 2 == 0) {
				result /= 2;
				steps++;
			} else {
				result = (3 * result) + 1;
				steps++;
			}
		}
		return steps;
	}
}
