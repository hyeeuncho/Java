package table;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class SongMgr {
	public static void main(String[] args) {
		SongMgr a = new SongMgr();
		a.mymain();
	}
	Scanner scan = new Scanner(System.in);
	static ArrayList<Song> songs = new ArrayList<>();
	void mymain() {
		readAll("songs.txt");
		//songs.stream().forEach(Song::print);
	}
	Scanner openFile(String fileName) {
		Scanner fileIn = null;
		File f = new File(fileName);
		try {
			fileIn = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return fileIn;
	}

	protected void readAll(String fileName) {
		Scanner fileIn = openFile(fileName);
		Song m = null;
		fileIn.nextLine();
		while (fileIn.hasNext()) {
			m = new Song();
			m.read(fileIn);
			songs.add(m);
		}
		fileIn.close();
	}
	void addSong(Song s) {
		songs.add(s);
	}
	void removeAt(int index) {
		Song s = songs.get(index);
		songs.remove(s);
		System.out.println(s + " ªË¡¶");
	}
	Song findSong(int n) {
		for (Song s : songs)
			if (s.matches(Integer.toString(n)))
				return s;
		return null;
	}
}
