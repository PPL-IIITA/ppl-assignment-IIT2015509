/* Creates a file named 1.log and stores logs related to the code*/

import java.io.*;
public class logutility {

	static void logging(String str){

		try(FileWriter f0 = new FileWriter("1.log")){ // String directed to the file .
			f0.write(str);			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
