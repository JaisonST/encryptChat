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

	public Map<String,String> getKeyVal(String res){
		if(res.indexOf("{")==-1){
			return null; 
		}

		int keyO = res.indexOf("\"");
		int keyC = res.indexOf("\"", keyO+1);  
		int valO = res.indexOf("\"", keyC+1);  
		int valC = res.indexOf("\"", valO+1);  

		Map<String,String> user = new HashMap<String,String>(); 
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
	

	public void responseList(String json){
		int openB =json.indexOf("{");		
		int prevB = 0;
		int closeB = json.indexOf("}", prevB);
		
		while(openB!=-1 && closeB!=-1){
			String obj = json.substring(openB+1, closeB);
			System.out.println(obj);

			prevB = closeB;
			openB = json.indexOf("{", prevB);
			closeB = json.indexOf("}",openB);
		}
	} 

	

}
