import java.io.*;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class q1 {
	public static void main(String args[]){


		csvutility.csv(); //Calls the csvutility to generate required csv files.


		/* Parses the csv file and stores data in the boy objects. */

		int i=0;
		boy  b[] = new boy[1000];
		String csvfile = "boys.csv";
		String line = "";
		String csvSplit = ",";
		BufferedReader br = null;

		try{
			br = new BufferedReader(new FileReader(csvfile));
			while(( line = br.readLine() )!= null) { 

				String[] boys= line.split(csvSplit);
				int attract = Integer.parseInt(boys[1]);
				int intellect = Integer.parseInt(boys[2]);
				int budget = Integer.parseInt(boys[3]);
				int requirement = Integer.parseInt(boys[4]);
				b[i]  = new boy(boys[0],attract,intellect,budget,requirement,boys[5]);

				i++;
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

		/* Parses the girls.csv file to store data in girl objects. */

		int j = 0;
		girl  g[] = new girl[1000];
		csvfile = "girls.csv";
		line = "";
		csvSplit = ",";
		br = null;

		try{
			br = new BufferedReader(new FileReader(csvfile));
			while(( line = br.readLine() )!= null) { 

				String[] girls= line.split(csvSplit);
				int  attract = Integer.parseInt(girls[1]);
				int expense  = Integer.parseInt(girls[2]);
				int intellect= Integer.parseInt(girls[3]);
				g[j] = new girl(girls[0],attract,expense,intellect,girls[4]);

				j++;
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 


		int k,l;

		/* String generation for log file .
		   Creates the desired string and passes to function*/

		String time;
		String log = "";
		time = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Time(System.currentTimeMillis()));

		/* Shaadi.com of the code snippet where we find matches !!*/
		for(k=0;k<i;k++){
			for(l=0;l<j;l++){
				if(b[k].match(g[l]) && g[l].match(b[k]) && b[k].status.equals("Single") && g[l].status.equals("Single")){
					b[k].gf = g[l].name;
					g[l].bf = b[k].name;
					b[k].status = "Committed";
					g[l].status = "Committed";

					System.out.println(b[k].name +" is in relationship with "+g[l].name);
					log = log.concat(time + "- Committment :" + b[k].name +" is commmitted to  "+ g[l].name +"\n" );

					logutility.logging(log);
					break;


				}
			}
		}

	}
}

