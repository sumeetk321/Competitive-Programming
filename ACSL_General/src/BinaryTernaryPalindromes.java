import java.util.ArrayList;

public class BinaryTernaryPalindromes {

	public static void main(String[] args) {
		int numfound = 0;
		for(long i = 1; i < Long.MAX_VALUE; i+=2){
			if(numfound==5){
				
				System.exit(0);
			}
			String tmp1 = "";
			String a = toBinary(i);
			if(a.length()%2==0){
				continue;
			}
			String tmp2 = "";
			String b = toTernary(i);
			if(b.length()%2==0 || b.charAt((int) Math.floor(b.length()/2))=='0'){
				continue;
			}
			for(long a1 = a.length()-1; a1 >-1; a1--){
				tmp1+=a.charAt((int) a1)+"";
			}
			for(long b1 = b.length()-1; b1 >-1; b1--){
				tmp2+=b.charAt((int) b1)+"";
			}
			if(a.equals(tmp1) && b.equals(tmp2)){
				System.out.println(i+", "+a+", "+b);
			}
			
			
		}
		
	}
	
	public static String toTernary(long a){
		String x = Integer.toString((int) a, 3);
		return x;
	}
	
	public static String toBinary(long a){
		String x = Integer.toBinaryString((int) a);
		return x;
	}
	

}
