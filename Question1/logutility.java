import java.io.*;
public class logutility {
	
	 static void logging(String str){
		
		try(FileWriter f0 = new FileWriter("1.log")){
			f0.write(str);			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
