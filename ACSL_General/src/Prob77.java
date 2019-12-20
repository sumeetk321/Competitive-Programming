import java.util.Scanner;

import java.util.Scanner;

public class Prob77 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String password;
		boolean acceptablepassword = false;
		System.out.println("Enter your password");
		while(acceptablepassword==false){
		
			password = scan.nextLine();
			if(password.length()>=7){
				if(password.toLowerCase().equals(password) || password.toUpperCase().equals(password)){
					System.out.println("Unacceptable password");
					continue;
					
				} else if(password.contains("0") || password.contains("1") || password.contains("2") || password.contains("3") || password.contains("4") || password.contains("5") || password.contains("6") || password.contains("7") || password.contains("8") || password.contains("9") || password.contains("10")){
					System.out.println("Acceptable password");
					acceptablepassword=true;
					continue;
				}
			} else {
				System.out.println("Unacceptable password");
				continue;
			}
		}
		
	}

}
