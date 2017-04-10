/**
 * @author Nimish 
 * Main class that drives the entire program.
 */
import java.io.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.concurrent.ThreadLocalRandom;

public class q3 {
	public static void main(String args[]){

		
	//Parses data from boys.csv
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

	//Parses data from girls.csv
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

		
	//Parses data from gifts.csv 
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

	//Couple Creation in Progress <3
		couple cpl[] = new couple[100];
		int l,m;	
		int count = 0;
		String time;
		String log = "";
		time = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Time(System.currentTimeMillis()));
		for(l=0;l<i;l++){
			for(m=0;m<j;m++){
				if(b[l].match(g[m]) && g[m].match(b[l]) && b[l].status.equals("Single") && g[m].status.equals("Single")){
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

		int a,c;
		couple temp;
		for(a=0;a<count;a++){
			for(c=a+1;c<count;c++){
				if(cpl[a].happiness < cpl[c].happiness){
					temp = cpl[a];
					cpl[a] = cpl[c];
					cpl[c] = temp;
				}

			}
		}
		System.out.println("\n");
		
		int v = ThreadLocalRandom.current().nextInt(1, count+1);
		System.out.println("The K most Happy Couples in Descending Order with K = " + v +" are : ");
		for(i=0;i<v ;i++){
			System.out .println(cpl[i].boy.name + " -- " + cpl[i].girl.name);
		}
		for(a=0;a<count;a++){
			for(c=a+1;c<count;c++){
				if(cpl[a].affinity < cpl[c].affinity){
					temp = cpl[a];
					cpl[a] = cpl[c];
					cpl[c] = temp;
				}

			}
		}
		System.out.println("\n");
		System.out.println("The K-best compatible couples in Decreasing order with K = " + v + " are :");
		for(i=0;i<v;i++){
			System.out.println(cpl[i].boy.name + " -- "+ cpl[i].girl.name);
		}





	}				
}
