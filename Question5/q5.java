/**
 * @author Nimish
 * Main class that drives the entire program
 */
import java.io.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.concurrent.ThreadLocalRandom;
public class q5 {
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
	
		int choice = ThreadLocalRandom.current().nextInt(1, 3);
		System.out.println("Generating couples with the Implementation " + choice);
		System.out.println("\n");
	switch (choice){
				
	case 1 :	for(l=0;l<i;l++){
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
				break;
	case 2:
		
			boolean flag = true;;
			int cg=0,cb=0;
		
			while(cg < j && cb < i){
				
				if(flag){
					
						flag = false;
						for(l=0;l<i;l++){
							if(b[l].status.equals("Single") && g[cg].status.equals("Single") && g[cg].match(b[l]) && b[l].match(g[cg])){
								g[cg].status = "Committed";
								g[cg].bf = b[l].name;
								b[l].status = "Committed";
								b[l].gf  = g[cg].name;
								count ++;
								
								System.out.println(b[l].name + " is in relationship with " + g[cg].name);
								log = log.concat(time + " - Committment : "+b[l].name + " and "+ g[cg].name+"\n");
								logutility.logging(log);
								cpl[count-1] = new couple(b[l],g[cg]);
								
								break;
							}
						}
						cg++;
				}
						
					else{
							flag = true;
							
							for(m=0;m<j;m++){
								if(g[m].status.equals("Single") && b[cb].status.equals("Single") && b[cb].match(g[m]) && g[m].match(b[cb])){
									
									b[cb].status = "Committed";
									b[cb].gf = g[m].name;
									g[m].status = "Committed";
									g[m].bf  = b[cb].name;
									count ++;
									
									System.out.println(g[m].name + " is in relationship with " + b[cb].name);
									log = log.concat(time + " - Committment : "+g[m].name + " and "+ b[cb].name+"\n");
									logutility.logging(log);
									cpl[count-1] = new couple(b[cb],g[m]);
									
								
									break;
	
							}
							
						}
					cb++;
					
				}
			
			
		}
			
		break;
	}
		
		
		//System.out.println(count);
		gift.sort(gft,k);

		int n;	
		/*for(n=0;n<k;n++){
		  System.out.println(gft[n].name +"," + gft[n].price +","+gft[n].value+","+gft[n].type);
		  }*/
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




	}				
}
