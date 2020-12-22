package URLHandler;

import java.util.*;
import java.net.*; 
import java.io.*;

public class UrlTest{

	//insert ip of server here 
	String ip = "http://94.204.183.143/";
 
	public String returnVal(String call){
		try{
			URL server = new URL(ip + call); 
			BufferedReader in =new BufferedReader(new InputStreamReader(server.openStream()));		
			return in.readLine();
		}catch(Exception ex){
			return null; 
		} 	
	}

	public HashMap<String,String> getKeyVal(String res){
		if(res.indexOf("{")==-1){
			return null; 
		}

		int keyO = res.indexOf("\"");
		int keyC = res.indexOf("\"", keyO+1);  
		int valO = res.indexOf("\"", keyC+1);  
		int valC = res.indexOf("\"", valO+1);  

		HashMap<String,String> user = new HashMap<String,String>(); 
		while(keyO!=-1&&keyC!=-1&&valO!=-1&&valC!=-1){
			String key = res.substring(keyO+1, keyC); 
			String val = res.substring(valO+1, valC);
			user.put(key,val); 
 
			keyO = res.indexOf("\"", valC+1);
			keyC = res.indexOf("\"", keyO+1);  
			valO = res.indexOf("\"", keyC+1);  
			valC = res.indexOf("\"", valO+1);  

		}
		return user; 
			
	}
	
	public boolean login(String email, String password){
		String response = returnVal("login.php?id=\""+email+"\"&key=\""+password+"\"");
		if(response.equals("0")){
			return false; 
		}else{
			Map<String,String> user = getKeyVal(response);
			if(user==null)
				 return false; 
			else if(user.get("email").equals(email)){
				return true; 
			} 
		} 

		return false; 

	}
	
	public ArrayList<HashMap<String,String>> getChats(String chatid){
		String response = returnVal("getChats.php?chat="+chatid); 
		ArrayList<String> l = responseList(response); 
		ArrayList<HashMap<String,String>> cl = new ArrayList<HashMap<String,String>>();
		if(response.equals("0")){
			return null; 
		}else{
			for(String c : l){
				HashMap<String,String> chat = getKeyVal(c); 
				cl.add(chat);  
			}
			
			return cl;  
		} 
		 
	}

	public ArrayList<HashMap<String,String>> getContacts(String id){
		String response = returnVal("getContacts.php?id=\""+id+"\""); 
		ArrayList<String> l = responseList(response); 
		ArrayList<HashMap<String,String>> cl = new ArrayList<HashMap<String,String>>();
		if(response.equals("0")){
			return null; 
		}else{
			for(String c : l){
				HashMap<String,String> chat = getKeyVal(c); 
				cl.add(chat);  
			}
			return cl; 	
		}
	}
	

	public ArrayList<String> responseList(String json){
		int openB =json.indexOf("{");		
		int prevB = 0;
		int closeB = json.indexOf("}", prevB);
		ArrayList<String> m = new ArrayList<String>(); 
		
		while(openB!=-1 && closeB!=-1){
			String obj = json.substring(openB, closeB+1); 
			m.add(obj);
			prevB = closeB;
			openB = json.indexOf("{", prevB);
			closeB = json.indexOf("}",openB);
		}

		return m;
	} 
	
	public void sendChat(String id,String fid , String text, String chatid){
		String response = returnVal("sendChat.php?id="+id+"&fid="+fid+"&text="+text+"&chat="+chatid); 
	
	} 

}
