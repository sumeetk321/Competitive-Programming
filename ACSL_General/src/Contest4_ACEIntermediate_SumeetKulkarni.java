//Author: Sumeet Kulkarni
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Contest4_ACEIntermediate_SumeetKulkarni {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("c_4_duplicates_int_test.txt"));
		ArrayList<ArrayList<String>> lettersarr = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> lettershistory = new ArrayList<ArrayList<String>>();
		String command;
		while ((command = br.readLine()) != null) {
			String[] arr = command.split(" ");
			switch (arr[0]) {
			case "RESET":
				String reset = "";
				for(int i = 1; i < arr.length; i++){
					reset+=arr[i];
				}
				reset = reset.replaceAll("[^a-zA-Z]", "").toUpperCase();
				lettersarr.clear();
				lettershistory.clear();
				add(lettersarr, lettershistory, reset);
				break;
			case "ADD":
				String add = "";
				for(int i = 1; i < arr.length; i++){
					add+=arr[i];
				}
				add = add.replaceAll("[^a-zA-Z]", "").toUpperCase();
				add(lettersarr, lettershistory, add);
				break;
			case "DELETE":
				String del = "";
				for(int i = 1; i < arr.length; i++){
					del+=arr[i];
				}
				del = del.replaceAll("[^a-zA-Z]", "").toUpperCase();
				delete(lettersarr, lettershistory, del);
				break;
			case "REPORT":
				int indexnum = Integer.parseInt(arr[1])-1;
				ArrayList<String> collectedstrs = new ArrayList<String>();
				for(ArrayList<String> x : lettershistory){
					if(x.size()<=indexnum){
						continue;
					} else {
						if(collectedstrs.size()==0||!collectedstrs.get(collectedstrs.size()-1).equals(x.get(indexnum))){
							collectedstrs.add(x.get(indexnum));
						}
					}
				}
				for(String y : collectedstrs){
					System.out.print(y);
				}
				System.out.println();
				break;
			}
		}
	}

	public static void add(ArrayList<ArrayList<String>> lettersarr, ArrayList<ArrayList<String>> lettershistory,
			String add) {
		ArrayList<String> basearray;
		if(lettersarr.size()==0){
			basearray = new ArrayList<String>();
		} else {
			basearray = new ArrayList<String>(lettersarr.get(lettersarr.size()-1));
		}
		for (int i = 0; i < add.length(); i++) {
			
			lettersarr.add(new ArrayList<String>(basearray));
			lettershistory.add(new ArrayList<String>());
			for (int j = 0; j <= i; j++) {
				lettersarr.get(lettersarr.size() - 1).add(add.charAt(j) + "");
			}
			Collections.sort(lettersarr.get(lettersarr.size() - 1));
			for (String x : lettersarr.get(lettersarr.size() - 1)) {
				if (!lettershistory.get(lettershistory.size() - 1).contains(x)) {
					lettershistory.get(lettershistory.size() - 1).add(x);
				}
			}
			Collections.sort(lettershistory.get(lettershistory.size() - 1));
		}

	}

	public static void delete(ArrayList<ArrayList<String>> lettersarr, ArrayList<ArrayList<String>> lettershistory,
			String del) {
		ArrayList<String> basearray;
		if(lettersarr.size()==0){
			basearray = new ArrayList<String>();
		} else {
			basearray = new ArrayList<String>(lettersarr.get(lettersarr.size()-1));
		}
		for (int i = 0; i < del.length(); i++) {
			
			lettersarr.add(new ArrayList<String>(basearray));
			lettershistory.add(new ArrayList<String>());
			for (int j = 0; j <= i; j++) {
				lettersarr.get(lettersarr.size() - 1).remove(del.charAt(j) + "");
			}
			Collections.sort(lettersarr.get(lettersarr.size() - 1));
			for (String x : lettersarr.get(lettersarr.size() - 1)) {
				if (!lettershistory.get(lettershistory.size() - 1).contains(x)) {
					lettershistory.get(lettershistory.size() - 1).add(x);
				}
			}
			Collections.sort(lettershistory.get(lettershistory.size() - 1));
		}	}
}
