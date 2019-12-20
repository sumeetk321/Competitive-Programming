
public class SquareDigitChains {

	public static void main(String[] args) {
		int a = 0;
		int onenums = 0;
		int othernums = 0;
		for (int i = 1; i < 10000000; i++) {
			int ending = 0;
			boolean notSolved = true;
			char[] digits = Integer.toString(i).toCharArray();

			while (notSolved) {
				int squaresum = 0;
				for (int j = 0; j < digits.length; j++) {
					squaresum += Math.pow(Character.getNumericValue(digits[j]), 2);

				}

				if (squaresum == 1) {
					onenums++;
					ending = 1;
					notSolved = false;
				} else if (squaresum == 89) {
					ending = 89;
					notSolved = false;
				}

				digits = Integer.toString(squaresum).toCharArray();

			}

			System.out.println(i);

		}
		
		othernums = 9999999-onenums;
		System.out.println("ENDING: "+othernums);
	}

}
