/**
 * @author Nimish
 * utility class to generate required csv files for the program.
 */
import java.io.*;
import java.util.*;

public class csvutility {
	static void csv(){

		Random rand = new Random();
		int i;
		try{
			FileWriter b = new FileWriter("boys.csv");

			String boy[] = {"Jon Snow","Hodor","Jaime Lannister","Theon Greyjoy","Daario Naharis","Tyrion Lannister","Bran Stark","Ramsay Bolton","Mance Rayder","Robb Stark","Grey Wind","Samwell Tarly"};

			String boytype [] ={"Miser","Generous","Geeky"};

			for(i=0;i<12;i++){
				b.write(boy[i] +","+rand.nextInt(11)+","+rand.nextInt(101)+","+rand.nextInt(1001)+","+rand.nextInt(10)+","+"Single"+","+boytype[rand.nextInt(3)] +"\n");

			}

			FileWriter g = new FileWriter("girls.csv");
			String girl[] ={"Daenerys Targaryen","Talisa","Sansa Stark","Cersei Lannister","Ygritte","Arya Stark","Melisandre"};

			String girltype[] = {"Choosy","Normal","Desperate"};

			for(i=0;i<7;i++){
				g.write(girl[i] +","+rand.nextInt(11)+","+rand.nextInt(1001)+","+rand.nextInt(101)+","+"Single"+","+girltype[rand.nextInt(3)]+"\n");

			}

			FileWriter gift = new FileWriter("gifts.csv");

			String gifttype[] = {"Essential","Luxury","Utility"};
			for(i=1;i<=50;i++){
				gift.write("Gift"+i +"," + rand.nextInt(1000) +","+rand.nextInt(50)+","+gifttype[rand.nextInt(3)]+"\n");
			}
			b.close();
			g.close();
			gift.close();
		} catch (IOException e) {
			// do something
		}
	}
}
