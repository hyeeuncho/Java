package icecream;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
	String name;  // 주문번호
	ArrayList<IceCream> basket = new ArrayList<>();
	int total;
	
	public Order(String num) {
		// TODO Auto-generated constructor stub
		name = num;
	}

	void read(Scanner scan, Store store) {
		// TODO Auto-generated method stub
		int num = 0;
		IceCream ic = null;
		while (true) {
			num = scan.nextInt();
			if (num == 0) break;
			ic = store.getICAt(num);
			basket.add(ic);
			ic.sale++;
			total += ic.price;
		}
	}

	void print() {
		// TODO Auto-generated method stub
		System.out.format("%-5s [총 %4d원(%d개)]\t", name, total, basket.size());
		for (IceCream ic: basket) {
			System.out.format(" %s", ic.name);
		}
		System.out.println();
	}

	public boolean matches(String num) {
		// TODO Auto-generated method stub
		return name.equals(num);
	}
}