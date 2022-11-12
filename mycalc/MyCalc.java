package mycalc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCalc extends JFrame {
	private static final long serialVersionUID = 1L;
	void run() {
		setTitle("내가 만든 계산 계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container myCon = getContentPane();
		myCon.setLayout(new BorderLayout(5, 5));
		myCon.setBackground(Color.LIGHT_GRAY);
		
		//입력 값과 결과값이 출력되는 위 패널 생성 후 콘테이너에 추가
		UpPanel up = new UpPanel();
		up.init();
		myCon.add(up, BorderLayout.EAST);
		//버튼을 넣을 아래 패널 생성 후 콘테이너에 추가
		DownPanel dp = new DownPanel();
		dp.init(up);
		myCon.add(dp, BorderLayout.SOUTH);
		
		setSize(350, 560);
		setVisible(true);
	}
	public static void main(String[] args) {
		MyCalc my = new MyCalc();
		my.run();
	}
}
