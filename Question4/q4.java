/**
 * @author Nimish
 * Main class that drives the entire program.
 */
import java.io.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.concurrent.ThreadLocalRandom;
public class q4 {
	public static void main(String args[]){

		int i = 0;
		csvutility.csv();
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

// Parsing data from boys.csv
			switch(boys[6]){

					case "Miser":
								b[i]  = new Miser(boys[0],attract,intellect,budget,requirement,boys[5],boys[6]);
								break;

					case "Generous":
								b[i]  = new Generous(boys[0],attract,intellect,budget,requirement,boys[5],boys[6]);
								break;

					case "Geeky":
								b[i]  = new Geeky(boys[0],attract,intellect,budget,requirement,boys[5],boys[6]);
								break;

			}
				
				i++;
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
// Parsing data from girls.csv
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

			switch(girls[5]){

					case "Choosy":
								g[j] = new Choosy(girls[0],attract,expense,intellect,girls[4],girls[5]);
								break;

					case "Normal":
								g[j] = new Normal(girls[0],attract,expense,intellect,girls[4],girls[5]);
								break;

					case "Desperate":
								g[j] = new Desperate(girls[0],attract,expense,intellect,girls[4],girls[5]);
								break;

			}

				j++;
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//Parsing data from gifts.csv
		int k=0;
		gift gft[] = new gift[100];
		csvfile = "gifts.csv";
		line = "";
		csvSplit = ",";
		br = null;
		try{
			br = new BufferedReader(new FileReader(csvfile));
			while(( line = br.readLine() )!= null) { 

				String[] gifts= line.split(csvSplit);
				int price = Integer.parseInt(gifts[1]);
				int value = Integer.parseInt(gifts[2]);
				gft[k]  = new gift(gifts[0],price,value,gifts[3]);
				k++;
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

		couple cpl[] = new couple[100];
		int l,m;	
		int count = 0;
		String time;
		String log = "";
		time = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Time(System.currentTimeMillis()));
		for(l=0;l<i;l++){
			for(m=0;m<j;m++){
				if(g[m].match(b[l]) && b[l].match(g[m]) && b[l].status.equals("Single") && g[m].status.equals("Single")){
					b[l].gf = g[m].name;
					g[m].bf = b[l].name;
					b[l].status = "Committed";
					g[m].status = "Committed";
					count++;

					System.out.println( b[l].name +" is in relationship with "+ g[m].name);
					log = log.concat(time + " -  Committment : " + b[l].name + " and "+ g[m].name+"\n" );
					logutility.logging(log);
					cpl[count-1] = new couple(b[l],g[m]);
					break;
				}
			}

		}
		
		
		gift.sort(gft,k);

		int n;	
		
		for(n=0;n<count;n++){
			cpl[n].calc_gifts(gft,k);
		}

		for(n=0;n<count;n++){
			cpl[n].calc_happiness();
			cpl[n].calc_affinity();
		}

		int o;
		for(n=0;n<count;n++){
			int limit = cpl[n].giftcount;
			for(o=0;o<limit;o++){
				log =log.concat(time + " - : Gift Exchange "+ cpl[n].boy.name +" gifted " + cpl[n].ex[o].name +" to "+cpl[n].girl.name+"\n");
				logutility.logging(log);
			}
		}

	//Sorting couples based on happiness 
		int a,c;
		couple temp;
		for(a=0;a<count;a++){
			for(c=a+1;c<count;c++){
				if(cpl[a].happiness > cpl[c].happiness){
					temp = cpl[a];
					cpl[a] = cpl[c];
					cpl[c] = temp;
				}

			}
		}
		System.out.println("\n");
	
		//Breakup of the K-least happy couples
		int v = ThreadLocalRandom.current().nextInt(1, count);
		int flag = 0;
		int lo,lc;
		System.out.println("The Breakup of K least happy couples with K = " + v );
		for(lo=0; lo<v ;lo++){
			log = log.concat(time +" - : Break-Up " + cpl[lo].girl.name + " is breaking up with " + cpl[lo].boy.name+"\n");
			logutility.logging(log);
			System.out.println(cpl[lo].girl.name + " is breaking up with "+ cpl[lo].boy.name);
			cpl[lo].boy.status ="Single";
			cpl[lo].girl.status = "Single";
				
			cpl[lo].boy.gf = "";
				
		}
	
		
		System.out.println("\n");
		for(lo=0;lo<v;lo++){
			for(lc=0;lc<i;lc++){
				if(b[lc].name.equals(cpl[lo].girl.bf)){
					continue;
				}
				else if(cpl[lo].girl.match(b[lc]) && b[lc].match(cpl[lo].girl) && b[lc].status == "Single"){
					flag = 1;
					b[lc].status = "Committed";
					cpl[lo].girl.status = "Committed";
					log = log.concat(time + " -  Committment After Breakup : " + cpl[lo].girl.name + " and "+ b[lc].name+"\n");
					logutility.logging(log);
					System.out.println(cpl[lo].girl.name + " is in relationship after a breakup with " +b[lc].name );
					b[lc].gf = cpl[lo].girl.name;
					cpl[lo].boy = b[lc];
					cpl[lo].calc_happiness();
					cpl[lo].calc_affinity();
					break;
				}
				
				
			}
		}
		if(flag == 0 && v!=0){
			System.out.println("No matchup found for the broke girls");
		}
		
		

	}				
}
