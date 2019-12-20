
public class Prob93 {

	public static void main(String[] args) {

		int[] signal = {5, 5, 4, 5, 6, 6, 7, 6, 5, 4, 1, 4};
		int[] smooth = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		smooth[0] = (signal[0] + signal[1])/2;
		smooth[signal.length - 1] = (signal[1] + signal[11])/2;
		for(int j = 1; j < signal.length - 1;j++){
			smooth[j] = (signal[j-1] + signal[j] + signal[j+1])/3;
		}
		
		for(int i = 0; i < signal.length;i++){
			System.out.print(signal[i] + " ");
		}
		System.out.println("\n");
		for(int i = 0; i < signal.length;i++){
			System.out.print(smooth[i] + " ");
		}
	}

}
