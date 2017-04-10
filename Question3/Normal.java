/**
 * 
 * @author Jarvis
 *Normal Girl class inheriting the Girl class.
 */
class Normal extends girl{

	Normal(String name,int attract,int expense,int intellect,String status,String type){

			super(name,attract,expense,intellect,status,type);
			
	}

	void calc_happiness(gift gft[],int n){
		
		// defines happiness of a Normal Girl.

		int sum = 0,i;
		for(i=0;i<n;i++){
			sum = sum + gft[i].price+gft[i].value;
		}

		this.happiness =  sum - this.expense ;


	}

}