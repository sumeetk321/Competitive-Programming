package compumatics_set_3;

import java.util.ArrayList;

public class Prob1 {

	public static void main(String[] args) {
		long sum = 0;
		for (int i = 2; i < 10000; i++) {
			
			for (int j = i + 1; j < 10000; j++) {
				if (divisorsum(i)==j && divisorsum(j)==i) {
					sum += (i + j);
					System.out.println(i + " " + j);
				}
			}
		}
		System.out.println(sum);
	}

	public static long divisorsum(int i) {
		long sum = 0;
		for (int d = 1; d < i; d++) {
			if (i % d == 0)
				sum += d;
		}
		return sum;
	}
}
