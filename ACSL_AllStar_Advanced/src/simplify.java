import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class simplify {
	static ArrayList<String> outputs1 = new ArrayList<String>(Arrays.asList("00", "01", "10", "11"));
	static ArrayList<String> simplified1 = new ArrayList<String>(Arrays.asList("0", "A", "~A", "1"));
	static ArrayList<String> outputs2 = new ArrayList<String>(Arrays.asList("0000", "0001", "0010", "0011", "0100",
			"0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"));
	static ArrayList<String> simplified2 = new ArrayList<String>(
			Arrays.asList("0", "A * B", "A * ~B", "A", "~A * B", "B", "~A * B + A * ~B", "A + B", "~A * ~B",
					"A * B + ~A * ~B", "~B", "A + ~B", "~A", "~A + B", "~A + ~B", "1"));

	public static void main(String[] args) throws IOException, ScriptException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			String in = br.readLine();
			in = in.replace("+", "||");
			in = in.replace("*", "&&");
			in = in.replace("~", "!");
			ScriptEngineManager mgr = new ScriptEngineManager();
			ScriptEngine eng = mgr.getEngineByName("js");
			if (in.contains("B")) {
				String output = "";
				for (int j = 0; j < 2; j++) {
					for (int k = 0; k < 2; k++) {
						String tmp = in;
						tmp = tmp.replace("A", j + "");
						tmp = tmp.replace("B", k + "");
						output += eng.eval(tmp);
					}
				}
				output = output.replace("true", "1");
				output = output.replace("false", "0");
				System.out.println(simplified2.get(outputs2.indexOf(output)));
			} else {
				String output = "";
				for (int j = 0; j < 2; j++) {
					String tmp = in;
					tmp = tmp.replace("A", j + "");
					output += eng.eval(tmp);
				}
				output = output.replace("true", "1");
				output = output.replace("false", "0");
				System.out.println(simplified1.get(outputs1.indexOf(output)));
			}

		}
	}

}
