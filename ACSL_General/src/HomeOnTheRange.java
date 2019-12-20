import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HomeOnTheRange {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("HomeOnTheRange.txt");
		Scanner scan = new Scanner(file);
		double constant = 0;
		double constant1 = 0;
		for (int a = 0; a < 2; a++) {
			if (a == 0)
				constant = 0.01;
			else
				constant = 0.1;
			if (a == 0)
				constant1 = 9.99;
			else
				constant1 = 9.9;
			double initial = Double.parseDouble(scan.nextLine());
			ArrayList<Tuple1> table = new ArrayList<Tuple1>();
			table.add(new Tuple1(0.0, constant1, initial));
			for (int i = 0; i < (a==0?3:5); i++) {
				String in = scan.nextLine();
				String[] vals = in.split(", ");
				double val1 = Double.parseDouble(vals[0]);
				double val2 = Double.parseDouble(vals[1]);
				double val3 = Double.parseDouble(vals[2]);
				Tuple1 ins = new Tuple1(val1, val2 - constant, val3);
				table.add(ins);
				Collections.sort(table, new Comparator<Tuple1>() {
					public int compare(Tuple1 o1, Tuple1 o2) {
						return Double.compare(o1.getVal1(), o2.getVal1());
					}
				});
				for(int b = 0; b < table.size(); b++){
					if(table.get(b).getVal1()<0||table.get(b).getVal2()<0) table.remove(b);
				}
				
				int index = table.indexOf(ins);
				if (index > 0) {
					if (table.get(index - 1).getVal2() == constant1) {
						table.get(index - 1).setVal2(
								(double) ((double) Math.round((table.get(index).getVal1() - constant) * 100) / 100));
					}
					if (table.get(index - 1).getVal1() == table.get(index).getVal1()) {
						if(table.get(index-1).getVal2() > table.get(index).getVal2()){
							double v1 = table.get(index).getVal3();
							double v2 = table.get(index-1).getVal3();
							table.get(index-1).setVal2(table.get(index-1).getVal2()+constant);
							table.get(index).setVal1(table.get(index).getVal2()+constant);
							table.get(index).setVal2(table.get(index-1).getVal2()-constant);
							table.get(index-1).setVal3(v1);
							table.get(index).setVal3(v2);
						}
					}
					if(table.get(index-1).getVal2()>table.get(index).getVal1() && table.get(index).getVal2()<table.get(index-1).getVal2() && table.get(index-1).getVal1()!=0.0){
						Tuple1 t = table.get(index-1);
						table.set(index-1, table.get(index));
						table.set(index, t);
					}
				}
				index = table.indexOf(ins);
				if (index < table.size() - 1) {
					if (table.get(index + 1).getVal1() < table.get(index).getVal2()) {
						table.get(index + 1).setVal1(
								(double) ((double) Math.round((table.get(index).getVal2() + constant) * 100) / 100));
					}
				}
				if (table.get(table.size() - 1).getVal2() != constant1) {
					table.add(new Tuple1(table.get(table.size() - 1).getVal2() + constant, constant1, initial));
				}
				if(table.get(table.size()-1).getVal1()==10){
					table.remove(table.size()-1);
				}
				for(int b = 0; b < table.size(); b++){
					if(table.get(b).getVal1()<0||table.get(b).getVal2()<0) table.remove(b);
				}
				for(int b = 0; b < table.size(); b++){
					table.get(b).setVal1((double)((double)Math.round(table.get(b).getVal1()*100)/100));
					table.get(b).setVal2((double)((double)Math.round(table.get(b).getVal2()*100)/100));
				}
				if(table.get(index-1).getVal2()<table.get(index).getVal1()-constant){
					table.add(index, new Tuple1((double)((double) Math.round((table.get(index-1).getVal2()+constant)*100)/100),(double)((double)Math.round((table.get(index).getVal1()-constant)*100)/100), initial));
				}
				for (Tuple1 x : table) {
					System.out.println(x.getVal1() + ", " + x.getVal2() + ", " + x.getVal3());
				}
				System.out.println();
				for(int b = 0; b < table.size(); b++){
					if(table.get(b).getVal1()<0||table.get(b).getVal2()<0) table.remove(b);
				}
				index = table.indexOf(ins);
				if (index > 0) {
					if(table.get(index-1).getVal2()>=table.get(index).getVal1()){
						table.get(index-1).setVal2(table.get(index).getVal1()-constant);
					}
					if (table.get(index - 1).getVal2() == constant1) {
						table.get(index - 1).setVal2(
								(double) ((double) Math.round((table.get(index).getVal1() - constant) * 100) / 100));
					}
					if (table.get(index - 1).getVal1() == table.get(index).getVal1()) {
						if(table.get(index-1).getVal2() > table.get(index).getVal2()){
							double v1 = table.get(index).getVal3();
							double v2 = table.get(index-1).getVal3();
							table.get(index-1).setVal2(table.get(index-1).getVal2()+constant);
							table.get(index).setVal1(table.get(index).getVal2()+constant);
							table.get(index).setVal2(table.get(index-1).getVal2()-constant);
							table.get(index-1).setVal3(v1);
							table.get(index).setVal3(v2);
						}
					}
				}
				if (index < table.size() - 1) {
					if (table.get(index + 1).getVal1() < table.get(index).getVal2()) {
						table.get(index + 1).setVal1(
								(double) ((double) Math.round((table.get(index).getVal2() + constant) * 100) / 100));
					}
				}
				if (table.get(table.size() - 1).getVal2() != constant1) {
					table.add(new Tuple1(table.get(table.size() - 1).getVal2() + constant, constant1, initial));
				}
				if(table.get(table.size()-1).getVal1()==10){
					table.remove(table.size()-1);
				}
			}
			System.out.println();
		}
	}

}

class Tuple1 {
	private double val1;
	private double val2;
	private double val3;

	public Tuple1(double val1, double val2, double val3) {
		this.val1 = val1;
		this.val2 = val2;
		this.val3 = val3;
	}

	public double getVal1() {
		return val1;
	}

	public double getVal2() {
		return val2;
	}

	public double getVal3() {
		return val3;
	}

	public void setVal1(double val) {
		val1 = val;
	}

	public void setVal2(double val) {
		val2 = val;
	}

	public void setVal3(double val) {
		val3 = val;
	}

}
