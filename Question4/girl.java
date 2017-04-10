/**
 * 
 * @author Nimish
 *The main Girl class of the Question.
 */
public abstract class girl {

	String name;
	int attract;
	int expense;
	int intellect;
	String status;
	String bf ;
	double happiness;
	String type;

	//Constructor for the girl class.

	girl(String name,int attract,int expense,int intellect,String status,String type){
		this.name = name;
		this.attract = attract;
		this.expense = expense;
		this.intellect = intellect;
		this.status = status;
		this.bf = "";
		this.type = type;
		
	}

	//Function to find whether a boy is her prince charming !!

	boolean match(boy b){

		if(this.expense <= b.budget ){
			return true;
		}
		else{
			return false;

		}
	}
	
	abstract void calc_happiness(gift ex[],int gift_count);
	
}



