import java.io.*;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class q2 {
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
				b[i]  = new boy(boys[0],attract,intellect,budget,requirement,boys[5],boys[6]);

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
				g[j] = new girl(girls[0],attract,expense,intellect,girls[4],girls[5]);

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
		System.out.println("The Happy Couples in Descending Order are : ");
		for(i=0;i<count ;i++){
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
		System.out.println("The best compatible couples in Decreasing order are :");
		for(i=0;i<count;i++){
			System.out.println(cpl[i].boy.name + " -- "+ cpl[i].girl.name);
		}





	}				
}
