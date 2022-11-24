package icecream;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {
	Scanner scan = new Scanner(System.in);
	ArrayList<IceCream> icList = new ArrayList<>();
	ArrayList<Order> odList = new ArrayList<>();

	void run() {
		readAllICs();
		printAllICs();
		readAllOrders();
		printAllOrders();
		printICSales();
		search();
	}
	
	private void readAllICs() {
		// TODO Auto-generated method stub
		IceCream ic = null;
		String ty = null;
		while (true) {
			ty = scan.next();
			if (ty.equals("0")) break;
			ic = new IceCream(ty);
			ic.read(scan); 
			icList.add(ic);
		}		
	}

	private void readAllOrders() {
		// TODO Auto-generated method stub
		Order od = null;
		String num = null;
		while (true) {
			System.out.print("주문 입력: ");
			num = scan.next();
			if (num.equals("0")) break;
			od = findOrder(num);
			// 이미 있는 주문 번호면 추가함
			if (od != null) {
				od.read(scan, this);
				continue;
			}
			// 없는 주문 번호면 새로 생성
			od = new Order(num);
			od.read(scan, this); 
			odList.add(od);
		}				
	}
	
	private Order findOrder(String num) {
		// TODO Auto-generated method stub
		for (Order od : odList) {
			if (od.matches(num))
				return od;
		}	
		return null;
	}

	void printAllICs() {
		System.out.println("\n======== 아이스크림 메뉴 =========");
		int index = 1;
		for (IceCream ic : icList) {
			System.out.printf("[%d]", index++);
			ic.print();
		}
	}
	void printICSales() {
		System.out.println("\n======== 아이스크림 판매 결과 =========");
		int index = 0;
		for (IceCream ic : icList) {
			index++;
			if (ic.sale == 0) continue;
			System.out.printf("[%d]", index);
			ic.print();
		}
	}

	private void printAllOrders() {
		// TODO Auto-generated method stub
		System.out.println("\n======== 주문 내역 =========");
		for (Order od : odList) {
			od.print();
		}		
	}

	void search() {
		String kwd = null;
		while (true) {
			System.out.print("키워드: ");
			kwd = scan.next();
			if (kwd.equals("end"))
				break;
			for (IceCream ic: icList) {
				if (ic.matches(kwd))
					ic.print();
			}
		}
	}

	public static void main(String args[]) {
		Store store = new Store();
		store.run();
	}

	// num 번째 아이스크림 돌려줌 - 1~size 번 사이
	public IceCream getICAt(int num) {
		// TODO Auto-generated method stub
		if (num <= 0 || num > icList.size())
			return null;
		return icList.get(num - 1);
	}
}
