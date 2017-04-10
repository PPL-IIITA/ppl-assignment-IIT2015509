/**
 * @author Nimish
 * Utility class that stores information in the log file .
 */
import java.io.*;
public class logutility {

	static void logging(String str){

		try(FileWriter f0 = new FileWriter("4.log")){
			f0.write(str);			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
