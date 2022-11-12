package mycalc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class DownPanel extends JPanel{
	void init(UpPanel up) {
		JButton[] bt = new JButton[20];
		setLayout(new GridLayout(5, 4, 5, 4));
		setBackground(Color.DARK_GRAY);
		for (int i = 0; i < 10; i++) {  // 0 ~ 9, .
			bt[i] = new JButton(""+i);
			bt[i].setPreferredSize(new Dimension(0, 65));
			bt[i].setFont(new Font("맑은 고딕", 0, 20));
		}
		String ops[] = {".", "+", "-", "x", "÷", "="};
		for (int i = 10; i < 16; i++) {
			bt[i] = new JButton(ops[i-10]);
			bt[i].setPreferredSize(new Dimension(0, 65));
			bt[i].setFont(new Font("맑은 고딕", 0, 20));
			bt[i].setForeground(Color.BLUE);
		}
		int order[] = {1, 2, 3, 11,   // 그리드레이아웃에 추가되는 순서
				4, 5, 6, 12, 
				7, 8, 9, 13,
				10, 0, 14, 15};
		for (int i : order) {
			add(bt[i]);
			bt[i].setPreferredSize(new Dimension(0, 65));
		}
		for (int i = 0; i <= 10; i++) {
			bt[i].addActionListener(up.numHandler);
		};
		for (int i = 11; i < 16; i++) {  // +, -, *, /, =
			bt[i].addActionListener(up.opHandler);
		}
	}
}