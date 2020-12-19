import UIComp.LoginScreenUI;
import URLHandler.*; 

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

class Users{
	public String username, email, password;
}

public class Index extends Thread{
	static UrlTest server = new UrlTest();
	static Users user = new Users();

	static class LoginScreen extends LoginScreenUI implements ActionListener{
		public LoginScreen(){
			super();
			btn.addActionListener(this);
		} 
		public static String id = "LoginScreen"; 
		
		public void actionPerformed(ActionEvent e){
			user.email = username.getText();
			user.password = password.getText();
			
			boolean res = server.login(user.email,user.password);
			if(res)
				screenSetState(hs.id);
			else
				this.setError(true);
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
	static LoginScreen ls = new LoginScreen();
	
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
		screenSetState(ls.id); 
		//Index mainProg = new Index(); 
		//mainProg.start();
	}

	//public void run(){
	//  	screenSetState(hs,ls);
	//} 

} 
