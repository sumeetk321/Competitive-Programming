package compumatics_set_1;

public class Prob9 {

	public static void main(String[] args) {
		for(int i = 0; i < 1000; i++){
			for(int j = 0; j < 1000; j++){
				for(int k = 0; k < 1000; k++){
					if(Math.pow(i, 2) + Math.pow(j, 2) == Math.pow(k, 2)&& (i+j+k==1000) && (i!=0 && j != 0 && k != 0)){
						System.out.println(i + ", " + j + ", " + k);
						System.out.println(i*j*k);
						System.exit(0);
					}
				}
			}
		}
	}

}
