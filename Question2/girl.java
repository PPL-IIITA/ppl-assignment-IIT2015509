import java.sql.Time;
import java.text.SimpleDateFormat;

//Atttributes defining a girl.
public class girl {

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
		this.happiness = 0;
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

	//The joy in the life of a girl.

	void calc_happiness(gift gft[],int n){


		int i;		
		String type = this.type;

		switch(type){

			//Defines happiness of a Choosy Girl

			case "Choosy":
				int sum = 0;
				for(i=0;i<n;i++){
					sum += gft[i].price;
					if(gft[i].type.equals("Luxury")){
						sum += 2*(gft[i].value);
						//	System.out.println(sum);
					}
				}

				this.happiness = Math.log(sum - this.expense);

				break;
				// defines happiness of a Normal Girl.

			case "Normal":
				sum = 0;
				for(i=0;i<n;i++){
					sum = sum + gft[i].price+gft[i].value;
				}

				this.happiness = sum - this.expense;

				break;

				// defines happiness of a desperate girl

			case "Desperate":

				sum = 0;
				for(i=0;i<n;i++){
					sum +=gft[i].price;
				}

				this.happiness = Math.exp(sum - this.expense);

				break;
		}
	}
}
