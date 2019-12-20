package compumatics_set_2;

public class Prob7 {

	public static void main(String[] args) {
		String[] ones = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		String[] tens = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
		String[] teens = { "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
				"nineteen" };
		String hundred = "hundred";
		long num = 0;
		int thousand = 11;
		for (int i = 0; i < 1000; i++) {
			String number = "";
			if (i >= 100) {
				number += ones[Character.getNumericValue(Integer.toString(i).charAt(0))];
				number += hundred;
				if (Integer.toString(i).charAt(1) != '1') {

					number += tens[Character.getNumericValue(Integer.toString(i).charAt(1))];
					number += ones[Character.getNumericValue(Integer.toString(i).charAt(2))];

				} else {
					if (Integer.toString(i).charAt(2) == '0') {
						number += "ten";
					} else {
						number += teens[Character.getNumericValue(Integer.toString(i).charAt(2)) - 1];
					}
				}
				num += number.length();
				if (!(i % 100 == 0)) {
					num += 3;
				}
			} else {
				if (i == 10) {
					number += "ten";
				} else if (i > 10) {
					if (i < 20) {
						number += teens[Character.getNumericValue(Integer.toString(i).charAt(1)) - 1];
					} else {
						number += tens[Character.getNumericValue(Integer.toString(i).charAt(0))];
						number += ones[Character.getNumericValue(Integer.toString(i).charAt(1))];

					}
				} else if (i < 10) {
					number += ones[i];
				}
				num += number.length();
			}
			System.out.println(number + " " + num);
		}
		num += thousand;
		System.out.println(num);
	}

}
