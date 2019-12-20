import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class LISA {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		String[] s = new String[n];
		for (int i = 0; i < n; i++) {
			s[i] = br.readLine();
		}
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			HashSet<String> set = new HashSet<String>();
			for (int x = l; x <= r; x++) {
				for (int y = l; y <= r; y++) {
					String pre = s[x - 1];
					String suf = s[y - 1];
					int prel = pre.length();
					int sufl = suf.length();
					String[] prefixes = new String[pre.length()];
					String[] suffixes = new String[suf.length()];
					for (int z = 0; z < prel; z++) {
						prefixes[z] = pre;
						pre = pre.substring(0, pre.length() - 1);
					}
					for (int z = 0; z < sufl; z++) {
						suffixes[z] = suf;
						suf = suf.substring(1, suf.length());
					}
					int size = prefixes.length * suffixes.length;
					for (int a = 0; a < prefixes.length; a++) {
						for (int b = 0; b < suffixes.length; b++) {
							set.add(prefixes[a]+suffixes[b]);
						}
					}
					
					
				}
			}
			System.out.println(set.size());
		}
	}

}
