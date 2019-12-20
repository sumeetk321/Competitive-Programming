
public class Prob92 {

	public static void main(String[] args) {
		
		int[] val = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
		int temp;
		
		for(int j = 0; j < val.length / 2; j++)
		{
		    temp = val[j];
		    val[j] = val[val.length - j - 1];
		    val[val.length - j - 1] = temp;
		}
		
		
		for(int i = 0; i <val.length;i++){
			System.out.print(val[i] + " ");
		}
	}

}
