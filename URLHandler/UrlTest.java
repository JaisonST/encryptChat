import java.net.*; 
import java.io.*;

public class UrlTest{

	//insert ip of server here 
	static String ip = "http://94.204./";
 
	public static String returnVal(String call){
		try{
			URL server = new URL(ip + call); 
			BufferedReader in =new BufferedReader(new InputStreamReader(server.openStream()));		
			return in.readLine();
		}catch(Exception ex){
			return null; 
		} 	
	}
	
	public static boolean login(String email, String password){
		String response = returnVal("login.php?id=\""+email+"\"&key=\""+password+"\"");
		if(response.equals("0")){
			return false; 
		}else{
			System.out.println(response); 
			return true; 
		} 

	}
	public static void main(String ar[]){
		boolean a = login("jaisonmanu@gmail.com","123456"); 
		System.out.println(a); 
	}	
 

}
