import java.sql.Time;
import java.text.SimpleDateFormat;

public class algos {
	
	
	static void  array(boy list[],int s){
		String time;
		String log = "";
		time = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Time(System.currentTimeMillis()));
		int i;
		for(i=0;i<s;i++){
			
			if(list[i].status.equals("Single")){
				System.out.println(list[i].name + " is not committed to anyone s found by array implementation");
				log = log.concat(time + " - Searching Operation: " + list[i].name + " not committed to anyone as found by array implementation\n" );
				logutility.logging(log);
			}
			else{
				System.out.println(list[i].name + " is committed to " + list[i].gf + " as found by array implementation");
				log = log.concat(time + " - Searching Operation: " + list[i].name + " is committed to "+ list[i].gf + " as found by array implementation\n" );
				logutility.logging(log);
				
			}
		}
	}
	
	static void BinarySearch(boy list[],int s){
		String time;
		String log = "";
		time = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Time(System.currentTimeMillis()));
		int i;
		for(i=0;i<s;i++){
			
			if(list[i].status.equals("Single")){
				System.out.println(list[i].name + " is not committed to anyone as found by BinarySearch implementation");
				log = log.concat(time + " - Searching Operation: " + list[i].name + " not committed to anyone as found by BinarySearch implementation \n" );
				logutility.logging(log);
			}
			else{
				System.out.println(list[i].name + " is committed to " + list[i].gf+" s found by BinarySearch implementation");
				log = log.concat(time + " - Searching Operation: " + list[i].name + " is committed to "+ list[i].gf + " as found by BinarySearch implementation\n" );
				logutility.logging(log);
			}
		}
	}
	
	static void hashtable(boy list[],int s){
		String time;
		String log = "";
		time = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Time(System.currentTimeMillis()));
		int i;
		for(i=0;i<s;i++){
			
			if(list[i].status.equals("Single")){
				System.out.println(list[i].name + " is not committed to anyone as found by hashtable implementation");
				log = log.concat(time + " - Searching Operation: " + list[i].name + " not committed to anyone as found by hashtable implementation\n" );
				logutility.logging(log);
			}
			else{
				System.out.println(list[i].name + " is committed to " + list[i].gf + " as found by hashtable implementation");
				log = log.concat(time + " - Searching Operation: " + list[i].name + " is committed to "+ list[i].gf + " as found by hashtable implementation\n" );
				logutility.logging(log);
			}
		}
	}
	
}
