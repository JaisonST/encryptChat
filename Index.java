import UIComp.*;
import URLHandler.*; 

import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;


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

	
	static class HomeScreen extends HomeScreenUI implements ActionListener{
		public HomeScreen(){
			super();
			logout.addActionListener(this);
		}
 
		public static String id = "HomeScreen"; 

		public void actionPerformed(ActionEvent e){
			user.email = null;
			user.password = null;

			screenSetState(ls.id);
		}
	
	}

	static HomeScreen hs = new HomeScreen();  
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
