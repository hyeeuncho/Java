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
			System.out.print("팀 검색 키워드: ");
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
		System.out.println("학생 점수 입력");
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
			System.out.print("검색키워드 여러개(빈칸으로 구분):");
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
201611012 김성관 010-9148-2689 2
201711311 김재훈 010-5511-1034 2
201710140 김원철 010-7757-1256 3
201910532 김준철 010-3215-1337 3
201910533 박우현 010-4855-8560 3
201711312 김동현 010-4856-8565 2
201710302 박태주 010-4856-8570 3
201910569 박성연 010-9148-2519 2
201810343 서민우 010-9124-2689 2
201910586 윤현주 010-9111-2689 2
201411012 이가영 010-7722-1256 3
201711170 이기원 010-7733-1256 2
201840148 이상훈 010-7755-1256 2
201711018 이종철 010-7788-1256 3
0
*/