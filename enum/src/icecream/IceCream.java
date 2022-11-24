package icecream;

import java.util.Scanner;

public class IceCream {
	ICType type;
	String name;
	int price;
	int sale;
	
	public IceCream(String type) {
		// TODO Auto-generated constructor stub
		this.type = ICType.valueOf(type);
	}

	public void read(Scanner scan) {
		// TODO Auto-generated method stub
		//type = scan.next();
		name = scan.next();
		price = scan.nextInt();		
	}

	public void print() {
		// TODO Auto-generated method stub
		if (sale == 0)
			System.out.printf(" %s(%s) %d원\n", name, type, price);
		else
			System.out.printf(" %s(%s) %d원 [%d개 판매]\n", name, type, price, sale);
	}

	public boolean matches(String kwd) {
		// TODO Auto-generated method stub
		return (type.equals(kwd) ||
				name.contains(kwd) ||
				("" + price).equals(kwd));
	}

}
