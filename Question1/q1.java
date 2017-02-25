import java.io.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
public class q1 {
	public static void main(String args[]){
		
	int i = 0;
	utility.csv();
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
	String time;
	String log = "";
	time = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Time(System.currentTimeMillis()));
	for(k=0;k<i;k++){
		for(l=0;l<j;l++){
			if(b[k].match(g[l]) && g[l].match(b[k]) && b[k].status.equals("Single") && g[l].status.equals("Single")){
				b[k].gf = g[l].name;
				g[l].bf = b[k].name;
				b[k].status = "Committed";
				g[l].status = "Committed";
				log = log.concat(time + ":" + b[k].name +" is commmitted to  "+ g[l].name +"\n" );
				
				logutility.logging(log);
				break;
				
				//System.out.println("U there ??");
				
			}
		}
	}
	
	for(k=0;k<i;k++){
		System.out.println(b[k].name  + ","+ b[k].attract + ","+b[k].intellect +","+b[k].budget+","+b[k].status +","+b[k].gf);
	}
	for(k=0;k<j;k++){
		System.out.println(g[k].name  + ","+ g[k].attract + ","+g[k].intellect +","+g[k].expense +","+g[k].status+","+g[k].bf);
	}
	}
}
				
