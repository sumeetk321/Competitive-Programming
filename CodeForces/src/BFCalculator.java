import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class BFCalculator {

	public static void main(String[] args) throws IOException, ScriptException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		String str = br.readLine();
		long startTime = System.currentTimeMillis();
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("js");
		String ans = ((int) engine.eval(str))+"";
		String program = "";
		for(int i = 0; i< ans.length(); i++){
			for(int j = 0; j < Character.getNumericValue(ans.charAt(i))+48; j++){
				program+="+";
			}
			program+=".>";
		}
		out.println(program);
		out.close();
		br.close();
	}
}
