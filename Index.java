import UIComp.*;
import URLHandler.*; 
import AES.*; 
import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;
import java.util.*;

class Users{
	public String username, email, password;
}

public class Index extends Thread{
	static KeyClass aes = new KeyClass(); 
	static UrlTest server = new UrlTest();
	static Users user = new Users();
	static ArrayList<HashMap<String,String>> chats; 
	static ArrayList<HashMap<String,String>> contacts;
	static boolean loginState = false; 

	static class DecryptText extends Thread{
		ArrayList<HashMap<String,String>> cs;
		String keyVal;  
		public DecryptText(ArrayList<HashMap<String,String>> val, String k){
			cs = val;
			keyVal = k;  
		}
	
		public ArrayList<HashMap<String,String>> getText(){
			return cs; 
		}
		
		@Override 
		public void run(){
			for(HashMap<String,String> c:cs){
				String t = c.get("text");
				t = aes.decrypt(t,keyVal);
				System.out.println(t); 
			 	c.replace("text", t);
			}
		}

	} 
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
				if(!encrypKey.getText().isEmpty())
					chatText = aes.encrypt(chatText,encrypKey.getText()); 
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
					if(!hs.encrypKey.getText().isEmpty()){
						
						DecryptText d = new DecryptText(chats,hs.encrypKey.getText());
						d.start(); 

						try{
							d.join(); 
						}catch (Exception e){

						}
						chats = d.getText(); 
					}
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
