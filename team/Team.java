package team;

import java.util.ArrayList;
import java.util.Scanner;

public class Team {
	String name;
	ArrayList<Student> tList = new ArrayList<>();
	Team(String name) {
		this.name = name;		
	}
	void read(Scanner scan, Department dept) {
		int num = 0;
		Student st = null;
		while (true) {
			num = scan.nextInt();
			if (num == 0)
				break;
			st = dept.findStudent(num);
			tList.add(st);
			st.setTeam(this);
		}
	}
	void print() {
		System.out.print(name + " : ");
		for (Student st : tList) {
			System.out.print(st.name);
			if (tList.indexOf(st) == tList.size()-1)
				System.out.println();
			else 
				System.out.print(", ");
		}
	}
	boolean matches(String kwd) {
		// TODO Auto-generated method stub
		if (name.contentEquals(kwd))
			return true;
		for (Student st : tList)
			if (st.matches(kwd))
				return true;
		return false;
	}
}








