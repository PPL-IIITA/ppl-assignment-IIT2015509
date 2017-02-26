public class boy{
	/**
	 * The given attributes defines a boy;
	 */

	String name;
	int attract;
	int intellect;
	public int budget;
	int requirement;
	String status;
	String gf;
	//Constructor of the boy class.

	boy(String name,int attract,int intellect,int budget,int requirement,String status){

		this.name = name;
		this.attract = attract;
		this.intellect = intellect;
		this.budget = budget;
		this.requirement = requirement;
		this.status = status;
		this.gf = "";

	}
	//Matches the guy with her perfect one :D 

	boolean match(girl g){
		if(this.budget >=g.expense && this.requirement <= g.attract){
			return true;

		}
		else{
			return false;
		}
	}
}

