import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Prob82 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Prob82.txt");
		Scanner scan = new Scanner(file);
		int j = 0;
		String consonants = "bcdfghjklmnpqrstvwxyz";
		String vowels = "aeiou";
		String punctuations = ".?!:;";
		String space = " ";
		int consonant = 0;
		int vowel = 0;
		int punctuation = 0;
		int spaces = 0;
		
		while(scan.hasNextLine()){
			String input = scan.nextLine();
			if(consonants.indexOf(input.charAt(j)) >=0){
				consonant++;
			} else if(vowels.indexOf(input.charAt(j)) >=0){
				vowel++;
			} else if(punctuations.indexOf(input.charAt(j)) >=0){
				punctuation++;
			} else if(space.charAt(0)==input.charAt(j)){
				spaces++;
			}
			j++;
			System.out.println("Consonants: " + consonant+"\nVowels: "+vowel+"\nPunctuations: "+punctuation+"\nSpaces: "+spaces);
		}
		
		
	}
}