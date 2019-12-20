import java.util.Random;

public class Prob70 {

	public static void main(String[] args) {
		Random rand = new Random();
		int cpuscore = 0;
		int playerscore = 0;
		
		while(true){
			for(int i = 0; i < 3; i++){
				cpuscore = cpuscore + rand.nextInt(6);
			}
		
			while(rand.nextInt(6) != 1){
				int dice = rand.nextInt(6);
				if(dice==1){
					playerscore = playerscore + 0;
				} else playerscore = playerscore + dice;
			}
			
			if(playerscore >= 100){
				System.out.println("Player wins!");
				System.exit(0);
			} else if (cpuscore >= 100){
				System.out.println("Computer wins!");
				System.exit(0);
			}
		}
	}
}
