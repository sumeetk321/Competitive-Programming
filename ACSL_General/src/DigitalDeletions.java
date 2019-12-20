import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DigitalDeletions {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("digdels.txt");
		Scanner scan = new Scanner(file);
		for (int i = 0; i < 8; i++) {
			String in = scan.nextLine();
			String[] spl = in.split(", ");
			String num = "";
			for (int j = 1; j < spl.length; j++) {
				num += spl[j];
			}
			int moves = 0;
			while (num.length() > 0) {
				boolean b = false;
				while (num.contains("0")) {
					if (num.contains("0")) {
						b = true;
						num = num.substring(num.indexOf("0") + 1);
					}
				}
				if(b) moves++;
				int index = mostOccuring_Index(num);
				String temp = "";
				for (int j = 0; j < num.length(); j++) {
					if(j!=index){
						temp+=num.charAt(j);
					} else {
						int tbc = Character.getNumericValue(num.charAt(j));
						tbc = (tbc%2==0 ? tbc-2 : tbc-1);
						temp+=tbc+"";
					}
				}
				num = temp;
				moves++;
			}
			System.out.println(moves-1);

		}

	}

	public static int mostOccuring_Index(String str) {
		ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		for (int i = 0; i < str.length(); i++) {
			nums.set(Character.getNumericValue(str.charAt(i)), nums.get(Character.getNumericValue(str.charAt(i))) + 1);
		}
		int largest = -1;
		for (int x : nums) {
			if (x > largest)
				largest = x;
		}
		int actualnum = 0;
		for (int i = nums.size() - 1; i > -1; i--) {
			if (nums.get(i) == largest) {
				actualnum = i;
				break;
			}

		}

		return str.lastIndexOf(actualnum + "");
	}

}
