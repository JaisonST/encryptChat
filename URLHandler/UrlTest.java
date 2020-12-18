import java.net.*; 
import java.io.*;

public class UrlTest{

	//insert ip of server here 
	static String ip = "http://94.204.183.143/";
 
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

	public static void responseList(String json){
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

	public static void main(String ar[]){
		//boolean a = login("jaisonmanu@gmail.com","123456"); 
		//System.out.println(a);

		String response = returnVal("test.php");
		responseList(response);
	 
	}	
 

}
