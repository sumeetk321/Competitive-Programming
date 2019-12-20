import java.util.ArrayList;

public class FlattenaList {

	public static void main(String[] args) {

		String list = "[[1], 2, [[3, 4,], 5890], [[[]]], [[[6]]], 7, 8, [98]]";
		String[] yee = list.split(", ");
		ArrayList<String> out = new ArrayList<String>();
		String tmp = list;
		boolean bool = false;
		while (!bool) {
			tmp = tmp.replace(", ", " ");
			tmp = tmp.replace("[", "");
			tmp = tmp.replace("]", "");
			if (tmp.contains("[") || tmp.contains("]") || tmp.contains(", ")) {
				continue;
			} else {
				bool = true;
			}
		}
		yee = tmp.split(" ");
		for (int i = 0; i < yee.length; i++) {
			out.add(yee[i]);
		}
		ArrayList<Integer> indices = new ArrayList<Integer>();
		for(int i = 0; i < out.size(); i++){
			if(out.get(i).length()==0){
				indices.add(i);
			}
		}
		for(int x : indices){
			out.remove(x);
		}
		for(String x : out){
			System.out.print(x+", ");
		}

	}

}
