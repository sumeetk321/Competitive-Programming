
public class Prob57 {

	public static void main(String[] args) {
		double effectiveness = 100;
		int months = 0;
		while(true){
			System.out.println("month: " + months + "\teffectiveness: " + effectiveness);
			effectiveness = effectiveness - (0.04*effectiveness);
			months++;
			if(effectiveness < 50)
				System.exit(0);
		}
	}

}
