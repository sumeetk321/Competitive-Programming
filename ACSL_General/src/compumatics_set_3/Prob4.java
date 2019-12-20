package compumatics_set_3;

import java.util.ArrayList;
import java.util.Collections;

public class Prob4 {

	public static void main(String[] args) {
		ArrayList<Long> lexicographic = new ArrayList<Long>();
		for (int a = 2; a <= 9; a++) {
			for (int b = 1; b <= 9; b++) {
				for (int c = 4; c <= 9; c++) {
					for (int d = 7; d <= 9; d++) {
						for (int e = 3; e <= 9; e++) {
							for (int f = 9; f <= 9; f++) {
								for (int g = 8; g <= 9; g++) {
									for (int h = 6; h <= 9; h++) {
										for (int i = 5; i <= 9; i++) {
											for (int j = 0; j <= 9; j++) {
												if (!(a == b || a == c || a == d || a == e || a == f || a == g || a == h
														|| a == i || a == j || b == c || b == d || b == e || b == f
														|| b == g || b == h || b == i || b == j || c == d || c == e
														|| c == f || c == g || c == h || c == i || c == j || d == e
														|| d == f || d == g || d == h || d == i || d == j || e == f
														|| e == g || e == h || e == i || e == j || f == g || f == h
														|| f == i || f == j || g == h || g == i || g == j || h == i
														|| h == j || i == j)) {
													long test = (Long.parseLong((a+""+b+""+c+""+d+""+e+""+f+""+g+""+h+""+i+""+j+"")));
													if(!lexicographic.contains(test)){
														lexicographic.add(test);
														System.out.println(test);
													}
													if(lexicographic.size()==1000000){
														System.out.println("ANSWER: "+lexicographic.get(999999));
														System.exit(0);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		Collections.sort(lexicographic);
		System.out.println(lexicographic.get(999999));

	}

}
