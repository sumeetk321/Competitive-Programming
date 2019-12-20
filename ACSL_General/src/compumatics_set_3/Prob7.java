package compumatics_set_3;

import java.util.Scanner;

public class Prob7 {

	public static void main(String[] args) {
		int max = -1;
		int val = 0;
		for (int a = -999; a < 1000; a++) {
			for (int b = -999; b < 1000; b++) {
				int n = 0;
				while (isPrime((int) Math.pow(n, 2) + (a * n) + b)) {
					n++;
				}
				if (n > max) {
					max = n;
					val = a * b;
				}

			}
		}
		System.out.println(val);
	}

	public static boolean isPrime(int x) {
		int n = x;

		int i = 5;
		if (n <= 1) {
			return false;
		} else if (n <= 3) {
			return true;
		} else if (n % 2 == 0 || n % 3 == 0) {
			return false;
		} else {

			while ((i * i) <= n) {
				if (n % i == 0 || n % (i + 2) == 0) {
					return false;
				}

				i = i + 6;
			}

			return true;
		}

	}
}
