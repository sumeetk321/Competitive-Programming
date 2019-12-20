package ACSL_JuniorDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ACSL_Asterisks_JuniorDivision {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("ACSL_2002_2003_JuniorDivision.txt");
		Scanner scan = new Scanner(file);
		
		String[] lines = new String[5];
		int i = 0;
		while(scan.hasNextLine()){
			lines[i] = scan.nextLine();
			i++;
		}
		mainloop: for(int j = 0; j < lines.length; j++){
			if(lines[j].startsWith("S,")){
				String S = lines[j].substring(lines[j].indexOf(' '), lines[j].length()).trim();
				int SNum = Integer.parseInt(S);
				if(SNum > 22){
					System.out.println("Exceeds maximum size: " + lines[j]);
					continue mainloop;
				}
				System.out.println("\n" + lines[j] + ": \n");
				for(int k =0; k < SNum; k++){
					
					for(int l = 0; l < SNum; l++){
						System.out.print('*');
						
					}
					
					System.out.println("\n");
				}
				
			} else if(lines[j].startsWith("H,")){
				System.out.println(lines[j]);
				String H = lines[j].substring(lines[j].indexOf(' '), lines[j].length()).trim();
				int HNum = Integer.parseInt(H);
				int counter = HNum;
				if(HNum > 22){
					
					System.out.println("Exceeds maximum size: " + lines[j]);
					continue mainloop;
				}
				
				for(int l = 0; l < HNum; l++){
					for(int z = 0; z < HNum - counter; z++){
						System.out.print(' ');
					}
					for(int m =0; m < counter; m++){
						
						System.out.print('*');
						
					}
					System.out.println("\n");
					counter--;
				}
			} else if(lines[j].startsWith("L,")){
				System.out.println(lines[j]);
				String L = lines[j].substring(lines[j].indexOf(' '), lines[j].length()).trim();
				int LNum = Integer.parseInt(L);
				if(LNum > 22){
					System.out.println("Exceeds maximum size: " + lines[j]);
					continue mainloop;
				}
				int counter = 1;
				for(int n = 0; n < LNum; n++){
					for(int o = 0; o < counter; o++){
						System.out.print('*');
					}
					System.out.println("\n");
					counter++;
				}
			} else if(lines[j].startsWith("B,")){
				System.out.println(lines[j]);
				String B1 = lines[j].substring(2, 4).trim();
				String B2 = lines[j].substring(5, lines[j].length()).trim();
				int BLength = Integer.parseInt(B1);
				int BWidth = Integer.parseInt(B2);
				if(BLength >  22){
					System.out.println("Exceeds maximum length: " + lines[j]);
					continue mainloop;
				} else if(BWidth > 80){
					System.out.println("Exceeds maximum width: " + lines[j]);
					continue mainloop;
				} else {
					for(int p = 0; p < BWidth; p++){
						for(int q = 0; q < BLength; q++){
							System.out.print('*');
						}
						System.out.println("\n");
					}
				}
			}
		} 
			
	}

}
