
public class matholympiad5 {

	public static void main(String[] args) {

		int numbers = 0;

		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				for (int k = 1; k <= 9; k++) {
					for (int l = 1; l <= 9; l++) {
						if(i==j || i==k || i==l || j==k || j==l || k==l){
							continue;
						}
						
						if(i+j+k+l==14){
							numbers++;
							System.out.println(i+""+j+""+k+""+l);
							continue;
						}
					}
				}
			}

		}
		
		System.out.println(numbers);

	}
}
