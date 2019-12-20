
public class Prob92_1 {

	public static void main(String[] args) {

		int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
		int[] result = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int temp = 0;			
		for(int j = 0; j < data.length / 2; j++){
			    temp = data[j];
			    data[j] = data[data.length - j - 1];
			    data[data.length - j - 1] = temp;
		}
		
		for(int j = 0;j < data.length;j++){
			result[j] = data[j];
		}
		
		for(int j = 0;j<data.length;j++){
			System.out.print(result[j] + " ");
			
		}
		
	}

}
