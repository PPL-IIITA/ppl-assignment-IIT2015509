/* Utility class to generate csv files of boys and girls*/

import java.io.*;
import java.util.*;


public class csvutility {
	static void csv(){
		try{
			FileWriter b = new FileWriter("boys.csv");
			int i;
			String boy[] = {"Jon Snow","Hodor","Jaime Lannister","Theon Greyjoy","Daario Naharis","Tyrion Lannister","Bran Stark","Ramsay Bolton","Mance Rayder","Robb Stark","Grey Wind","Samwell Tarly"};

			Random rand = new Random();
			for(i=0;i<12;i++){
				b.write(boy[i] +","+rand.nextInt(11)+","+rand.nextInt(101)+","+rand.nextInt(1001)+","+rand.nextInt(10)+","+"Single"+"\n");

			}

			FileWriter g = new FileWriter("girls.csv");
			String girl[] ={"Daenerys Targaryen","Talisa","Sansa Stark","Cersei Lannister","Ygritte"};
			for(i=0;i<5;i++){
				g.write(girl[i] +","+rand.nextInt(11)+","+rand.nextInt(1001)+","+rand.nextInt(101)+","+"Single"+"\n");

			}
			b.close();
			g.close();
		} catch (IOException e) {
			// do something
		}
	}
}
