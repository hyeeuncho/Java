package mycalc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class UpPanel extends JPanel {
	JLabel line2;
	JLabel line1;
	JLabel op;
	void init() {
		setLayout(new BorderLayout());
		setBackground(Color.LIGHT_GRAY);
		line1 = new JLabel("0");
		op = new JLabel("");
		line2 = new JLabel("0");
		
		line1.setFont(new Font("맑은 고딕", 0, 40));
		//line1.setForeground(Color.BLACK);
		line1.setHorizontalAlignment(SwingConstants.RIGHT);
		op.setFont(new Font("맑은 고딕", 0, 40));
		op.setForeground(Color.WHITE);
		op.setHorizontalAlignment(SwingConstants.RIGHT);
		
		line2.setFont(new Font("맑은 고딕", Font.BOLD , 55));
		//line2.setForeground(Color.BLACK);
		line2.setHorizontalAlignment(SwingConstants.RIGHT);
		add(new JLabel("    "), BorderLayout.LINE_END);
		JPanel center = new JPanel(new GridLayout(3, 1));
		center.add(line1);
		center.add(op);
		center.add(line2);
		center.setBackground(Color.LIGHT_GRAY);
		add(center, BorderLayout.CENTER);
	}
	ActionListener numHandler = new ActionListener() {			
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(line2.getText() == "0") {
				line2.setText("");
			}
			String labeltext = line2.getText();
			String text = b.getText();
			String newtext = labeltext + text;
			line2.setText(newtext);
		}
	};
	ActionListener opHandler = new ActionListener() {			
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			String oldOp = op.getText();
			op.setText(b.getText());
			if (b.getText().equals("=")) 
				op.setText("");
			if (oldOp.equals("")) {
				line1.setText(line2.getText());
				line2.setText("0");
				return;
			}
			double result = eval(line1.getText(), oldOp, line2.getText());
			line1.setText(""+result);
			line2.setText("0");
		}
	};
	double eval(String lval, String op, String rval) {
		double val1 = Double.parseDouble(lval);
		double val2 = Double.parseDouble(rval);
		switch(op) {
		case "+":return val1 + val2;
		case "-":return val1 - val2;
		case "x":return val1 * val2;
		case "÷":return val1 / val2;
		default:break;
		}
		return 0;
	}
}
