/**
 * 
 * @author Nimish
 * Miser Boy class inheriting the Boy class,
 *
 */
class Miser extends boy{


	Miser(String name,int attract,int intellect,int budget,int requirement,String status,String type){
		super(name,attract,intellect,budget, requirement,status,type);
	}
	
	void calc_happiness(double value){
		this.happiness = value;
	}
}

