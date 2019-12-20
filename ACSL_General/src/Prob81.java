import java.util.Random;
import java.util.Scanner;

public class Prob81 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		int j = 0;
		String consonants = "bcdfghjklmnpqrstvwxyz";
		String vowels = "aeiou";
		String punctuations = ".?!:;";
		String space = " ";
		int consonant = 0;
		int vowel = 0;
		int punctuation = 0;
		int spaces = 0;
		Random rand = new Random();
		char ch;
		while(j<input.length()){
			ch = input.charAt(j);
			switch(ch){
			case 'a':
				vowel++;
				break;
			case 'e':
				vowel++;
				break;
			case 'i':
				vowel++;
				break;
			case 'o':
				vowel++;
				break;
			case 'u':
				vowel++;
				break;
			case 'b':
				consonant++;
				break;
			case 'c':
				consonant++;
				break;
			case 'd':
				consonant++;
				break;
			case 'f':
				consonant++;
				break;
			case 'g':
				consonant++;
				break;
			case 'h':
				consonant++;
				break;
			case 'j':
				consonant++;
				break;
			case 'k':
				consonant++;
				break;
			case 'l':
				consonant++;
				break;
			case 'm':
				consonant++;
				break;
			case 'n':
				consonant++;
				break;
			case 'p':
				consonant++;
				break;
			case 'q':
				consonant++;
				break;
			case 'r':
				consonant++;
				break;
			case 's':
				consonant++;
				break;
			case 't':
				consonant++;
				break;
			case 'v':
				consonant++;
				break;
			case 'w':
				consonant++;
				break;
			case 'x':
				consonant++;
				break;
			case 'y':
				consonant++;
				break;
			case 'z':
				consonant++;
				break;
			case '.':
				punctuation++;
				break;
			case '?':
				punctuation++;
				break;
			case '!':
				punctuation++;
				break;
			case ':':
				punctuation++;
				break;
			}
			j++;
		}
		System.out.println("Consonants: " + consonant+"\nVowels: "+vowel+"\nPunctuations: "+punctuation+"\nSpaces: "+spaces);
		
	}
}