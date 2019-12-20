import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fields {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Fields.txt");
		Scanner scan = new Scanner(file);
		for (int i = 0; i < 2; i++) {
			int size = scan.nextLine().length();
			int[][] at = new int[size][size];
			int[][] exc = new int[size][size];
			String in1 = scan.nextLine();
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					at[j][k] = Character.getNumericValue(in1.charAt(size * j + k));
				}
			}
			String in2 = scan.nextLine();
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					exc[j][k] = Character.getNumericValue(in2.charAt(size * j + k));
				}
			}
			String[] vals = scan.nextLine().split(", ");
			int x = Integer.parseInt(vals[0]);
			int y = Integer.parseInt(vals[1]);
			int z = Integer.parseInt(vals[2]);
			String isField = "";
			if (!isCommutativeAt(in1, at)) {
				isField += "COMMUTATIVE FOR @, ";
			} else if (!isCommutativeExc(in2, exc)) {
				isField += "COMMUTATIVE FOR !, ";
			} else if (!isAssociativeAt(in1, at)) {
				isField += "ASSOCIATIVE FOR @, ";
			} else if (!isAssociativeExc(in2, exc)) {
				isField += "ASSOCIATIVE FOR !, ";
			}
			System.out.println(findat(x, y, at));
			System.out.println(findexc(x, z, exc));
			System.out.println(findat(y, findat(x, z, at), at));
			System.out.println(findexc(findexc(z, x, exc), y, exc));
			if (atidentity(size, at) == -1) {
				isField += "IDENTITY FOR @, ";
				System.out.println("NONE");
			} else {
				System.out.println(atidentity(size, at));
			}
			if (excidentity(size, exc) == -1) {
				isField += "IDENTITY FOR !, ";
				System.out.println("NONE");
			} else {
				System.out.println(excidentity(size, exc));
			}
			if (atinvidentity(size, x, at) == -1) {
				isField += "INVERSE FOR @, ";
				System.out.println("NONE");
			} else {
				System.out.println(atinvidentity(size, x, at));
			}
			if (excinvidentity(size, z, exc) == -1) {
				isField += "INVERSE FOR !, ";
				System.out.println("NONE");
			} else {
				System.out.println(excinvidentity(size, z, exc));
			}
			System.out.println(findexc(x, findat(y, z, at), exc));
			System.out.println(isField.length()==0?"YES":isField.trim().substring(0, isField.length()-2));
		}
	}

	public static int findat(int a, int b, int[][] at) {
		return at[a][b];
	}

	public static int findexc(int a, int b, int[][] exc) {
		return exc[a][b];
	}

	public static boolean isCommutativeAt(String at, int[][] at1) {
		for (int i = 0; i < at.length(); i++) {
			for (int j = 0; j < at.length(); j++) {
				int a = Character.getNumericValue(at.charAt(i));
				int b = Character.getNumericValue(at.charAt(j));
				if (findat(a, b, at1) == findat(b, a, at1)) {
					continue;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isCommutativeExc(String exc, int[][] exc1) {
		for (int i = 0; i < exc.length(); i++) {
			for (int j = 0; j < exc.length(); j++) {
				int a = Character.getNumericValue(exc.charAt(i));
				int b = Character.getNumericValue(exc.charAt(j));
				if (findat(a, b, exc1) == findat(b, a, exc1)) {
					continue;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isAssociativeAt(String at, int[][] at1) {
		for (int i = 0; i < at.length(); i++) {
			for (int j = 0; j < at.length(); j++) {
				for (int k = 0; k < at.length(); k++) {
					int a = Character.getNumericValue(at.charAt(i));
					int b = Character.getNumericValue(at.charAt(j));
					int c = Character.getNumericValue(at.charAt(k));
					if (findat(a, findat(b, c, at1), at1) == findat(findat(a, b, at1), c, at1)) {
						continue;
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static boolean isAssociativeExc(String exc, int[][] exc1) {
		for (int i = 0; i < exc.length(); i++) {
			for (int j = 0; j < exc.length(); j++) {
				for (int k = 0; k < exc.length(); k++) {
					int a = Character.getNumericValue(exc.charAt(i));
					int b = Character.getNumericValue(exc.charAt(j));
					int c = Character.getNumericValue(exc.charAt(k));
					if (findexc(a, findexc(b, c, exc1), exc1) == findexc(findexc(a, b, exc1), c, exc1)) {
						continue;
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static int atidentity(int size, int[][] at) {
		int test = 0;
		for (int i = 0; i < size; i++) {
			secondloop: for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					for (int l = 0; l < size; l++) {
						if (findat(at[i][j], at[k][l], at) == at[k][l]) {
							test++;
						} else {
							test = 0;
							continue secondloop;
						}
					}
					if (test == size * size) {
						return at[i][j];
					}
				}
			}
		}
		return -1;
	}

	public static int excidentity(int size, int[][] exc) {
		int test = 0;
		for (int i = 0; i < size; i++) {
			secondloop: for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					for (int l = 0; l < size; l++) {
						if (findexc(exc[i][j], exc[k][l], exc) == exc[k][l]) {
							test++;
						} else {
							test = 0;
							continue secondloop;
						}
					}
					if (test == size * size) {
						return exc[i][j];
					}
				}
			}
		}
		return -1;
	}

	public static int atinvidentity(int size, int num, int[][] at) {
		int id = atidentity(size, at);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (findat(at[i][j], num, at) == id) {
					return at[i][j];
				} else {
					continue;
				}
			}

		}

		return -1;
	}

	public static int excinvidentity(int size, int num, int[][] exc) {
		int id = excidentity(size, exc);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (findexc(exc[i][j], num, exc) == id) {
					return exc[i][j];
				} else {
					continue;
				}
			}

		}

		return -1;
	}
}
