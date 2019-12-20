import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
ID: sumeetk1
LANG: JAVA
TASK: friday
*/
public class friday {

	public static void main(String[] args) throws IOException {
		int saturday = 0;
		int sunday = 0;
		int monday = 0;
		int tuesday = 0;
		int wednesday = 0;
		int thursday = 0;
		int friday = 0;
		int month = 1;
		int date = 1;
		int day = 1;
		/*
		 * 0: sunday 1: monday 2: tuesday 3: wednesday 4: thursday 5: friday 6:
		 * saturday
		 */

		
		 BufferedReader br = new BufferedReader(new FileReader("friday.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new
		 FileWriter("friday.out")));
		 

		int endyear = 1900 + (Integer.parseInt(br.readLine())) - 1;

		boolean isLeapYear = false;

		for (int i = 1900; i <= endyear; i++) {
			if (i % 100 == 0) {
				if (i % 400 == 0) {
					isLeapYear = true;
				} else {
					isLeapYear = false;
				}
			} else if (i % 4 == 0) {
				isLeapYear = true;
			} else {
				isLeapYear = false;
			}
			// january
			month = 1;
			for (int j = 1; j <= 31; j++) {
				date = j;
				if (date == 13) {
					switch (day) {
					case 1:
						sunday++;
						break;
					case 2:
						monday++;
						break;
					case 3:
						tuesday++;
						break;
					case 4:
						wednesday++;
						break;
					case 5:
						thursday++;
						break;
					case 6:
						friday++;
						break;
					case 7:
						saturday++;
						break;
					}


				}
				day++;
				if(day==8) day = 1;

			}

			if (isLeapYear) {
				for (int k = 1; k <= 29; k++) {
					date = k;
					if (date == 13) {
						switch (day) {
						case 1:
							sunday++;
							break;
						case 2:
							monday++;
							break;
						case 3:
							tuesday++;
							break;
						case 4:
							wednesday++;
							break;
						case 5:
							thursday++;
							break;
						case 6:
							friday++;
							break;
						case 7:
							saturday++;
							break;
						}

						
					}
					
					day++;
					if(day==8) day = 1;
				}
			} else {
				for (int l = 1; l <= 28; l++) {
					date = l;
					if (date == 13) {
						switch (day) {
						case 1:
							sunday++;
							break;
						case 2:
							monday++;
							break;
						case 3:
							tuesday++;
							break;
						case 4:
							wednesday++;
							break;
						case 5:
							thursday++;
							break;
						case 6:
							friday++;
							break;
						case 7:
							saturday++;
							break;
						}


					}
					
					day++;
					if(day==8) day = 1;
				}

			}
			
			for (int j = 1; j <= 31; j++) {
				date = j;
				if (date == 13) {
					switch (day) {
					case 1:
						sunday++;
						break;
					case 2:
						monday++;
						break;
					case 3:
						tuesday++;
						break;
					case 4:
						wednesday++;
						break;
					case 5:
						thursday++;
						break;
					case 6:
						friday++;
						break;
					case 7:
						saturday++;
						break;
					}

			
				}
				day++;
				if(day==8) day = 1;

			}
			
			for (int j = 1; j <= 30; j++) {
				date = j;
				if (date == 13) {
					switch (day) {
					case 1:
						sunday++;
						break;
					case 2:
						monday++;
						break;
					case 3:
						tuesday++;
						break;
					case 4:
						wednesday++;
						break;
					case 5:
						thursday++;
						break;
					case 6:
						friday++;
						break;
					case 7:
						saturday++;
						break;
					}

				
				}
				day++;
				if(day==8) day = 1;

			}
			
			for (int j = 1; j <= 31; j++) {
				date = j;
				if (date == 13) {
					switch (day) {
					case 1:
						sunday++;
						break;
					case 2:
						monday++;
						break;
					case 3:
						tuesday++;
						break;
					case 4:
						wednesday++;
						break;
					case 5:
						thursday++;
						break;
					case 6:
						friday++;
						break;
					case 7:
						saturday++;
						break;
					}

				
				}
				day++;
				if(day==8) day = 1;

			}
			
			for (int j = 1; j <= 30; j++) {
				date = j;
				if (date == 13) {
					switch (day) {
					case 1:
						sunday++;
						break;
					case 2:
						monday++;
						break;
					case 3:
						tuesday++;
						break;
					case 4:
						wednesday++;
						break;
					case 5:
						thursday++;
						break;
					case 6:
						friday++;
						break;
					case 7:
						saturday++;
						break;
					}

		
				}
				day++;
				if(day==8) day = 1;

			}
			for (int j = 1; j <= 31; j++) {
				date = j;
				if (date == 13) {
					switch (day) {
					case 1:
						sunday++;
						break;
					case 2:
						monday++;
						break;
					case 3:
						tuesday++;
						break;
					case 4:
						wednesday++;
						break;
					case 5:
						thursday++;
						break;
					case 6:
						friday++;
						break;
					case 7:
						saturday++;
						break;
					}

				}
				day++;
				if(day==8) day = 1;

			}
			for (int j = 1; j <= 31; j++) {
				date = j;
				if (date == 13) {
					switch (day) {
					case 1:
						sunday++;
						break;
					case 2:
						monday++;
						break;
					case 3:
						tuesday++;
						break;
					case 4:
						wednesday++;
						break;
					case 5:
						thursday++;
						break;
					case 6:
						friday++;
						break;
					case 7:
						saturday++;
						break;
					}

					
				}
				day++;
				if(day==8) day = 1;

			}
			for (int j = 1; j <= 30; j++) {
				date = j;
				if (date == 13) {
					switch (day) {
					case 1:
						sunday++;
						break;
					case 2:
						monday++;
						break;
					case 3:
						tuesday++;
						break;
					case 4:
						wednesday++;
						break;
					case 5:
						thursday++;
						break;
					case 6:
						friday++;
						break;
					case 7:
						saturday++;
						break;
					}

					
				}
				day++;
				if(day==8) day = 1;

			}
			for (int j = 1; j <= 31; j++) {
				date = j;
				if (date == 13) {
					switch (day) {
					case 1:
						sunday++;
						break;
					case 2:
						monday++;
						break;
					case 3:
						tuesday++;
						break;
					case 4:
						wednesday++;
						break;
					case 5:
						thursday++;
						break;
					case 6:
						friday++;
						break;
					case 7:
						saturday++;
						break;
					}

					
				}
				day++;
				if(day==8) day = 1;

			}
			for (int j = 1; j <= 30; j++) {
				date = j;
				if (date == 13) {
					switch (day) {
					case 1:
						sunday++;
						break;
					case 2:
						monday++;
						break;
					case 3:
						tuesday++;
						break;
					case 4:
						wednesday++;
						break;
					case 5:
						thursday++;
						break;
					case 6:
						friday++;
						break;
					case 7:
						saturday++;
						break;
					}

				}
				day++;
				if(day==8) day = 1;

			}
			for (int j = 1; j <= 31; j++) {
				date = j;
				if (date == 13) {
					switch (day) {
					case 1:
						sunday++;
						break;
					case 2:
						monday++;
						break;
					case 3:
						tuesday++;
						break;
					case 4:
						wednesday++;
						break;
					case 5:
						thursday++;
						break;
					case 6:
						friday++;
						break;
					case 7:
						saturday++;
						break;
					}

					
				}
				day++;
				if(day==8) day = 1;

			}
		}
		
		out.println(friday+" "+saturday+" " +sunday+" "+monday+" "+tuesday+" "+wednesday+" "+thursday);
		out.close();
	}
}
