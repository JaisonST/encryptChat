import java.net.*; 
import java.io.*;

public class UrlTest{

	public static void main(String ar[]){
		//insert ip of server here 
		String ip = "http://94.204./"; 
		try{
			URL server = new URL(ip + "test.php"); 
			BufferedReader in =new BufferedReader(new InputStreamReader(server.openStream()));		
			System.out.println(in.readLine());
		}catch(Exception ex){

		} 	
	}	
 

}
