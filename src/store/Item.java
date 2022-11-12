package store;

import java.util.Scanner;

import facade.UIData;
import mgr.Manageable;

public class Item implements Manageable, UIData {
	String itemName;
	String code;
	int price;
	public void read(Scanner scan) {  // Item
		code = scan.next();
		itemName = scan.next();
		price = scan.nextInt();  // 1%
	}
	public boolean matches(String kwd) {
		if (itemName.contains(kwd))  // ""일 때 true
		    return true;
		if (kwd.length() > 2 && code.contains(kwd))
		    return true;
		return false;
    }
	public boolean matches(String[] kwdArr) {
		for (String kwd: kwdArr) {
			if (!matches(kwd))
				return false;
		}
		return true;
	}
	public void print() { // Item
		System.out.format("[%s] %s (%d원) ", 
				code, itemName, price);
		System.out.println();
	}
	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
	}
	@Override
	public String[] getUiTexts() {
		// TODO Auto-generated method stub
		String[] texts = new String[5];
		texts[0] = code;
		texts[1] = itemName;
		texts[2] = ""+price;
		return texts;
	}
}