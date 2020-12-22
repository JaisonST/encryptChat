import UIComp.*;
import URLHandler.*; 

import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;
import java.util.*;

class Users{
	public String username, email, password;
}

public class Index extends Thread{
	static UrlTest server = new UrlTest();
	static Users user = new Users();
	static ArrayList<HashMap<String,String>> chats; 
	static ArrayList<HashMap<String,String>> contacts;
	static boolean loginState = false;  
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
			if(res){
				screenSetState(hs.id);
				contacts = server.getContacts(user.email);
				hs.setContacts(contacts);  
			}
			else
				this.setError(true);
		}
	
	}

	
	static class HomeScreen extends HomeScreenUI implements ActionListener{
		public HomeScreen(){
			super();
			logout.addActionListener(this);
			send.addActionListener(this);
		}
 
		public static String id = "HomeScreen"; 

		public void actionPerformed(ActionEvent e){
			if(e.getSource() == logout){
			
				user.email = null;
				user.password = null;

				screenSetState(ls.id);
			}
			else{
				String chatText = text.getText();
				String modified = chatText.replace(" ","%20"); 
				server.sendChat(user.email,"",modified,selectedChat);
				text.setText("");
			} 
		}
	
	}

	static HomeScreen hs = new HomeScreen();  
	static LoginScreen ls = new LoginScreen();
	
	public static void screenSetState(String val){
			if(val.equals(ls.id)){
				loginState = false; 
				hs.isVisible(false); 
				ls.isVisible(true); 
			}else if(val.equals(hs.id)){
				ls.isVisible(false);
				loginState = true;  
				hs.isVisible(true); 
			} 
  	}
	
	public static void main(String ar[]){
		screenSetState(ls.id); 
		Index mainProg = new Index(); 
		mainProg.start();
	}

	public void run(){
		for(;;){
		  	if(loginState){
				if(hs.selectedChat!=null){
					chats = server.getChats(hs.selectedChat);
					hs.setChats(chats, user.email); 
				}
			}

			//to ensure nothing crashes
			try{
				Thread.sleep(400);  
			}catch(InterruptedException e){}
		}
	} 

} 
