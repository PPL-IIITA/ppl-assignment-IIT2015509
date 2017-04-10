/**
 * Choosy Girl class inheriting the girl class 
 * @author Nimish
 */
class Choosy extends girl{


	Choosy(String name,int attract,int expense,int intellect,String status,String type){

			super(name, attract, expense, intellect, status,type);
	}
//Happiness of a Choosy Girl
	void calc_happiness(gift gft[],int n){
		int sum = 0,i;
				for(i=0;i<n;i++){
					sum += gft[i].price;
					if(gft[i].type.equals("Luxury")){
						sum += 2*(gft[i].value);
						//	System.out.println(sum);
					}
				}

		this.happiness =  Math.log(sum - this.expense);

	}

}