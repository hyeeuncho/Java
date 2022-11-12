package table;

import java.util.Scanner;

public class Song {
	// 1 ºò¹ð ¹ð¹ð¹ð 2015
	int id;
	String name;
	String title;
	int year;
	String lyric="";
	Song() {		
	}
	public Song(Object[] row) {
		id = Integer.parseInt((String)row[0]);
		name = (String)row[1];
		title = (String)row[2];
		year = Integer.parseInt((String)row[3]);
	}
	void read(Scanner scan) {
		id = scan.nextInt();
		name = scan.next();
		title = scan.next();
		year = scan.nextInt();		
	}
	String[] getTexts() {
		return new String[] {""+id, name, title, ""+year, lyric};
	}
	void print() {
		System.out.printf("[%2d] %s %s (%d³â)\n",
				id, name, title, year);
	}
	boolean matches(String n) {
		if (Integer.toString(id).equals(n))
			return true;
		if (title.contains(n))
			return true;
		return name.equals(n);
		
	}
	@Override
	public String toString() {
		return String.format("%s(%s)", title, name);
	}
}