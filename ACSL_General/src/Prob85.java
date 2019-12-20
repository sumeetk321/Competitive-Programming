
public class Prob85 {

	public static void main(String[] args) {
		
		int[] val = {13, -4, 82, 17};
		int[] twice = {0, 0, 0, 0};
		
		System.out.println("Original Array: "
				+ val[0] + " " + val[1] + " " + val[2] + " " +val[3]);
		
		int j;
		for(j =0;j<val.length;j++){
			twice[j]=2*val[j];
		}
		System.out.println("New Array: "
				+ twice[0] + " " + twice[1] + " " + twice[2] + " " + twice[3]);
		
	}

}
