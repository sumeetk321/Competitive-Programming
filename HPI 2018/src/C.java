import java.io.*;

public class C {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String one = br.readLine();
		String two = br.readLine();
		String output = "";
	
		int count = 0;
		
		while(true){
			if(one.length()<=count && two.length()<=count) break;
			if(one.length()>count) output = output + one.charAt(count);
			if(two.length()>count) output = output + two.charAt(count);
			count++;
		}
		
		String temp = "";
		
		for(int i=output.length()-1; i>=0; i--){
			temp = temp + output.charAt(i);
		}
		
		System.out.println(temp);
		
	}

}
