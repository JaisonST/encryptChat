import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

	class first extends JFrame implements ActionListener{
		first(String str){
			super(str);
			getContentPane().setBackground(Color.red);
			setSize(800,600);
			
			JButton btn = new JButton("Click");
			btn.addActionListener(this);
			add(btn);

			setLayout(new FlowLayout());
		}
		public void actionPerformed(ActionEvent e){
			second s = new second("Second");
			s.setVisible(true);
			setVisible(false);	
		}
						
	}

	class second extends JFrame implements ActionListener{
		second(String str){
			super(str);
			getContentPane().setBackground(Color.blue);
			setSize(800,600);

			setLayout(new FlowLayout());

			JButton btn1 = new JButton("Back");
			btn1.addActionListener(this);	
			add(btn1);
		}
		
		public void actionPerformed(ActionEvent e){
			dispose();
			first f = new first("First");
			f.setVisible(true);
		}
	}

	public class MoveFrame{
		public static void main(String ar[]){
			first f = new first("First");
			f.setVisible(true);
		}
	}