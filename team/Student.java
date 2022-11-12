package team;

import java.util.Random;
import java.util.Scanner;

public class Student {
	String name;
	int id;
	String phone;
	int year;
	int score;
	Team team;
	static Random rand = new Random();

	public Student(int id2) {
		id = id2;
	}

	void read(Scanner scan) {
		// id = scan.nextInt();
		name = scan.next();
		phone = scan.next();
		year = scan.nextInt();
	}

	void inputScore(Scanner scan) {
		// System.out.printf("%s: ", name);
		// score = scan.nextInt();
		score = rand.nextInt(100) + 1;
		System.out.printf("%s: %d점\n", name, score);

	}

	void print() { // Student
		System.out.format("%d %s %s (%d학년)", id, name, phone, year);
		if (score != 0)
			System.out.format(" %d점", score);
		System.out.println();
	}

	boolean matches(String kwd) {
		if (kwd.length() == 1 && Character.isDigit(kwd.charAt(0)))
			return kwd.contentEquals("" + year);
		return (kwd.contentEquals(name) || ("" + id).contains(kwd) || phone.contains(kwd));
	}

	boolean matches(String[] kwdArr) {
		for (String kwd : kwdArr) {
			if (kwd.charAt(0) == '-') {
				kwd = kwd.substring(1);
				if (matches(kwd))
					return false;
			}
			else if (!matches(kwd))
				return false;
		}
		return true;
	}

	void setTeam(Team team) {
		// TODO Auto-generated method stub
		this.team = team;
	}
}
