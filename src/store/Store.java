package store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mgr.Factory;
import mgr.Manageable;
import mgr.Manager;

public class Store {
	private static Store store = null;
	private Store() {}
	public static Store getInstance() {
		if (store == null)
			store = new Store();
		return store;
	}
	Scanner scan = new Scanner(System.in);
	static Manager userMgr = new Manager();
	static Manager itemMgr = new Manager();
	static Manager orderMgr = new Manager();
	public void run() {
		itemMgr.readAll("items.txt", new Factory() {
			public Manageable create() {
				return new Item();
			}
		});
		System.out.println("\n================= 판매 상품 리스트 =================");
		itemMgr.printAll();
		userMgr.readAll("users.txt", new Factory() {
			public Manageable create() {
				return new User();
			}
		});
		orderMgr.readAll("order.txt", new Factory() {
			public Manageable create() {
				return new Order();
			}
		});
		System.out.println("\n================= 전체 주문 리스트 =================");
		orderMgr.printAll();
		System.out.println("\n=============== 사용자별 주문 리스트 =================");
		userMgr.printAll();
	}
	static List<String> getStringList(Scanner scan, String end) {
		List<String> strList = new ArrayList<>();
		String tmp;
		while (true) {
			tmp = scan.next();
			if (tmp.contentEquals(end))
				break;
			strList.add(tmp);
		}
		return strList;
	}

	public static boolean isNumeric(String input) {
		try {
			Double.parseDouble(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	public static void main(String args[]) {
		Store store = new Store();
		store.run();
	}
}
