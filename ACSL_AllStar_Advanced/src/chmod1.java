import java.util.*;

public class chmod1 {

	static String perm = "rwx";
	static String dir = "ugo";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		for (int x = 0; x < 10; x++) {
			String[] in = scan.nextLine().split(", ");
			String binary = Integer.toBinaryString(Integer.parseInt(in[0], 8));
			char[][] ans = new char[3][3];
			for (int i = 0; i < binary.length(); i++) 
				if (binary.charAt(i) == '0') ans[i / 3][i % 3] = '-';
				else ans[i / 3][i % 3] = perm.charAt(i % 3);
			String[] commands = in[1].split(",");
			for (int i = 0; i < commands.length; i++) {
				String a = "", p = "";
				char op = '.';
				for (int j = 0;; j++) {
					char cur = commands[i].charAt(j);
					if (cur == '+' || cur == '-' || cur == '=') {
						op = cur;
						break;
					}
					a += commands[i].charAt(j);
				}
				for (int j = commands[i].indexOf(op) + 1; j < commands[i].length(); j++) p += commands[i].charAt(j);
				if (op == '+') {
					for (int k = 0; k < p.length(); k++) for (int j = 0; j < a.length(); j++) 
						if (a.charAt(j) == 'a') ans[0][perm.indexOf(p.charAt(k))] = 
						 	ans[1][perm.indexOf(p.charAt(k))] = ans[2][perm.indexOf(p.charAt(k))] = p.charAt(k);
						else ans[dir.indexOf(a.charAt(j))][perm.indexOf(p.charAt(k))] = p.charAt(k);
				}
				else if (op == '-') {
					for (int k = 0; k < p.length(); k++) for (int j = 0; j < a.length(); j++) 
						if (a.charAt(j) == 'a') ans[0][perm.indexOf(p.charAt(k))] = 
						 	ans[1][perm.indexOf(p.charAt(k))] = ans[2][perm.indexOf(p.charAt(k))] = '-';
						else ans[dir.indexOf(a.charAt(j))][perm.indexOf(p.charAt(k))] = '-';
				}
				else if (op == '=') {
					for (int k = 0; k < p.length(); k++) for (int j = 0; j < a.length(); j++) {
						if (a.charAt(j) == 'a') for (int l = 0; l < 3; l++) {
							if (perm.charAt(l) != p.charAt(k)) ans[0][l] = ans[1][l] = ans[2][l] = '-';
							else ans[0][l] = ans[1][l] = ans[2][l] = p.charAt(k);
						}
						else for (int l = 0; l < 3; l++) {
							if (perm.charAt(l) != p.charAt(k)) 
								ans[dir.indexOf(a.charAt(j))][l] = '-';
							else ans[dir.indexOf(a.charAt(j))][l] = p.charAt(k);
						}
					}
				}
			}
			for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) System.out.print(ans[i][j]);
		}
		scan.close();
	}

}