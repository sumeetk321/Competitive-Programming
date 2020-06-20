
//Author: Sumeet Kulkarni
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Contest2_ACEIntermediate_SumeetKulkarni {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("2int_testdata.txt"));
		for (int i = 0; i < 5; i++) {
			String[] arr = br.readLine().split(" ");
			String big = "";
			String small = "";
			boolean flipped = false;
			if (arr[0].length() > arr[1].length()) {
				big = arr[0];
				small = arr[1];
				flipped = true;
			} else {
				big = arr[1];
				small = arr[0];
			}

			System.out.println(asf(small, big, flipped));
		}
	}

	public static int asf(String str1, String str2, boolean flipped) {
		LinkedList<Character> s1 = new LinkedList<Character>();
		LinkedList<Character> s2 = new LinkedList<Character>();
		for (int i = 0; i < str1.length(); i++) {
			s1.add(str1.charAt(i));
		}
		for (int i = 0; i < str2.length(); i++) {
			s2.add(str2.charAt(i));
		}
		int out = 0;
		loop: while (true) {
			for (int j = 0; j < s2.size(); j++) {
				if (j < s1.size() && s1.get(j) == s2.get(j)) {
					s1.remove(j);
					s2.remove(j);
					j--;
				}
			}
			for (int j = 0; j < Math.max(s1.size(), s2.size()); j++) {
				if (j < s1.size() - 1 && j < s2.size() && s1.get(j + 1) == s2.get(j)) {
					if (j < s1.size() && j < s2.size() - 1 && s1.get(j) == s2.get(j + 1)) {
						s1.remove(j);
						s2.remove(j);
						s2.remove(j);
						j--;
						continue loop;
					}
					s2.remove(j);
					s1.remove(j);
					s1.remove(j);
					j--;
					continue loop;
				} else if (j < s1.size() && j < s2.size() - 1 && s2.get(j + 1) == s1.get(j)) {
					s1.remove(j);
					s2.remove(j);
					s2.remove(j);
					j--;
					continue loop;
				}
			}

			break;
		}
		for (int j = 0; j < Math.min(s1.size(), s2.size()); j++) {
			if (flipped) {
				out += s2.get(j) - s1.get(j);
			} else {
				out += s1.get(j) - s2.get(j);
			}
		}
		out += Math.abs(s1.size() - s2.size());
		return out;
	}
}
