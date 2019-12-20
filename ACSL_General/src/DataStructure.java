import java.util.ArrayList;
import java.util.Arrays;

public class DataStructure {
	protected ArrayList<String> ds = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E"));

	void psh(String x) {
		ds.add(x);
	}

	void dup(int x) {
		for (int i = 0; i < x; i++) {
			this.psh(ds.get(i));
		}
	}

	void swp(int x) {
		ArrayList<String> tmp = new ArrayList<String>();
		for (int i = 0; i < x; i++) {
			tmp.add(ds.get(i));
		}
		for (int i = 0; i < x; i++) {
			ds.remove(0);
		}
		for (int i = 0; i < x; i++) {
			ds.add(0, ds.get(ds.size() - 1));
			ds.remove(ds.size() - 1);
		}
		ds.addAll(tmp);
	}

	void pin(String x) {
		ds.add(0, x);
	}

}
