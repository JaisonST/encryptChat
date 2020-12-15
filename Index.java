import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;

class Screen extends JFrame{
	public String id; 
	Screen(String sc){
		setTitle(sc); 
		id = sc;  
		setSize(1000,600); 
	  	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setVisible(false); 
	}
	
	public void isVisible(boolean val){
		setVisible(val); 
	}

} 


public class Index extends Thread{
	
	static class LoginScreen extends Screen implements ActionListener{
		public LoginScreen(String a){
			super(a);
			JButton b = new JButton("Switch");
			b.addActionListener(this);
			add(b);    
		} 

		public void actionPerformed(ActionEvent e){
			screenSetState(hs.id); 
		}
	
	}
	
	static class HomeScreen extends Screen implements ActionListener{
		
		public HomeScreen(String a){
			super(a); 
			JButton b = new JButton("Switch");
			b.addActionListener(this);
			add(b);    
		}
 
		public void actionPerformed(ActionEvent e){
			screenSetState(ls.id);  
		}
	
	}

	

	static HomeScreen hs = new HomeScreen("HomeScreen");  
	static LoginScreen ls = new LoginScreen("LoginScreen");
	
	public static void screenSetState(String val){
			if(val.equals(ls.id)){
				hs.isVisible(false); 
				ls.isVisible(true); 
			}else if(val.equals(hs.id)){
				ls.isVisible(false); 
				hs.isVisible(true); 
			} 
  	}
	
	public static void main(String ar[]){
		screenSetState(hs.id); 
		System.out.println(hs.id); 
		System.out.println(ls.id); 
		//Index mainProg = new Index(); 
		//mainProg.start();  
	}

	//public void run(){
	//  	screenSetState(hs,ls);
	//} 

} 
