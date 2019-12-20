import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class PriceList {
	static ArrayList<String> months = new ArrayList<String>(
			Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));

	// CHANGE TMP
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		Scanner scan = new Scanner(new File("PriceList.txt"));
		for (int a = 0; a < 2; a++) {
			System.out.println("OUTPUT:");
			ArrayList<Tuple> dates = new ArrayList<Tuple>();
			double origprice = Double.parseDouble(scan.nextLine());
			dates.add(new Tuple(new SimpleDateFormat("dd-MMM-yy").parse("01-Jan-04"),
					new SimpleDateFormat("dd-MMM-yy").parse("30-Jun-04"), origprice));
			for (int i = 0; i < (a == 0 ? 3 : 10); i++) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
				String in = scan.nextLine();
				String[] split = in.split(", ");
				Date date1 = sdf.parse(split[0]);
				Date date2 = sdf.parse(split[1]);
				double price = Double.parseDouble(split[2]);
				dates = addTuple(new Tuple(date1, date2, price), dates, origprice);
				for (Tuple x : dates) {
					System.out
							.println(sdf.format(x.getDate1()) + ", " + sdf.format(x.getDate2()) + ", " + x.getPrice());
				}
				System.out.println("\n");
			}
		}
		System.out.println("\n");
	}

	public static ArrayList<Tuple> addTuple(Tuple tuple, ArrayList<Tuple> arr, double origprice) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
		Calendar c = Calendar.getInstance();
		ArrayList<Double> tmp = new ArrayList<Double>();
		for (Tuple x : arr) {
			tmp.add(x.getPrice());
		}
		arr.add(tuple);
		Collections.sort(arr);
		int i = arr.indexOf(tuple);

		for (int j = 0; j < arr.size() - 1; j++) {
			if (arr.get(j).getDate1().equals(arr.get(j + 1).getDate1())
					&& arr.get(j).getDate2().equals(arr.get(j + 1).getDate2())) {
				if (arr.get(j).getPrice() == origprice) {
					arr.remove(arr.get(j));
				} else if (arr.get(j + 1).getPrice() == origprice) {
					arr.remove(arr.get(j + 1));
				}
			}
		}
		if (!(arr.get(arr.size() - 1).getDate2().equals(new SimpleDateFormat("dd-MMM-yy").parse("30-Jun-04")))) {
			c.setTime(arr.get(arr.size() - 1).getDate2());
			c.add(Calendar.DATE, 1);
			arr.add(new Tuple(c.getTime(), new SimpleDateFormat("dd-MMM-yy").parse("30-Jun-04"), origprice));
			c.clear();
		}
		for (int j = 0; j < arr.size(); j++) {
			if (arr.get(j).getDate2().before(arr.get(j).getDate1())) {
				arr.remove(arr.get(j));
			}
		}
		tmp = new ArrayList<Double>();
		for (Tuple x : arr) {
			tmp.add(x.getPrice());
		}
		i = arr.indexOf(tuple);
		

		if (i != 0) {
			if (arr.get(i - 1).getDate2().after(arr.get(i).getDate1())) {
				c.setTime(arr.get(i).getDate1());
				c.add(Calendar.DATE, -1);
				arr.get(i - 1).setDate2(c.getTime());
				c.clear();
			}

			i = arr.indexOf(tuple);
			for (int j = 0; j < arr.size(); j++) {
				if (arr.get(j).getDate2().before(arr.get(j).getDate1())) {
				}
			}

			i = arr.indexOf(tuple);
			if (i != 0) {
				c.setTime(arr.get(i - 1).getDate2());

				c.add(Calendar.DATE, 1);
				if (!(arr.get(i).getDate1().equals(c.getTime()))) {
					Date cdat = c.getTime();
					// System.out.println(cdat.toString() + " I: " + i);
					Calendar c1 = Calendar.getInstance();
					c1.setTime(arr.get(i).getDate1());
					c1.add(Calendar.DATE, -1);
					arr.add(new Tuple(cdat, c1.getTime(), tmp.get(i - 1)));
					Collections.sort(arr);
					c1.clear();
				}
				c.clear();
			}
		}
		
		i = arr.indexOf(tuple);
		if (i < arr.size() - 1) {
			if (arr.get(i).getDate2().equals(arr.get(i + 1).getDate1())) {
				arr.get(i + 1).setDate1(addDate(arr.get(i).getDate2(), 1));
			}
			c.setTime(arr.get(i).getDate2());

			c.add(Calendar.DATE, 1);
			if (!(arr.get(i + 1).getDate1().equals(c.getTime()))) {
				Date cdat = c.getTime();
				Calendar c1 = Calendar.getInstance();
				c1.setTime(arr.get(i + 1).getDate1());
				c1.add(Calendar.DATE, -1);
				arr.add(new Tuple(cdat, c1.getTime(), tmp.get(i-1)));
				Collections.sort(arr);
				c1.clear();
			}
			c.clear();
		}
		if (i != 0) {
			if (arr.get(i - 1).getDate2().after(arr.get(i).getDate1())) {
				// System.out.println("in ehre");
				c.setTime(arr.get(i).getDate1());
				c.add(Calendar.DATE, -1);
				arr.get(i - 1).setDate2(c.getTime());
				c.clear();
			}
			/*
			 * tmp = new ArrayList<Double>(); for (Tuple x : arr) {
			 * tmp.add(x.getPrice()); }
			 */
			i = arr.indexOf(tuple);
			for (int j = 0; j < arr.size(); j++) {
				if (arr.get(j).getDate2().before(arr.get(j).getDate1())) {
					arr.remove(j);
				}
			}
			/*
			 * tmp = new ArrayList<Double>(); for (Tuple x : arr) {
			 * tmp.add(x.getPrice()); }
			 */
			i = arr.indexOf(tuple);
			if (i != 0) {
				c.setTime(arr.get(i - 1).getDate2());

				c.add(Calendar.DATE, 1);
				if (!(arr.get(i).getDate1().equals(c.getTime()))) {
					Date cdat = c.getTime();
					// System.out.println(cdat.toString() + " I: " + i);
					Calendar c1 = Calendar.getInstance();
					c1.setTime(arr.get(i).getDate1());
					c1.add(Calendar.DATE, -1);
					arr.add(new Tuple(cdat, c1.getTime(), tmp.get(i)));
					Collections.sort(arr);
					c1.clear();
				}
				c.clear();
			}
		}
		for (int j = 0; j < arr.size(); j++) {
			if (arr.get(j).getDate2().before(arr.get(j).getDate1())) {
				arr.remove(arr.get(j));
			}
		}
		i = arr.indexOf(tuple);

		boolean notdone = true;
		int skips = 0;
		while (notdone) {
			boolean tmp1 = false;
			for (int j = 0; j < arr.size() - 1; j++) {
				if (arr.get(j).getDate2().after(arr.get(j + 1).getDate1())) {
					tmp1 = true;
					arr.remove(j + 1);
					skips++;
				}

			}
			i = arr.indexOf(tuple);

			if (!tmp1) {

				notdone = false;
			} else
				continue;
		}
		/*
		 * tmp = new ArrayList<Double>(); for (Tuple x : arr) {
		 * tmp.add(x.getPrice()); }
		 */
		i = arr.indexOf(tuple);
		if (skips > 0) {
			if (i < arr.size() - 1) {
				if (arr.get(i).getDate2().equals(arr.get(i + 1).getDate1())) {
					arr.get(i + 1).setDate1(addDate(arr.get(i).getDate2(), 1));
				}
				c.setTime(arr.get(i).getDate2());

				c.add(Calendar.DATE, 1);
				if (!(arr.get(i + 1).getDate1().equals(c.getTime()))) {
					Date cdat = c.getTime();
					// System.out.println(cdat.toString() + " I: " + i);
					Calendar c1 = Calendar.getInstance();
					c1.setTime(arr.get(i + 1).getDate1());
					c1.add(Calendar.DATE, -1);
					arr.add(new Tuple(cdat, c1.getTime(), tmp.get(i + skips)));
					Collections.sort(arr);
					c1.clear();
				}
				c.clear();
			}
		}
		arr.get(arr.size() - 1).setPrice(tmp.get(tmp.size() - 1));
		return arr;

	}

	public static Date addDate(Date d, int x) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DATE, x);
		return c.getTime();
	}

}

class Tuple implements Comparable<Tuple> {
	private Date date1;
	private Date date2;
	private double price;

	public Tuple(Date date1, Date date2, double price) {
		this.date1 = date1;
		this.date2 = date2;
		this.price = price;
	}

	public Date getDate1() {
		return date1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate1(Date date) {
		date1 = date;
	}

	public void setDate2(Date date) {
		date2 = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double pricein) {
		price = pricein;
	}

	public int compareTo(Tuple arg0) {
		return getDate1().compareTo(arg0.getDate1());
	}

}
