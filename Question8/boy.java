/**
 * Boy class defining the boys
 * @author Nimish
 *
 */
public abstract class boy{

	String name;
	int attract;
	int intellect;
	public int budget;
	int requirement;
	String status;
	String gf;
	double happiness;
	String type;

	//Constructor for the boy class.

	boy(String name,int attract,int intellect,int budget,int requirement,String status,String type){

		this.name = name;
		this.attract = attract;
		this.intellect = intellect;
		this.budget = budget;
		this.requirement = requirement;
		this.status = status;
		this.gf = "";
		this.type = type;
	
	}

	//Matches the guy with his perfect one :D
	boolean match(girl g){
		if(this.budget >=g.expense && this.requirement <= g.attract){
			return true;

		}
		else{
			return false;
		}
	}
	
	abstract void calc_happiness(double value);


	}


