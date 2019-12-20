import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WeirdNumbers {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("WeirdNumbers.txt");
		Scanner scan = new Scanner(file);
		for (int i = 0; i < 17; i++) {

			String in = scan.nextLine();
			String[] nums = in.split(", ");
			int num1 = Integer.parseInt(nums[0]), num2 = Integer.parseInt(nums[1]);
			// System.out.println(in+" IN");
			switch (num1) {
			case 1:
				for (int j = num2 - 1; j > 0; j--) {
					if (isPrime(j)) {
						System.out.println(j);
						break;
					}
				}
				break;
			case 2:
				for (int j = num2 - 3; j > 0; j--) {
					if (areTwinPrimes(j, j + 2)) {
						System.out.println(j + ", " + (j + 2));
						break;
					}
				}
				break;
			case 3:
				loop: for (int a = num2 - 1; a > 0; a--) {
					for (int b = a - 1; b > 0; b--) {
						if (isAmicablePair(a, b)) {
							System.out.println(b + ", " + a);
							break loop;
						}
					}
				}
				break;
			case 4:
				for (int a = num2 - 1; a > 0; a--) {
					if (isPerfect(a)) {
						System.out.println(a);
						break;
					}
				}
				break;
			case 5:
				for (int j = num2 - 1; j > 0; j--) {
					ArrayList<Integer> divisors = new ArrayList<Integer>();
					divisors.add(1);
					for (int a = 2; a <= (int) Math.sqrt(j); a++) {
						if (j % a == 0) {
							divisors.add(a);
							divisors.add(j / a);
						}
					}
					Set<Integer> set = new HashSet<Integer>();
					set.addAll(divisors);
					divisors.clear();
					divisors.addAll(set);
					set.clear();
					if (isSemiPerfect(j, divisors)) {
						System.out.println(j);
						break;
					}
				}
				break;
			case 6:
				for (int a = num2 - 1; a > 0; a--) {
					if (isAbundant(a)) {
						System.out.println(a);
						break;
					}
				}
				break;
			case 7:
				for (int a = num2 - 1; a > 0; a--) {
					if (isDeficient(a)) {
						System.out.println(a);
						break;
					}
				}
				break;
			case 8:
				for (int j = num2 - 1; j > 0; j--) {
					ArrayList<Integer> divisors = new ArrayList<Integer>();
					divisors.add(1);
					for (int a = 2; a <= (int) Math.sqrt(j); a++) {
						if (j % a == 0) {
							divisors.add(a);
							divisors.add(j / a);
						}
					}
					Set<Integer> set = new HashSet<Integer>();
					set.addAll(divisors);
					divisors.clear();
					divisors.addAll(set);
					set.clear();
					
					if (isSemiPerfect(j, divisors)) {
						continue;
					} else if (isAbundant(j)) {
						System.out.println(j);
						break;
					}
				}
				break;

			}
		}

	}

	public static boolean isPrime(int k) {
		if (k < 2) {
			return false;
		} else if (k == 2) {
			return true;
		} else if (k == 3) {
			return true;
		} else if (k % 2 == 0 || k % 3 == 0) {
			return false;
		} else {
			int i = 5;
			while (i * i <= k) {
				if (k % i == 0 || k % (i + 2) == 0) {
					return false;
				}
				i += 6;
			}
			return true;
		}

	}

	public static boolean areTwinPrimes(int k, int k1) {
		if (k1 - k != 2) {
			return false;
		} else {
			if (isPrime(k) && isPrime(k1)) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static boolean isAmicablePair(int k, int l) {
		if (sumOfProperDivisors(k) == l && sumOfProperDivisors(l) == k && k != l) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isPerfect(int k) {
		if (sumOfProperDivisors(k) == k) {
			return true;
		}
		return false;
	}

	public static boolean isSemiPerfect(int x, List<Integer> list) {
		if (x == 0)
			return true;
		for (int i = 0; i < list.size(); i++) {
			int temp = list.remove(i);
			if (isSemiPerfect(x - temp, list))
				return true;
			list.add(i, temp);
		}

		return false;
	}

	public static boolean isAbundant(int k) {
		if (sumOfProperDivisors(k) > k) {
			return true;
		}
		return false;
	}

	public static boolean isDeficient(int k) {
		if (sumOfProperDivisors(k) < k) {
			return true;
		}
		return false;
	}

	public static int sumOfProperDivisors(int k) {
		int sum = 0;
		for (int i = 2; i <= (int) Math.sqrt(k); i++) {
			if (k % i == 0) {
				sum += i;
				sum += (k / i);
			}
		}
		return (sum + 1);
	}

}
