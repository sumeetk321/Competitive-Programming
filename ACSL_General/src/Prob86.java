
public class Prob86 {

	public static void main(String[] args) {

		int[] valA = {13, -22, 82, 17};
		int[] valB = {-12, 24, -79, -13};
		int[] sum = {0, 0, 0, 0};
		int j = 0;
		while(j<valA.length){
			sum[j] = valA[j]+valB[j];
			j++;
		}
		
		System.out.println("sum: "
				+ sum[0] + " " + sum[1] + " " + sum[2] + " " + sum[3]);
		
	}

}
