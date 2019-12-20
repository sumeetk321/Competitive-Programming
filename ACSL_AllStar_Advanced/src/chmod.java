import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class chmod {

	static String file = "ugo";
	static String permission = "rwx";
	static char[][] ans;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int x = 0; x < 10; x++) {
			ans = new char[3][3];
			String[] in = br.readLine().split(", ");
			String bin = Integer.toBinaryString(Integer.parseInt(in[0], 8));
			while (bin.length() < 9) bin = "0" + bin;
			int index = 0;
			for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) {
				if (bin.charAt(index++) == '1') ans[i][j] = permission.charAt(j);
				else ans[i][j] = '-';
			}
			String[] com = in[1].split(",");
			for (int i = 0; i < com.length; i++) {
				String a = "";
				String p = "";
				int j = 1;
				if (com[i].charAt(0) == 'a') a += "ugo";
				else for (j = 0; com[i].charAt(j) == 'g' || com[i].charAt(j) == 'u' || com[i].charAt(j) == 'o'; j++) 
					a += com[i].charAt(j);
				char op = com[i].charAt(j);
				for (j = j + 1; j < com[i].length(); j++) p += com[i].charAt(j);
				command(a, p, op);
			}
			String ret = "";
			for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) ret += ans[i][j];
			System.out.println(ret);
		}
	}

	private static void command(String a, String p, char op) {
		for (int i = 0; i < a.length(); i++) {
			if (op == '+') for (int j = 0; j < p.length(); j++) 
				ans[file.indexOf(a.charAt(i))][permission.indexOf(p.charAt(j))] = p.charAt(j);
			else if (op == '-') for (int j = 0; j < p.length(); j++)
				ans[file.indexOf(a.charAt(i))][permission.indexOf(p.charAt(j))] = '-';
			else for (int j = 0; j < 3; j++) {
				if (!p.contains(permission.charAt(j) +""))
					ans[file.indexOf(a.charAt(i))][j] = '-';
				else ans[file.indexOf(a.charAt(i))][j] = permission.charAt(j);
			}
		}
	}
	
}