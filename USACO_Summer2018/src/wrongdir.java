import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class wrongdir {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String path = br.readLine();
		String[] choices = new String[] { "F", "L", "R" };
		HashSet<int[]> endings = new HashSet<int[]>();
		for (int i = 0; i < path.length(); i++) {
			loop:for (int j = 0; j < 3; j++) {
				int[] pos = new int[] { 0, 0 };
				String dir = "N";
				for (int k = 0; k < path.length(); k++) {
					String currstr = path.charAt(k) + "";
					if (i == k) {
						if(currstr.equals(choices[j])){
							continue loop;
						}
						currstr = choices[j];
					}
					switch (currstr) {
					case "F":
						switch (dir) {
						case "N":
							pos[1]++;
							break;
						case "S":
							pos[1]--;
							break;
						case "E":
							pos[0]++;
							break;
						case "W":
							pos[0]--;
							break;
						}
						break;
					case "L":
						switch (dir) {
						case "N":
							dir = "W";
							break;
						case "S":
							dir = "E";
							break;
						case "E":
							dir = "N";
							break;
						case "W":
							dir = "S";
							break;
						}
						break;
					case "R":
						switch (dir) {
						case "N":
							dir = "E";
							break;
						case "S":
							dir = "W";
							break;
						case "E":
							dir = "S";
							break;
						case "W":
							dir = "N";
							break;
						}
						break;
					}
				}
				for(int[] x : endings){
					if(x[0]==pos[0]&&x[1]==pos[1]){
						continue loop;
					}
				}
				endings.add(pos);
			}
		}
		System.out.println(endings.size());
	}

}