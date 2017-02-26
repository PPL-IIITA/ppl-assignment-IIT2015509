public class girl {
	
	/* These attributes define a girl .
	*/
	String name;
	int attract;
	int expense;
	int intellect;
	String status;
	String bf ;
	

	//Constructor of the girl class.

	girl(String name,int attract,int expense,int intellect,String status){
		this.name = name;
		this.attract = attract;
		this.expense = expense;
		this.intellect = intellect;
		this.status = status;
		this.bf = "";

	}

	// Function to look for her prince charming !!

	boolean match(boy b){

		if(this.expense <= b.budget ){
			return true;
		}
		else{
			return false;

		}
	}
}
