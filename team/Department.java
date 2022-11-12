package team;
import java.util.ArrayList;
import java.util.Scanner;

public class Department {
	Scanner scan = new Scanner(System.in);
	ArrayList<Student> studentList = new ArrayList<>();
	ArrayList<Team> teamList = new ArrayList<>();

	void run() {
		readAll();
		printAll();
		//inputScores();
		readAllTeams();
		printAllTeams();
		printAll();
		searchTeam();
	}

	void searchTeam() {
		String kwd = null;
		while (true) {
			System.out.print("ÆÀ °Ë»ö Å°¿öµå: ");
			kwd = scan.next();
			if (kwd.contentEquals("end"))
				break;
			for (Team t : teamList) {
				if (t.matches(kwd))
					t.print();
			}
		}
	}
	Student findStudent(int num) {
		// TODO Auto-generated method stub
		if (num <= 0 || studentList.size() < num)
			return null;
		return studentList.get(num-1);
	}

	private void printAllTeams() {
		// TODO Auto-generated method stub
		for (Team t : teamList)
			t.print();
	}

	private void readAllTeams() {
		// TODO Auto-generated method stub
		String token = null;
		Team t = null;
		while (true) {
			token = scan.next();
			if (token.equals("end"))
				break;
			t = new Team(token);
			t.read(scan, this);
			teamList.add(t);
		}
	}

	void inputScores() {
		System.out.println("ÇÐ»ý Á¡¼ö ÀÔ·Â");
		for (Student st : studentList) {
			st.inputScore(scan);
		}
	}

	void search() {
		String kwd = null;
		String line = null;
		String[] kwdArr = null;
		scan.nextLine();
		while (true) {
			System.out.print("°Ë»öÅ°¿öµå ¿©·¯°³(ºóÄ­À¸·Î ±¸ºÐ):");
			line = scan.nextLine();
			if (line.contentEquals("end"))
				break;
			kwdArr = line.split(" ");
			for (Student st : studentList) {
				if (st.matches(kwdArr))
					st.print();
			}
		}
	}

	void readAll() {
		Student st = null;
		int id = 0;
		while (true) {
			id = scan.nextInt();
			if (id == 0)
				break;
			st = new Student(id);
			st.read(scan);
			studentList.add(st);
		}
	}

	void printAll() {
		int i = 1;
		for (Student st : studentList) {
			System.out.printf("[%d] ", i++);
			st.print();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Department department = new Department();
		department.run();
	}

}
/*
201611012 ±è¼º°ü 010-9148-2689 2
201711311 ±èÀçÈÆ 010-5511-1034 2
201710140 ±è¿øÃ¶ 010-7757-1256 3
201910532 ±èÁØÃ¶ 010-3215-1337 3
201910533 ¹Ú¿ìÇö 010-4855-8560 3
201711312 ±èµ¿Çö 010-4856-8565 2
201710302 ¹ÚÅÂÁÖ 010-4856-8570 3
201910569 ¹Ú¼º¿¬ 010-9148-2519 2
201810343 ¼­¹Î¿ì 010-9124-2689 2
201910586 À±ÇöÁÖ 010-9111-2689 2
201411012 ÀÌ°¡¿µ 010-7722-1256 3
201711170 ÀÌ±â¿ø 010-7733-1256 2
201840148 ÀÌ»óÈÆ 010-7755-1256 2
201711018 ÀÌÁ¾Ã¶ 010-7788-1256 3
0
*/