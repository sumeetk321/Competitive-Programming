
public class Prob88 {

	public static void main(String[] args) {
		
		int[] val = {0, 1, 2, 3};
		int temp;
		
		System.out.println("Original Array: "
				+ val[0] + " " + val[1] + " " + val[2] + " " + val[3]);
		
		for(int j = 0; j < val.length / 2; j++)
		{
		    temp = val[j];
		    val[j] = val[val.length - j - 1];
		    val[val.length - j - 1] = temp;
		}
		
		
		System.out.println("Reversed Array: "
				+ val[0] + " " + val[1] + " " + val[2] + " " + val[3]);
	}

}
