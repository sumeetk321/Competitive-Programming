import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class BooleanExtended {
	static String ops = "!#$&%";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("BooleanExtended.txt"));
		for(int i = 0; i < 15; i++){
			int trues = 0;
			String exp = br.readLine();
			if(exp.contains("D")){
				for(int j = 0; j < 16; j++){
					String tmp = exp+"";
					String bin = Integer.toBinaryString(j);
					int len = bin.length();
					for(int k = 0; k < 4 - len; k++){
						bin = "0"+bin;
					}
					tmp = tmp.replace("A", bin.charAt(0)+"");
					tmp = tmp.replace("B", bin.charAt(1)+"");
					tmp = tmp.replace("C", bin.charAt(2)+"");
					tmp = tmp.replace("D", bin.charAt(3)+"");
					if(eval(tmp)==1){
						trues++;
					}
				}
			} else {
				for(int j = 0; j < 8; j++){
					String tmp = exp+"";
					String bin = Integer.toBinaryString(j);
					int len = bin.length();
					for(int k = 0; k < 3 - len; k++){
						bin = "0"+bin;
					}
					tmp = tmp.replace("A", bin.charAt(0)+"");
					tmp = tmp.replace("B", bin.charAt(1)+"");
					tmp = tmp.replace("C", bin.charAt(2)+"");
					if(eval(tmp)==1){
						trues++;
					}
				}
			}
			System.out.println(trues);
		}
	}
	public static int eval(String exp){
		Stack<Integer> values = new Stack<Integer>();
		for(int i = 0; i < exp.length(); i++){
			if(!ops.contains(exp.charAt(i)+"")){
				values.push(Character.getNumericValue(exp.charAt(i)));
			} else {
				int sum = 0;
				switch(exp.charAt(i)){
				case '!':
					for(int j = 0; j < 2; j++){
						sum+=values.pop();
					}
					values.push(sum%2==0?1:0);
					break;
				case '#':
					for(int j = 0; j < 3; j++){
						sum+=values.pop();
					}
					values.push(sum>=2?1:0);
					break;
				case '$':
					for(int j = 0; j < 3; j++){
						sum+=values.pop();
					}
					values.push(sum<=1?1:0);
					break;
				case '&':
					for(int j = 0; j < 3; j++){
						sum+=values.pop();
					}
					values.push(sum%2==1?1:0);
					break;
				case '%':
					for(int j = 0; j < 4; j++){
						sum+=values.pop();
					}
					values.push(sum%2==1?1:0);
					break;
				}
			}
		}
		return values.pop();
	}
}
