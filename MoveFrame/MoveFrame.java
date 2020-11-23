import java.awt.*; 
import javax.swing.*; 

class Frame1 extends JFrame{
	Frame1(String a){
		setTitle(a);
		setSize(1000,600); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.pink);
		setLayout(new FlowLayout());
		JButton b = new JButton("click me");
		add(b); 
		setVisible(true);
	} 
} 

class Frame2 extends JFrame{
	Frame2(String a){
		setTitle(a);
		setSize(1000,600); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.blue); 
		setLayout(new FlowLayout());
		JButton b = new JButton("click me");
		add(b); 
		setVisible(true);
	} 
} 

public class MoveFrame{
	
	public static void main(String ar[]){
		Frame1 f1 = new Frame1("First Frame");
		Frame2 f2 = new Frame2("Second Frame");      
	}

} 
