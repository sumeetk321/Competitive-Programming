import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PushPop {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("PushPop.txt");
		Scanner scan = new Scanner(file);
		for (int i = 0; i < 2; i++) {
			String[] data = scan.nextLine().split(", ");
			ArrayList<Integer> q = new ArrayList<Integer>();
			Stack<Integer> s = new Stack<Integer>();
			for (int j = 0; j < data.length - 1; j++) {
				q.add(Integer.parseInt(data[j]));
				s.push(Integer.parseInt(data[j]));
			}
			for (int j = 0; j < 10; j++) {
				String[] coms = scan.nextLine().split(", ");
				if (coms[0].equals("S")) {
					Stack<Integer> s1 = (Stack<Integer>) s.clone();
					
					for (int k = 1; k < coms.length - 1; k++) {
						ArrayList<Integer> med = new ArrayList<Integer>(s1);
						Collections.sort(med);
						int high = -1, low = 10;
						int medindex = s1.indexOf(med.get(s1.size()%2==0?(med.size()/2)-1:(med.size()-1)/2));
						for (int l = 0; l < s1.size(); l++) {
							if (s1.get(l) > high)
								high = s1.get(l);
							if (s1.get(l) < low)
								low = s1.get(l);
						}

						String test = coms[k];
						if (test.startsWith("P(")) {
							s1.push(Integer.parseInt(test.charAt(2) + ""));
						} else if (test.equals("P")) {
							s1.pop();
						} else if (test.startsWith("L(")) {
							s1.add(s1.indexOf(low), Integer.parseInt(test.charAt(2) + ""));
						} else if (test.startsWith("H(")) {
							s1.add(s1.lastIndexOf(high) + 1, Integer.parseInt(test.charAt(2) + ""));
						} else if (test.equals("L")) {
							s1.remove(s1.indexOf(low));
						} else if (test.equals("H")) {
							s1.remove(s1.lastIndexOf(high));
						} else if (test.startsWith("M(")) {
							s1.add(medindex+1, Integer.parseInt(test.charAt(2) + ""));
						}
					}
					for (int x : s1) {
						System.out.print(x);
					}
					System.out.println();
				} else {
					ArrayList<Integer> q1 = new ArrayList<Integer>(q);
					for (int k = 1; k < coms.length - 1; k++) {
						ArrayList<Integer> med = new ArrayList<Integer>(q1);
						Collections.sort(med);
						int high = -1, low = 10;
						
						int medindex = q1.indexOf(med.get(q1.size()%2==0?(q1.size()/2)-1:(q1.size()-1)/2));
						for (int l = 0; l < q1.size(); l++) {
							if (q1.get(l) > high)
								high = q1.get(l);
							if (q1.get(l) < low)
								low = q1.get(l);
						}
						String test = coms[k];
						if (test.startsWith("P(")) {
							q1.add(Integer.parseInt(test.charAt(2) + ""));
						} else if (test.equals("P")) {
							q1.remove(0);
						} else if (test.startsWith("L(")) {
							q1.add(q1.indexOf(low), Integer.parseInt(test.charAt(2) + ""));
						} else if (test.startsWith("H(")) {
							q1.add(q1.lastIndexOf(high) + 1, Integer.parseInt(test.charAt(2) + ""));
						} else if (test.equals("L")) {
							q1.remove(q1.indexOf(low));
						} else if (test.equals("H")) {
							q1.remove(q1.lastIndexOf(high));
						} else if (test.startsWith("M(")) {
							q1.add(medindex+1, Integer.parseInt(test.charAt(2) + ""));
						}
					}
					for (int x : q1) {
						System.out.print(x);
					}
					System.out.println();
				}
			}
		}
	}

}
