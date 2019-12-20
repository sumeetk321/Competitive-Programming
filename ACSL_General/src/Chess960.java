import java.util.ArrayList;
import java.util.Arrays;

public class Chess960 {

	public static void main(String[] args) {

		boolean notsolved = true;
		String[] rank1;
		while(notsolved){
			ArrayList<String> pieces = new ArrayList<String>(Arrays.asList("K", "Q", "R", "B", "N", "B", "R", "N"));
			rank1 = new String[8];
			for(int i = 0; i < 8; i++){
				int rand = (int) (Math.random()*pieces.size());
				rank1[i] = pieces.get(rand);
				pieces.remove(rand);
			}
			int Bind1 = 0, Bind2 = 0;
			int Rind1 = 0, Rind2 = 0;
			int Kind = 0;
			
			for(int i = 0; i < 8; i++){
				if(Bind1==0 && rank1[i].equals("B")){
					Bind1 = i;
				} else if (Bind2==0 && rank1[i].equals("B")){
					Bind2 = i;
				}
				if(Rind1==0 && rank1[i].equals("R")){
					Rind1 = i;
				} else if (Rind2==0 && rank1[i].equals("R")){
					Rind2 = i;
				}
				if(rank1[i].equals("K")){
					Kind = i;
				}
			}
			
			if(Rind1 < Kind && Kind < Rind2){
				if((Bind2-Bind1)%2==1){
					for(int j = 0; j < 8; j++){
						
						System.out.print(rank1[j]+" ");
					}
					notsolved = false;
				} else continue;
			} else continue;
			
		}
			
		
	}

}
