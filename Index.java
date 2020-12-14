import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;

class Screen extends JFrame{
	Screen(String sc){
		setTitle(sc); 
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
			login = false; 
			home = true; 
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
			home = false; 
			login = true; 
		}
	
	}

 	static boolean login = true; 
	static boolean home = false;

	static LoginScreen ls = new LoginScreen("LoginScreen");
	static HomeScreen hs = new HomeScreen("HomeScreen");  
	
	public void screenSetState(HomeScreen hs, LoginScreen ls){
		for(;;){
			if(login){
				hs.isVisible(false); 
				ls.isVisible(true); 
			}else if(home){
				ls.isVisible(false); 
				hs.isVisible(true); 
			} 
			try{
				Thread.sleep(100);  
			}catch(InterruptedException e){}
		} 
	}
  	
	public static void main(String ar[]){
		Index mainProg = new Index(); 
		mainProg.start();  
	}

	public void run(){
		screenSetState(hs,ls);
	} 

} 
