/**
 * @author Nimish
 * Desperate Girl class inherited from the girl class.
 */
class Desperate extends girl{

	Desperate(String name,int attract,int expense,int intellect,String status,String type){

			super(name,attract,expense,intellect,status,type);
		
	}
	
	// defines happiness of a desperate girl
	void calc_happiness(gift gft[],int n){
		
		int sum = 0,i;
		for(i=0;i<n;i++){
			sum +=gft[i].price;
		}
		
		 this.happiness = Math.exp(sum - this.expense);

	}
}
