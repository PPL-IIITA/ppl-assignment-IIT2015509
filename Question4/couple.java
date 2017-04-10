/**
 * Couple class that stores information about the couples formed
 * @author Nimish
 *
 */
public class couple {

	/* Couple Attributes */

	boy boy;
	girl girl;
	int affinity;
	double happiness;
	gift ex[];
	int giftcount;

	// Constructor of the Couple class.

	couple(boy boy,girl girl){
		this.boy = boy;
		this.girl = girl;
		this.affinity = 0;
		this.happiness = 0;
	}

	//Function to calculate happiness of a couple.
	void calc_happiness(){
		this.happiness = this.boy.happiness+this.girl.happiness;

	}

	//Function to calculate compatibility of a couple.
	void calc_affinity(){
		int x = Math.abs(boy.budget - girl.expense);
		int y = Math.abs(boy.attract - girl.attract);
		int z = Math.abs(boy.intellect - girl.intellect);

		this.affinity = x+y+z;
	}
	
	//Gifting amongst the couples
	void calc_gifts(gift gft[],int n){

		this.ex = new gift[50];


		String type = this.boy.type;
		int gift_count = 0;
		int i,sum;
		switch(type){
		
		//Gifts by a miser Boy
			case "Miser":
				
				 sum = 0;
				
				if(gft[0].price>= this.boy.budget){
					this.boy.budget = gft[0].price;
					this.ex[0] = gft[0];
					sum = gft[0].price;
					
					gift_count =1;

				}
				else if(gft[0].price < this.boy.budget &&  gft[0].price>this.girl.expense){
					ex[0] = gft[0];
					gift_count = 1;
					sum = gft[0].price;

				}
				else{
					for(i=0;i<n;i++){
						sum += gft[i].price;
						if(sum <this.girl.expense ){
							this.ex[gift_count++] =gft[i]; 
						}
						else
							break;
					}
				}




				//	System.out.println(gift_count);
				//	System.out.println(this.ex[0].name);
				this.boy.calc_happiness(this.boy.budget-sum);
				this.giftcount = gift_count;
				this.girl.calc_happiness(ex,gift_count);

				break;

		
		// Gifts by a Generous Boy
			case "Generous":
				sum = 0;
				if(gft[n-1].price >= this.boy.budget){
					this.boy.budget = gft[n-1].price;
					this.ex[0] = gft[n-1]; 
					gift_count = 1;

				}
				else{
					int l;
					//	System.out.println("hi");
					for(l=n-1;l>=0;l--){
						sum += gft[l].price;
						if(sum < this.boy.budget){
								this.ex[gift_count++] = gft[l];
						}
						else
							break;
					}
				}


				this.giftcount = gift_count;
				this.girl.calc_happiness(ex,gift_count);
				this.boy.calc_happiness(this.girl.happiness);


				break;


		//Gifts by a Geeky Boy
			case "Geeky":
				sum=0;
				if(gft[0].price >= this.boy.budget){
					this.boy.budget = gft[0].price;
					this.ex[0] = gft[0];
					gift_count =1;

				}
				else if(gft[0].price<this.boy.budget && gft[0].price>this.girl.expense){
					ex[0] = gft[0];
					gift_count = 1;

				}
				else{
					for(i=0;i<n;i++){
						sum += gft[i].price;
						if(sum <this.girl.expense ){
							this.ex[gift_count++] =gft[i]; 
						}
						else
							break;
					}
				}
				boolean flag = false;
				for(i=1;i<n;i++){
					if ((gft[i].type.equals("Luxury")) && (this.boy.budget- sum ) > gft[i].price){
						for(gift p : ex){
							if(gft[i] == p){
								flag = true;
							}
						}
						if(flag == true){
							continue;
						}
						else{
							ex[gift_count++] =gft[i];


							break;
						}
					}
				}


				//System.out.println(gift_count);
				//System.out.println(this.ex[0].name);

				this.giftcount = gift_count;
				this.boy.calc_happiness((double)this.girl.intellect);
				this.girl.calc_happiness(ex,gift_count);


				break;



		}
	}
}
