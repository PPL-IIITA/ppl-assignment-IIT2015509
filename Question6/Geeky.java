/**
 * @author Nimish
 * Geeky Boy class inherited from the Boy class.
 */
class Geeky extends boy{	

	Geeky(String name,int attract,int intellect,int budget,int requirement,String status,String type){

		super(name,attract,intellect,budget,requirement,status,type);
		
	}


//	Method to calculate happiness of a Generous Boy	
	void calc_happiness(double value){
		
		this.happiness = (double)value;
		
	}
	
}
